package com.salesianostriana.edu.skillhub.service;

import com.salesianostriana.edu.skillhub.model.Course;
import com.salesianostriana.edu.skillhub.model.Lesson;
import com.salesianostriana.edu.skillhub.repository.CourseRepository;
import com.salesianostriana.edu.skillhub.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Optional<Lesson> findById(Long id) {
        return lessonRepository.findById(id);
    }

    @Transactional
    public Lesson createLesson(Lesson lesson, Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        lesson.setCourse(course);
        return lessonRepository.save(lesson);
    }

    @Transactional
    public Lesson update(Long id, Lesson updatedLesson) {
        return lessonRepository.findById(id)
                .map(lesson -> {
                    lesson.setTitulo(updatedLesson.getTitulo());
                    lesson.setContenido(updatedLesson.getContenido());
                    lesson.setDuracionMinutos(updatedLesson.getDuracionMinutos());
                    return lessonRepository.save(lesson);
                })
                .orElseThrow(() -> new RuntimeException("Lección no encontrada"));
    }

    @Transactional
    public void delete(Long id) {
        lessonRepository.deleteById(id);
    }
}
