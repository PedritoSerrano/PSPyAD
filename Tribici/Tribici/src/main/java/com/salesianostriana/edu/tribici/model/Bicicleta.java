package com.salesianostriana.edu.tribici.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bicicleta")
public class Bicicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bicicleta_id")
    private Long id;

    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "estado")
    private Estado estado;

    @OneToMany
    @Column(name = "bicicletaUso_id")
    private List<Uso> usos;

    @ManyToOne
    @Column(name = "bicicletaEstacion_id")
    private Estacion estacion;

}
