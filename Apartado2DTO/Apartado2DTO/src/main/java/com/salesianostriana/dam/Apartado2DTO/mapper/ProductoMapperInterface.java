package com.salesianostriana.dam.Apartado2DTO.mapper;

import com.salesianostriana.dam.Apartado2DTO.dto.ProductoDTO;
import com.salesianostriana.dam.Apartado2DTO.model.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoMapperInterface {

    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "pvp", target = "pvp")
    ProductoDTO toDTO(Producto producto);
    @InheritInverseConfiguration
    Producto toEntity(ProductoDTO productoDTO);

}
