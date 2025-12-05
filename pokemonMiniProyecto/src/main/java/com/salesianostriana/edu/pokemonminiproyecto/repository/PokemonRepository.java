package com.salesianostriana.edu.pokemonminiproyecto.repository;

import com.salesianostriana.edu.pokemonminiproyecto.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
