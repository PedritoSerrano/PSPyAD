package com.salesianostriana.dam.Apartado1DTO.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {

    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;
    private Direccion direccion;
    private Curso curso;

}
