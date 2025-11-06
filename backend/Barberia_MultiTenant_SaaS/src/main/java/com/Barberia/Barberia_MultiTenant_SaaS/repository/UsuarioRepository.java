package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Usuario;
import com.Barberia.Barberia_MultiTenant_SaaS.model.UsuarioTipo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Integer> {
    Mono<Usuario> findByBarberiaIdAndCorreo(Integer barberiaId, String correo);
    Mono<Boolean> existsByBarberiaIdAndCorreo(Integer barberiaId, String correo);
    Flux<Usuario> findByBarberiaIdAndTipoAndEstadoActivoTrue(Integer barberiaId, UsuarioTipo tipo);
    Flux<Usuario> findByBarberiaIdAndEstadoActivoTrue(Integer barberiaId);
    Flux<Usuario> findBySucursalIdAndEstadoActivoTrue(Integer sucursalId);
    Flux<Usuario> findByBarberiaIdOrderByPuntosFidelidadDesc(Integer barberiaId);
}