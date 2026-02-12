package com.salesianostriana.dam.seguridad.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping
    public String api() {
        return "API pública";
    }

    @GetMapping("/user")
    public String endpoint(@AuthenticationPrincipal User user) {
        return "¡Hello %s!".formatted(user.getUsername());
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin!";
    }

}
