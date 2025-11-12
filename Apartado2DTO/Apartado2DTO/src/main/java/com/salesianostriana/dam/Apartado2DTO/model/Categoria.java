package com.salesianostriana.dam.Apartado2DTO.model;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Categoria {

    @Id
    private Long id;
    private String nombre;

}
