package com.Barberia.Barberia_MultiTenant_SaaS.controller;

import com.Barberia.Barberia_MultiTenant_SaaS.dto.*;
import com.Barberia.Barberia_MultiTenant_SaaS.service.BarberiaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/barberias")
@RequiredArgsConstructor
public class BarberiaController {

    private final BarberiaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BarberiaResponseDTO> crear(@Valid @RequestBody BarberiaCreateDTO dto) {
        return service.crear(dto)
                .onErrorResume(e -> Mono.error(new RuntimeException("Error al crear barbería: " + e.getMessage())));
    }

    @GetMapping("/{slug}")
    public Mono<BarberiaResponseDTO> obtenerPorSlug(@PathVariable String slug) {
        return service.findBySlug(slug)
                .switchIfEmpty(Mono.error(new RuntimeException("Barbería no encontrada")));
    }
}