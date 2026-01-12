package com.salesianostriana.edu.tribici.services;

import com.salesianostriana.edu.tribici.model.Usuario;
import com.salesianostriana.edu.tribici.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Optional<Usuario> autentication (int numTarjeta, int pin){
        return usuarioRepository.findByNumTarjetaAndPin(numTarjeta, pin);

    }

}
