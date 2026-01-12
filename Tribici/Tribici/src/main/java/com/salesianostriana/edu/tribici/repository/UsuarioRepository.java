package com.salesianostriana.edu.tribici.repository;

import com.salesianostriana.edu.tribici.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    @Query("select u from Usuario u where u.numTarjeta = ?1 and u.pin = ?2")
    Optional<Usuario> findByNumTarjetaAndPin(int numTarjeta, int pin);
}
