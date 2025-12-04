package com.salesianostriana.edu.tarea04_12.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String juego;
    private String region;
    private int anoFundacion;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Jugador> jugadores = new ArrayList<>();

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
        jugador.setEquipo(this);
    }

    public void removeJugador(Jugador jugador) {
        jugadores.remove(jugador);
        jugador.setEquipo(null);
    }
}
