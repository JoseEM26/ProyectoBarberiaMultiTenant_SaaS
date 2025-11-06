package com.Barberia.Barberia_MultiTenant_SaaS.controller;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Catalogo;
import com.Barberia.Barberia_MultiTenant_SaaS.repository.CatalogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/barberias/{barberiaId}/catalogo")
@RequiredArgsConstructor
public class CatalogoController {

    private final CatalogoRepository repo;

    @GetMapping
    public Flux<Catalogo> listarActivos(@PathVariable Integer barberiaId) {
        return repo.findByBarberiaIdAndEstadoActivoTrue(barberiaId);
    }

    @GetMapping("/categoria/{categoriaId}")
    public Flux<Catalogo> porCategoria(@PathVariable Integer barberiaId, @PathVariable Integer categoriaId) {
        return repo.findByBarberiaIdAndCategoriaIdAndEstadoActivoTrue(barberiaId, categoriaId);
    }
}