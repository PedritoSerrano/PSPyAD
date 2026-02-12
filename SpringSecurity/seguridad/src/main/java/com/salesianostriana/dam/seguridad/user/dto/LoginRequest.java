package com.salesianostriana.dam.seguridad.user.dto;

public record LoginRequest(
        String username,
        String password
) {}
