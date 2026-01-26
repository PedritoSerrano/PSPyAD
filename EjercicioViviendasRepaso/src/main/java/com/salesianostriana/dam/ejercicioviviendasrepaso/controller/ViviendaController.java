package com.salesianostriana.dam.ejercicioviviendasrepaso.controller;

import com.salesianostriana.dam.ejercicioviviendasrepaso.dto.FilterDto;
import com.salesianostriana.dam.ejercicioviviendasrepaso.dto.ViviendaResponseDto;
import com.salesianostriana.dam.ejercicioviviendasrepaso.model.EstadoVivienda;
import com.salesianostriana.dam.ejercicioviviendasrepaso.model.TipoVivienda;
import com.salesianostriana.dam.ejercicioviviendasrepaso.service.ViviendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ViviendaController {

    private final ViviendaService viviendaService;

    @GetMapping("/api/v1/viviendas")
    public ResponseEntity<Page<ViviendaResponseDto>> getAll (Pageable pageable,
                                                             @RequestParam(required = false) String ciudad,
                                                             @RequestParam(required = false) String provincia,
                                                             @RequestParam(required = false) Integer precioMin,
                                                             @RequestParam(required = false) Integer precioMax,
                                                             @RequestParam(required = false) Integer metrosMin,
                                                             @RequestParam(required = false) Integer metrosMax,
                                                             @RequestParam(required = false) Integer habitacionesMin,
                                                             @RequestParam(required = false) Integer banosMin,
                                                             @RequestParam(required = false) TipoVivienda tipo,
                                                             @RequestParam(required = false) EstadoVivienda estado,
                                                             @RequestParam(required = false) Boolean ascensor,
                                                             @RequestParam(required = false) Boolean terraza,
                                                             @RequestParam(required = false) Boolean garaje,
                                                             @RequestParam(required = false) Boolean soloDisponible
                                                             ) {
        FilterDto filterDto = new FilterDto(ciudad,provincia,precioMin,precioMax,metrosMin,metrosMax,habitacionesMin,banosMin,tipo,estado,ascensor,terraza,garaje,soloDisponible);
        return ResponseEntity.ok(
                viviendaService.getAll(pageable, filterDto).map(ViviendaResponseDto::of)
        );
    }

}
