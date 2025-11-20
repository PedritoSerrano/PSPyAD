package com.salesianostriana.dam.apiBiblioteca.service;

import com.salesianostriana.dam.apiBiblioteca.dto.LibraryDTO;
import com.salesianostriana.dam.apiBiblioteca.error.LibraryNotFoundException;
import com.salesianostriana.dam.apiBiblioteca.model.Library;
import com.salesianostriana.dam.apiBiblioteca.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrearyService {

    private final LibraryRepository libraryRepository;

    public List<Library> findAll(){
        List<Library> result = libraryRepository.findAll();
        System.out.println(result);

        if (result.isEmpty())
            throw new LibraryNotFoundException();
        return result;
    }

    public Library findById(Long id){
        return libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException(id));
    }

    public Library save (LibraryDTO cmd){
        return libraryRepository.save(
                Library.builder()
                        .cityName(cmd.cityName())
                        .libraryName(cmd.libraryName())
                        .numberOfBooks(cmd.numberOfBooks())
                        .oficialUrl(cmd.oficialUrl())
                        .build()
        );
    }

    public Library edit(LibraryDTO cmd, Long id){
        return libraryRepository.findById(id)
                .map(l -> {
                    l.setCityName(cmd.cityName());
                    l.setLibraryName(cmd.libraryName());
                    l.setNumberOfBooks(cmd.numberOfBooks());
                    l.setOficialUrl(cmd.oficialUrl());
                    return libraryRepository.save(l);
                })
                .orElseThrow(() -> new LibraryNotFoundException());

    }

    public void delete (Long id) {
        libraryRepository.deleteById(id);
    }

}
