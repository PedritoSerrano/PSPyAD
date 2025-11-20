package com.salesianostriana.dam.apiBiblioteca.error;

public class LibraryNotFoundException extends RuntimeException{

    public LibraryNotFoundException(String message) {
        super(message);
    }

    public LibraryNotFoundException(Long id){
        super("No hay monumentos con ese ID: %d" .formatted(id));
    }

    public LibraryNotFoundException(){
        super("No hay monumentos con esos requisitos de búsqueda");
    }

}
