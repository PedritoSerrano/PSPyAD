package com.salesianostriana.edu.skillhub.repository;

import com.salesianostriana.edu.skillhub.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c JOIN c.categories cat WHERE cat.id = :categoryId")
    List<Course> findByCategoryId(Long categoryId);

    List<Course> findByInstructorId(Long instructorId);

    boolean existsByInstructorIdAndNombre(Long instructorId, String nombre);

    Optional<Course> findByIdAndInstructorId(Long courseId, Long instructorId);
}
