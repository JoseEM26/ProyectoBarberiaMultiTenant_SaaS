package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Promocion;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import java.time.LocalDate;

@Repository
public interface PromocionRepository extends ReactiveCrudRepository<Promocion, Integer> {
    Flux<Promocion> findByBarberiaIdAndEstadoActivoTrue(Integer barberiaId);
    Flux<Promocion> findByBarberiaIdAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqualAndEstadoActivoTrue(
            Integer barberiaId, LocalDate fechaInicio, LocalDate fechaFin);
}