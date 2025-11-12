package com.salesianostriana.dam.Apartado1DTO.mapper;

import com.salesianostriana.dam.Apartado1DTO.dto.AlumnoDTO;
import com.salesianostriana.dam.Apartado1DTO.model.Alumno;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlumnoMapperInterface {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido1", target = "apellido1")
    @Mapping(source = "email", target = "email")
    AlumnoDTO toDTO(Alumno alumno);

    @InheritInverseConfiguration
    Alumno toEntity (AlumnoDTO alumnoDTO);

}
