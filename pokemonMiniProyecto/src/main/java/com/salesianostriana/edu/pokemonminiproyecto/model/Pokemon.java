package com.salesianostriana.edu.pokemonminiproyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pokemon {

    @Id
    @GeneratedValue()
    private Long id;

    private String nombre;

    private Evolucion evolucion;
    

}
