package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Boleta;
import com.Barberia.Barberia_MultiTenant_SaaS.model.BoletaEstado;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BoletaRepository extends ReactiveCrudRepository<Boleta, Integer> {
    Flux<Boleta> findByBarberiaIdAndEstado(Integer barberiaId, BoletaEstado estado);
    Flux<Boleta> findByClienteId(Integer clienteId);
    Flux<Boleta> findByBarberiaIdAndSucursalId(Integer barberiaId, Integer sucursalId);
}