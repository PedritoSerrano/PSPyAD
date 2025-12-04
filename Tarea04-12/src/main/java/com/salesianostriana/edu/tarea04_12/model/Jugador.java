package com.salesianostriana.edu.tarea04_12.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "player_generator")
    @SequenceGenerator(name = "player_generator", sequenceName = "player_seq", allocationSize = 1)
    private Long id;

    private String nickname;
    private String nombreReal;
    private int edad;

    @ManyToOne
    @JoinColumn(foreignKey =
        @ForeignKey(name = "fk_jugador_equipo"))
    private Equipo equipo;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Jugador jugador)) return false;
        return edad == jugador.edad && Objects.equals(id, jugador.id) && Objects.equals(nickname, jugador.nickname) && Objects.equals(nombreReal, jugador.nombreReal) && Objects.equals(equipo, jugador.equipo);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id, nickname, nombreReal, edad, equipo);
    }
}
