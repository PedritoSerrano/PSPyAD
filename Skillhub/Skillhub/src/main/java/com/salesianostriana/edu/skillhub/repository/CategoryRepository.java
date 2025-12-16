package com.salesianostriana.edu.skillhub.repository;

import com.salesianostriana.edu.skillhub.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
