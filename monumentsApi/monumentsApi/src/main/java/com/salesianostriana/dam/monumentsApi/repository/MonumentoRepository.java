package com.salesianostriana.dam.monumentsApi.repository;

import com.salesianostriana.dam.monumentsApi.model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentoRepository extends JpaRepository<Monumento, Long> {

}
