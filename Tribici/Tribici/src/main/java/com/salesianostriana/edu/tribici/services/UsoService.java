package com.salesianostriana.edu.tribici.services;

import com.salesianostriana.edu.tribici.model.Uso;
import com.salesianostriana.edu.tribici.model.Usuario;
import com.salesianostriana.edu.tribici.repository.BicicletaRepository;
import com.salesianostriana.edu.tribici.repository.EstacionRepository;
import com.salesianostriana.edu.tribici.repository.UsoRepository;
import com.salesianostriana.edu.tribici.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsoService {

    private static final double UMBRAL_SALDO_MIN = 0.10;

    private final UsuarioRepository usuarioRepository;
    private final BicicletaRepository bicicletaRepository;
    private final EstacionRepository estacionRepository;
    private final UsoRepository usoRepository;
    private final UsuarioService usuarioService;

    public Uso inicializarUso (Long idEstacion, int pin, int numTarjeta, Long idBicicleta) {
        Usuario u = usuarioService.autentication(numTarjeta, pin).orElseThrow(() -> new IllegalArgumentException("La tarjeta o el pin no son válidos"));

        Uso uso = new Uso();
        uso.setUsuario(u);
        uso.setBicicleta(bicicletaRepository.findById(idBicicleta).orElseThrow(() -> new IllegalArgumentException("Bicicleta no encontrada")));

        return usoRepository.save(uso);
    }

    public Uso finalizarUso (int numTarjeta, int pin ,Long idBicicleta, Long idEstacion) {
        Usuario u = usuarioService.autentication(numTarjeta, pin).orElseThrow(() -> new IllegalArgumentException("La tarjeta o el pin no son válidos"));



    }

}
