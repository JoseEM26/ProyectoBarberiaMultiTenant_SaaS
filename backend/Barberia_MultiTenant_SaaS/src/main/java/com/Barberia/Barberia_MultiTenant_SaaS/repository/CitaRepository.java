package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Cita;
import com.Barberia.Barberia_MultiTenant_SaaS.model.CitaEstado;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface CitaRepository extends ReactiveCrudRepository<Cita, Integer> {
    Flux<Cita> findByBarberiaIdAndFecha(Integer barberiaId, LocalDate fecha);
    Flux<Cita> findByBarberiaIdAndBarberoIdAndFecha(Integer barberiaId, Integer barberoId, LocalDate fecha);
    Flux<Cita> findByBarberiaIdAndClienteId(Integer barberiaId, Integer clienteId);
    Flux<Cita> findByBarberiaIdAndEstado(Integer barberiaId, CitaEstado estado);
    Mono<Boolean> existsByBarberiaIdAndBarberoIdAndFechaAndHora(
            Integer barberiaId, Integer barberoId, LocalDate fecha, LocalTime hora);
}