package com.salesianostriana.dam.Apartado2DTO.mapper;

import com.salesianostriana.dam.Apartado2DTO.dto.ProductoDTO;
import com.salesianostriana.dam.Apartado2DTO.model.Producto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductoMapper {

    public ProductoDTO toDto(Producto producto) {
        if (producto == null) return null;

        return new ProductoDTO(
                producto.getNombre(),
                producto.getPvp(),
                producto.getCategoria()
        );
    }

    public Producto toEntity(ProductoDTO dto) {
        if (dto == null) return null;

        return Producto.builder()
                .nombre(dto.nombre())
                .pvp(dto.pvp())
                .categoria(dto.categoria())
                .build();
    }

}
