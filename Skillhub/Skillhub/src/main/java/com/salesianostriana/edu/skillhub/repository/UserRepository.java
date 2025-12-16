package com.salesianostriana.edu.skillhub.repository;

import com.salesianostriana.edu.skillhub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
