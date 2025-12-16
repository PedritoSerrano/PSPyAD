package com.salesianostriana.edu.skillhub.service;

import com.salesianostriana.edu.skillhub.model.Category;
import com.salesianostriana.edu.skillhub.model.Course;
import com.salesianostriana.edu.skillhub.model.Lesson;
import com.salesianostriana.edu.skillhub.model.User;
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
