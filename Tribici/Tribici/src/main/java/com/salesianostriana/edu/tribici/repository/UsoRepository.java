package com.salesianostriana.edu.tribici.repository;

import com.salesianostriana.edu.tribici.model.Uso;
import com.salesianostriana.edu.tribici.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsoRepository extends JpaRepository<Uso, Long> {


    @Query("select u from Uso u where u.usuario = ?1 order by u.fechaInicio DESC")
    Uso findByUsuarioOrderByFechaInicioDesc(Usuario usuario);
}
