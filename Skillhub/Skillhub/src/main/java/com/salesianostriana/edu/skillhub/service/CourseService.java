package com.salesianostriana.edu.skillhub.service;

import com.salesianostriana.edu.skillhub.model.*;
import com.salesianostriana.edu.skillhub.repository.CategoryRepository;
import com.salesianostriana.edu.skillhub.repository.CourseRepository;
import com.salesianostriana.edu.skillhub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Course createCourseWithLessons(Course course, Long instructorId, List<Lesson> lessons, List<Long> categoryIds) {
        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor no encontrado"));

        if (courseRepository.existsByInstructorIdAndNombre(instructorId, course.getNombre())) {
            throw new RuntimeException("Ya existe un curso con ese título para este instructor");
        }

        course.setInstructor(instructor);

        if (categoryIds != null && !categoryIds.isEmpty()) {
            List<Category> categories = categoryRepository.findAllById(categoryIds);
            course.setCategories(categories);
        }

        if (lessons != null && !lessons.isEmpty()) {
            lessons.forEach(lesson -> lesson.setCourse(course));
            course.setLessons(lessons);
        }

        return courseRepository.save(course);
    }

    @Transactional
    public Course publishCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        if (course.getLessons() == null || course.getLessons().isEmpty()) {
            throw new RuntimeException("El curso debe tener al menos 1 lección para publicarse");
        }

        return courseRepository.save(course);
    }

    @Transactional
    public Lesson addLesson(Long courseId, Lesson lesson) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        if (lesson.getOrderIndex() != null) {
            boolean orderExists = course.getLessons().stream()
                    .anyMatch(l -> l.getOrderIndex() != null && l.getOrderIndex().equals(lesson.getOrderIndex()));
            if (orderExists) {
                throw new RuntimeException("Ya existe una lección con ese orderIndex en el curso");
            }
        }

        lesson.setCourse(course);
        course.getLessons().add(lesson);
        courseRepository.save(course);
        return lesson;
    }

    @Transactional
    public Course reorderLessons(Long courseId, List<Long> lessonIds) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        if (lessonIds.size() != course.getLessons().size()) {
            throw new RuntimeException("La cantidad de lecciones no coincide");
        }

        for (int i = 0; i < lessonIds.size(); i++) {
            Long lessonId = lessonIds.get(i);
            Lesson lesson = course.getLessons().stream()
                    .filter(l -> l.getId().equals(lessonId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Lección no encontrada en el curso"));
            lesson.setOrderIndex(i + 1);
        }

        return courseRepository.save(course);
    }

    public List<Course> findCoursesByCategory(Long categoryId) {
        return courseRepository.findByCategoryId(categoryId);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> findCoursesByInstructor(Long instructorId) {
        return courseRepository.findByInstructorId(instructorId);
    }

    @Transactional
    public Course update(Long id, Course updatedCourse) {
        return courseRepository.findById(id)
                .map(course -> {
                    if (updatedCourse.getNombre() != null &&
                        !updatedCourse.getNombre().equals(course.getNombre()) &&
                        courseRepository.existsByInstructorIdAndNombre(course.getInstructor().getId(), updatedCourse.getNombre())) {
                        throw new RuntimeException("Ya existe un curso con ese título para este instructor");
                    }
                    course.setNombre(updatedCourse.getNombre());
                    course.setDuracionHoras(updatedCourse.getDuracionHoras());
                    return courseRepository.save(course);
                })
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    @Transactional
    public Course addCategoryToCourse(Long courseId, Long categoryId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        if (!course.getCategories().contains(category)) {
            course.getCategories().add(category);
            return courseRepository.save(course);
        }
        return course;
    }

    @Transactional
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
