package com.salesianostriana.dam.Apartado1DTO.dto;

import com.salesianostriana.dam.Apartado1DTO.model.Curso;
import com.salesianostriana.dam.Apartado1DTO.model.Direccion;

public record AlumnoDTO(Long id, String nombre, String apellido1, String apellido2, String email, Curso curso, Direccion direcion) {}
