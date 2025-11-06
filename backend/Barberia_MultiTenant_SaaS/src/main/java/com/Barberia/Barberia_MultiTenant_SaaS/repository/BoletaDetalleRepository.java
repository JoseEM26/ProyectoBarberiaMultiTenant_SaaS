package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.BoletaDetalle;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BoletaDetalleRepository extends ReactiveCrudRepository<BoletaDetalle, Integer> {
    Flux<BoletaDetalle> findByBoletaId(Integer boletaId);
}