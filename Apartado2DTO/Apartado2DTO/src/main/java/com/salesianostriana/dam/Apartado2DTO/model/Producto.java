package com.salesianostriana.dam.Apartado2DTO.model;

import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {


    private Long id;
    private String nombre;
    private String desc;
    private double pvp;
    private List<String> imagenes;
    private Categoria categoria;

}
