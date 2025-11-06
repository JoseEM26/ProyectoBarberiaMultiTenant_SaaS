package com.Barberia.Barberia_MultiTenant_SaaS.controller;

import com.Barberia.Barberia_MultiTenant_SaaS.dto.*;
import com.Barberia.Barberia_MultiTenant_SaaS.service.CitaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/barberias/{barberiaId}/clientes/{clienteId}/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService service;

    @PostMapping
    public Mono<CitaResponseDTO> crear(
            @PathVariable Integer barberiaId,
            @PathVariable Integer clienteId,
            @Valid @RequestBody CitaCreateDTO dto) {
        return service.crear(dto, barberiaId, clienteId)
                .onErrorResume(e -> Mono.error(new RuntimeException("Error al crear cita: " + e.getMessage())));
    }
}