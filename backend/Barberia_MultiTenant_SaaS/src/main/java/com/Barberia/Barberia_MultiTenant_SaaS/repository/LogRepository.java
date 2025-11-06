package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Log;
import com.Barberia.Barberia_MultiTenant_SaaS.model.NivelLog;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface LogRepository extends ReactiveCrudRepository<Log, Long> {
    Flux<Log> findByBarberiaId(Integer barberiaId);
    Flux<Log> findByBarberiaIdAndNivel(Integer barberiaId, NivelLog nivel);
    Flux<Log> findByUsuarioId(Integer usuarioId);
}