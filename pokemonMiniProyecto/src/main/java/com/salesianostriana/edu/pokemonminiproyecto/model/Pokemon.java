package com.salesianostriana.edu.pokemonminiproyecto.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pokemon_id", nullable = false)
    private Long id;

    private String nombre;
    private int nivel;
    private Tipo tipo;
    private Evolucion evolucion;
    private double ps;



}
