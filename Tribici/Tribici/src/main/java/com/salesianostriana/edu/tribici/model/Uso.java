package com.salesianostriana.edu.tribici.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "uso")
public class Uso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uso_id")
    private Long id;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    @Column(name = "coste")
    private double coste;

    @ManyToOne
    @Column(name = "usoEstacion_id")
    private Estacion estacion;

    @ManyToOne
    @Column(name = "usoBicicleta_id")
    private Bicicleta bicicleta;

    @ManyToOne
    @Column(name = "usoUsuario_id")
    private Usuario usuario;
}
