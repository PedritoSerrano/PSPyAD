package com.salesianostriana.edu.skillhub.service;

import com.salesianostriana.edu.skillhub.model.*;
import com.salesianostriana.edu.skillhub.repository.CourseRepository;
import com.salesianostriana.edu.skillhub.repository.EnrollmentRepository;
import com.salesianostriana.edu.skillhub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public Enrollment enroll(Long userId, Long courseId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        if (enrollmentRepository.existsByUserIdAndCourseIdAndStatusNot(userId, courseId, EnrollmentStatus.CANCELLED)) {
            throw new RuntimeException("El usuario ya está matriculado en este curso");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        return enrollmentRepository.save(enrollment);
    }

    @Transactional
    public Enrollment updateProgress(Long enrollmentId, Integer newProgress) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));

        if (enrollment.getStatus() == EnrollmentStatus.CANCELLED) {
            throw new RuntimeException("No se puede actualizar el progreso de una matrícula cancelada");
        }

        if (newProgress < 0 || newProgress > 100) {
            throw new RuntimeException("El progreso debe estar entre 0 y 100");
        }

        if (enrollment.getProgressPercent() != null && newProgress < enrollment.getProgressPercent()) {
            throw new RuntimeException("El progreso no puede disminuir");
        }

        enrollment.setProgressPercent(newProgress);

        if (newProgress == 100) {
            enrollment.setStatus(EnrollmentStatus.COMPLETED);
        }

        return enrollmentRepository.save(enrollment);
    }

    @Transactional
    public Enrollment cancelEnrollment(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));

        enrollment.setStatus(EnrollmentStatus.CANCELLED);
        return enrollmentRepository.save(enrollment);
    }

    public Optional<Enrollment> findByUserAndCourse(Long userId, Long courseId) {
        return enrollmentRepository.findByUserIdAndCourseId(userId, courseId);
    }

    public List<Enrollment> findEnrollmentsByUser(Long userId) {
        return enrollmentRepository.findByUserId(userId);
    }

    public List<Enrollment> findEnrollmentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> findById(Long id) {
        return enrollmentRepository.findById(id);
    }
}
