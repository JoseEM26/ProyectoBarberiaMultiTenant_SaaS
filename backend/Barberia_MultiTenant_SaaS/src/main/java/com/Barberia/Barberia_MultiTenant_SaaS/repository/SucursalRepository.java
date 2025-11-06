package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Sucursal;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SucursalRepository extends ReactiveCrudRepository<Sucursal, Integer> {
    Flux<Sucursal> findByBarberiaIdAndEstadoActivoTrue(Integer barberiaId);
    Flux<Sucursal> findByBarberiaId(Integer barberiaId);
}