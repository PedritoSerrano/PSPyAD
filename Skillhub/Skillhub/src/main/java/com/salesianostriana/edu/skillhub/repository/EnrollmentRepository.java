package com.salesianostriana.edu.skillhub.repository;

import com.salesianostriana.edu.skillhub.model.Enrollment;
import com.salesianostriana.edu.skillhub.model.EnrollmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Optional<Enrollment> findByUserIdAndCourseId(Long userId, Long courseId);

    List<Enrollment> findByUserId(Long userId);

    List<Enrollment> findByCourseId(Long courseId);

    boolean existsByUserIdAndCourseId(Long userId, Long courseId);

    boolean existsByUserIdAndCourseIdAndStatusNot(Long userId, Long courseId, EnrollmentStatus status);
}
