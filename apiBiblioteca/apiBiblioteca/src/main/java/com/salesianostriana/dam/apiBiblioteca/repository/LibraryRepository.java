package com.salesianostriana.dam.apiBiblioteca.repository;

import com.salesianostriana.dam.apiBiblioteca.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
}
