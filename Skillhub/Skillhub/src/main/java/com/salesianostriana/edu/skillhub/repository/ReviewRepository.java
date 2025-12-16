package com.salesianostriana.edu.skillhub.repository;

import com.salesianostriana.edu.skillhub.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByUserIdAndCourseId(Long userId, Long courseId);

    List<Review> findByCourseId(Long courseId);

    List<Review> findByUserId(Long userId);

    boolean existsByUserIdAndCourseId(Long userId, Long courseId);
}
