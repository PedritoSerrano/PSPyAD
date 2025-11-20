package com.salesianostriana.dam.apiBiblioteca.mapper;

import com.salesianostriana.dam.apiBiblioteca.dto.LibraryDTO;
import com.salesianostriana.dam.apiBiblioteca.model.Library;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LibraryMapper {

    public LibraryDTO toDto(Library library){
        if (library == null) return null;

        return new LibraryDTO(
                library.getId(),
                library.getCityName(),
                library.getLibraryName(),
                library.getNumberOfBooks(),
                library.getOficialUrl()
        );
    }

    public Library toLibrary(LibraryDTO dto){
        if (dto == null) return null;

        return Library.builder()
                .id(dto.id())
                .cityName(dto.cityName())
                .libraryName(dto.libraryName())
                .numberOfBooks(dto.numberOfBooks())
                .oficialUrl(dto.oficialUrl())
                .build();

    }

}
