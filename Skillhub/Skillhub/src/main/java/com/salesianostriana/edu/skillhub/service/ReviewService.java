package com.salesianostriana.edu.skillhub.service;

import com.salesianostriana.edu.skillhub.model.*;
import com.salesianostriana.edu.skillhub.repository.CourseRepository;
import com.salesianostriana.edu.skillhub.repository.EnrollmentRepository;
import com.salesianostriana.edu.skillhub.repository.ReviewRepository;
import com.salesianostriana.edu.skillhub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Transactional
    public Review createOrUpdateReview(Long userId, Long courseId, Integer rating, String comment) {
        if (rating < 1 || rating > 5) {
            throw new RuntimeException("La puntuación debe estar entre 1 y 5");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Enrollment enrollment = enrollmentRepository.findByUserIdAndCourseId(userId, courseId)
                .orElseThrow(() -> new RuntimeException("El usuario debe estar matriculado en el curso para hacer una review"));

        if (enrollment.getStatus() == EnrollmentStatus.CANCELLED) {
            throw new RuntimeException("No se puede crear una review si la matrícula está cancelada");
        }

        Optional<Review> existingReview = reviewRepository.findByUserIdAndCourseId(userId, courseId);

        if (existingReview.isPresent()) {
            Review review = existingReview.get();
            review.setRating(rating);
            review.setComment(comment);
            return reviewRepository.save(review);
        } else {
            Review review = new Review();
            review.setUser(user);
            review.setCourse(course);
            review.setRating(rating);
            review.setComment(comment);
            return reviewRepository.save(review);
        }
    }

    @Transactional
    public Review createReview(Long userId, Long courseId, Integer rating, String comment) {
        if (reviewRepository.existsByUserIdAndCourseId(userId, courseId)) {
            throw new RuntimeException("El usuario ya ha publicado una review para este curso");
        }

        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("El rating debe estar entre 1 y 5");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Review review = new Review();
        review.setUser(user);
        review.setCourse(course);
        review.setRating(rating);
        review.setComment(comment);

        return reviewRepository.save(review);
    }

    @Transactional
    public Review updateReview(Long reviewId, Integer rating, String comment) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("El rating debe estar entre 1 y 5");
        }

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review no encontrada"));

        review.setRating(rating);
        review.setComment(comment);

        return reviewRepository.save(review);
    }

    public Optional<Review> findByUserAndCourse(Long userId, Long courseId) {
        return reviewRepository.findByUserIdAndCourseId(userId, courseId);
    }

    public List<Review> findReviewsByCourse(Long courseId) {
        return reviewRepository.findByCourseId(courseId);
    }

    public List<Review> findReviewsByUser(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Optional<Review> findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}
