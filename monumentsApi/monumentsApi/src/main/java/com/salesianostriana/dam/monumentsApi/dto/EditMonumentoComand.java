package com.salesianostriana.dam.monumentsApi.dto;

public record EditMonumentoComand(
        String nombrePais,
        String nombreCiudad,
        String nombreMonumento,
        String descripcion,
        String urlFoto
) {
}
