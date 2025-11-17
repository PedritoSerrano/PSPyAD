package com.salesianostriana.dam.monumentsApi.service;

import com.salesianostriana.dam.monumentsApi.dto.EditMonumentoComand;
import com.salesianostriana.dam.monumentsApi.error.MonumentoNotFoundException;
import com.salesianostriana.dam.monumentsApi.model.Monumento;
import com.salesianostriana.dam.monumentsApi.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentoRepository monumentoRepository;

    public List<Monumento> findAll(){
        List<Monumento> result = monumentoRepository.findAll();
        System.out.println(result);

        if(result.isEmpty())
            throw new MonumentoNotFoundException();
        return result;
    }

    public Monumento findById (Long id){
        return monumentoRepository.findById(id)
                .orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public Monumento save(EditMonumentoComand cmd){
        return monumentoRepository.save(
                Monumento.builder()
                        .nombrePais(cmd.nombrePais())
                        .nombreCiudad(cmd.nombreCiudad())
                        .nombreMonumento(cmd.nombreMonumento())
                        .descripcion(cmd.descripcion())
                        .urlFoto(cmd.urlFoto())
                        .build()
        );
    }

    public Monumento edit(EditMonumentoComand cmd, Long id) {
        return monumentoRepository.findById(id)
                .map(m -> {
                    m.setNombrePais(cmd.nombrePais());
                    m.setNombreCiudad(cmd.nombreCiudad());
                    m.setNombreMonumento(cmd.nombreMonumento());
                    m.setDescripcion(cmd.descripcion());
                    m.setUrlFoto(cmd.urlFoto());
                    return monumentoRepository.save(m);
                })
                .orElseThrow(() -> new MonumentoNotFoundException());
    }

    public void delete(Long id) {
        monumentoRepository.deleteById(id);
    }



}
