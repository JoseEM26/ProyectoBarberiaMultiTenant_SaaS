package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Barberia;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BarberiaRepository extends ReactiveCrudRepository<Barberia, Integer> {
    Mono<Barberia> findBySlug(String slug);
    Mono<Boolean> existsBySlug(String slug);
    Mono<Boolean> existsByNombre(String nombre);
}