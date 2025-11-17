package com.salesianostriana.dam.monumentsApi.error;

public class MonumentoNotFoundException extends RuntimeException {
    public MonumentoNotFoundException(String message) {
        super(message);
    }

    public MonumentoNotFoundException(Long id){
        super("No hay monumentos con ese ID: %d" .formatted(id));
    }

    public MonumentoNotFoundException(){
        super("No hay monumentos con esos requisitos de búsqueda");
    }
}
