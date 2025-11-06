package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Reclamo;
import com.Barberia.Barberia_MultiTenant_SaaS.model.ReclamoEstado;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReclamoRepository extends ReactiveCrudRepository<Reclamo, Integer> {
    Flux<Reclamo> findByBarberiaId(Integer barberiaId);
    Flux<Reclamo> findByClienteId(Integer clienteId);
    Flux<Reclamo> findByBarberiaIdAndEstado(Integer barberiaId, ReclamoEstado estado);
}