package com.salesianostriana.edu.pokemonminiproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Entrenador {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private Equipo equipo;

    

}
