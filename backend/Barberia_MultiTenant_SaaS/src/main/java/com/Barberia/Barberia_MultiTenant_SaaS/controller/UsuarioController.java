// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/controller/UsuarioController.java
package com.Barberia.Barberia_MultiTenant_SaaS.controller;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Usuario;
import com.Barberia.Barberia_MultiTenant_SaaS.model.UsuarioTipo;
import com.Barberia.Barberia_MultiTenant_SaaS.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/barberias/{barberiaId}/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository repo;

    @GetMapping("/barberos")
    public Flux<Usuario> barberos(@PathVariable Integer barberiaId) {
        return repo.findByBarberiaIdAndTipoAndEstadoActivoTrue(barberiaId, UsuarioTipo.barbero);
    }

    @GetMapping("/clientes")
    public Flux<Usuario> clientes(@PathVariable Integer barberiaId) {
        return repo.findByBarberiaIdAndTipoAndEstadoActivoTrue(barberiaId, UsuarioTipo.cliente);
    }

    @GetMapping("/top-fidelidad")
    public Flux<Usuario> topFidelidad(@PathVariable Integer barberiaId) {
        return repo.findByBarberiaIdOrderByPuntosFidelidadDesc(barberiaId);
    }
}