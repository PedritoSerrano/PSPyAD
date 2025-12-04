package com.salesianostriana.edu.tarea04_12.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private String nombreReal;
    private int edad;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
}
