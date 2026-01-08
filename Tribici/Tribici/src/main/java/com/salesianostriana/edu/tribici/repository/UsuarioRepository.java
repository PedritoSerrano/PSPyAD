package com.salesianostriana.edu.tribici.repository;

import com.salesianostriana.edu.tribici.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
