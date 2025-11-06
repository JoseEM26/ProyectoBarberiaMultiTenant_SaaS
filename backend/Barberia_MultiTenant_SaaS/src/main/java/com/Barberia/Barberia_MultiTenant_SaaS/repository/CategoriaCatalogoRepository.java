package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.CategoriaCatalogo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CategoriaCatalogoRepository extends ReactiveCrudRepository<CategoriaCatalogo, Integer> {
    Flux<CategoriaCatalogo> findByBarberiaIdAndEstadoActivoTrueOrderByOrden(Integer barberiaId);
    Mono<Boolean> existsByBarberiaIdAndNombre(Integer barberiaId, String nombre);
}