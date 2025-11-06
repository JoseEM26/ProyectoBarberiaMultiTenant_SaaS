package com.Barberia.Barberia_MultiTenant_SaaS.controller;

import com.Barberia.Barberia_MultiTenant_SaaS.dto.*;
import com.Barberia.Barberia_MultiTenant_SaaS.service.BoletaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/barberias/{barberiaId}/clientes/{clienteId}/boletas")
@RequiredArgsConstructor
public class BoletaController {

    private final BoletaService service;

    @PostMapping
    public Mono<BoletaResponseDTO> emitir(
            @PathVariable Integer barberiaId,
            @PathVariable Integer clienteId,
            @Valid @RequestBody BoletaCreateDTO dto) {
        return service.emitir(dto, barberiaId, clienteId)
                .onErrorResume(e -> Mono.error(new RuntimeException("Error al emitir boleta: " + e.getMessage())));
    }
}