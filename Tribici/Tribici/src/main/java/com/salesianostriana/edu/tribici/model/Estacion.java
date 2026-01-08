package com.salesianostriana.edu.tribici.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "estacion")
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "estacion_id")
    private Long id;

    @Column(name = "numero")
    private int numero;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "coordenadas")
    private String coordenadas;
    @Column(name = "capacidad")
    private int capacidad;

    @OneToMany
    @Column(name = "estacionUso_id")
    private Uso uso;

    @OneToMany
    @Column(name = "estacionBicicleta_id")
    private Bicicleta bicicleta;

}
