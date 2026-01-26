package com.salesianostriana.dam.ejercicioviviendasrepaso.dto;

import com.salesianostriana.dam.ejercicioviviendasrepaso.model.EstadoVivienda;
import com.salesianostriana.dam.ejercicioviviendasrepaso.model.TipoVivienda;

public record FilterDto(
        String ciudad,
        String provincia,
        Integer precioMin,
        Integer precioMax,
        Integer metrosMin,
        Integer metrosMax,
        Integer habitacionMin,
        Integer banosMin,
        TipoVivienda tipo,
        EstadoVivienda estado,
        Boolean ascensor,
        Boolean terraza,
        Boolean garaje,
        Boolean soloDisponibles
) {
}
