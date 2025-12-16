package com.salesianostriana.edu.skillhub.repository;

import com.salesianostriana.edu.skillhub.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
