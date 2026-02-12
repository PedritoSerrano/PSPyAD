package com.salesianostriana.dam.seguridad.user.dto;

public record LoginResponse(
        String usernam,
        String accessToken
) {}
