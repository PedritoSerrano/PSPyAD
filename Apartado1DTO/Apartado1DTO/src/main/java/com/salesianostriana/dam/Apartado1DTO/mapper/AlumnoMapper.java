package com.salesianostriana.dam.Apartado1DTO.mapper;


import com.salesianostriana.dam.Apartado1DTO.dto.AlumnoDTO;
import com.salesianostriana.dam.Apartado1DTO.model.Alumno;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AlumnoMapper {

    public AlumnoDTO toDto(Alumno alumno) {
        if (alumno == null) return null;

        return new AlumnoDTO(
                alumno.getId(),
                alumno.getNombre(),
                alumno.getApellido1(),
                alumno.getApellido2(),
                alumno.getEmail(),
                alumno.getCurso(),
                alumno.getDireccion()
        );
    }

    public Alumno toEntity(AlumnoDTO dto) {
        if (dto == null) return null;

        return Alumno.builder()
                .id(dto.id())
                .nombre(dto.nombre())
                .apellido1(dto.apellido1())
                .apellido2(dto.apellido2())
                .email(dto.email())
                .curso(dto.curso())
                .direccion(dto.direcion())
                .build();
    }

}
