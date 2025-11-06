package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.Catalogo;
import com.Barberia.Barberia_MultiTenant_SaaS.model.CatalogoTipo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CatalogoRepository extends ReactiveCrudRepository<Catalogo, Integer> {
    Flux<Catalogo> findByBarberiaIdAndEstadoActivoTrue(Integer barberiaId);
    Flux<Catalogo> findByBarberiaIdAndCategoriaIdAndEstadoActivoTrue(Integer barberiaId, Integer categoriaId);
    Flux<Catalogo> findByBarberiaIdAndTipoAndEstadoActivoTrue(Integer barberiaId, CatalogoTipo tipo);
}