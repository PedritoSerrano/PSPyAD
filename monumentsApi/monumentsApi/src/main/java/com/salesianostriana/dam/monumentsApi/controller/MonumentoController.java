package com.salesianostriana.dam.monumentsApi.controller;

import com.salesianostriana.dam.monumentsApi.dto.EditMonumentoComand;
import com.salesianostriana.dam.monumentsApi.error.MonumentoNotFoundException;
import com.salesianostriana.dam.monumentsApi.model.Monumento;
import com.salesianostriana.dam.monumentsApi.service.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento/")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoService monumentoService;

    @Operation(summary = "Obtiene todos los productos")
    @GetMapping
    public List<Monumento> getAll() {
        return monumentoService.getAll();
    }


    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han encontrado productos",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = EditMonumentoComand.class)),
                            examples = @ExampleObject(
                                            value = "[{ \"name\":España, \"city name\":\"Sevilla\", \"ISO\":1234.56 }]"

                            )
                    )
            ),
    @ApiResponse(responseCode = "404", description = "No se ha encontrado ningún producto")
})
@GetMapping("/{id}")
public Monumento getById(@PathVariable Long id) {
    return monumentoService.findById(id);
}

@PostMapping
public ResponseEntity<Monumento> create(
        @RequestBody EditMonumentoComand cmd
) {
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(monumentoService.save(cmd));
}

@PutMapping("/{id}")
public Monumento edit(@RequestBody EditMonumentoComand cmd, @PathVariable Long id) {
    return monumentoService.edit(cmd, id);
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) {
    monumentoService.delete(id);
    return ResponseEntity.noContent().build();
}

}
