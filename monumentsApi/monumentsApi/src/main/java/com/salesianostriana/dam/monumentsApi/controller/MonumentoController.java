package com.salesianostriana.dam.monumentsApi.controller;

import com.salesianostriana.dam.monumentsApi.dto.EditMonumentoComand;
import com.salesianostriana.dam.monumentsApi.error.MonumentoNotFoundException;
import com.salesianostriana.dam.monumentsApi.model.Monumento;
import com.salesianostriana.dam.monumentsApi.service.MonumentoService;
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

    @GetMapping
    public List<Monumento> getAll(){
        return monumentoService.findAll();
    }

    @GetMapping("/{id}")
    public Monumento getById (@PathVariable Long id){
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
    public Monumento edit(@RequestBody MonumentoNotFoundException cmd, @PathVariable Long id) {
        return monumentoService.edit(cmd.id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        monumentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
