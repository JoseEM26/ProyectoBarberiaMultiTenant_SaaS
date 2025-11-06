package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Configuracion;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ConfiguracionRepository extends ReactiveCrudRepository<Configuracion, Integer> {
    Mono<Configuracion> findByBarberiaId(Integer barberiaId);
}