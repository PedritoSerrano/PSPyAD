package com.salesianostriana.dam.ejercicioviviendasrepaso.dto;

import com.salesianostriana.dam.ejercicioviviendasrepaso.model.Vivienda;

import java.time.LocalDate;

public record ViviendaResponseDto(
        Long id,
        String titulo,
        String descripcion,
        String ciudad,
        String provincia,
        Integer precio,
        Integer metrosCuadrados,
        Integer habitaciones,
        Integer banos,
        String tipo,
        String estado,
        Boolean ascensor,
        Boolean terraza,
        Boolean garaje,
        Boolean disponible,
        LocalDate fechaPublicacion
) {
    public static ViviendaResponseDto of (Vivienda v){
        return new ViviendaResponseDto(
                v.getId(),
                v.getTitulo(),
                v.getDescripcion(),
                v.getCiudad(),
                v.getProvincia(),
                v.getPrecio(),
                v.getMetrosCuadrados(),
                v.getHabitaciones(),
                v.getBanos(),
                v.getTipo().toString(),
                v.getEstado().toString(),
                v.getAscensor(),
                v.getTerraza(),
                v.getGaraje(),
                v.getDisponible(),
                v.getFechaPublicacion()
        );
    }
}
