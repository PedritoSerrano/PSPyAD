package com.salesianostriana.edu.tarea04_12.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "team_generator")
    @SequenceGenerator(name = "team_generator",
            sequenceName = "team_seq", allocationSize = 1)
    private Long id;

    @Column(length = 255)
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String juego;
    private String region;
    private int anoFundacion;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Jugador> jugadores = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Equipo equipo)) return false;
        return anoFundacion == equipo.anoFundacion && Objects.equals(id, equipo.id) && Objects.equals(nombre, equipo.nombre) && Objects.equals(juego, equipo.juego) && Objects.equals(region, equipo.region) && Objects.equals(jugadores, equipo.jugadores);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id, nombre, juego, region, anoFundacion, jugadores);
    }

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
        jugador.setEquipo(this);
    }

    public void removeJugador(Jugador jugador) {
        jugadores.remove(jugador);
        jugador.setEquipo(null);
    }
}
