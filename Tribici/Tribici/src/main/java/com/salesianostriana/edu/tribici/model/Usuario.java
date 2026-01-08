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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private int numTarjeta;
    @Column(name = "pin")
    private int pin;
    @Column(name = "saldo")
    private double saldo;

    @OneToMany
    @Column(name = "usuarioUso_id")
    private List<Uso> usos;

}
