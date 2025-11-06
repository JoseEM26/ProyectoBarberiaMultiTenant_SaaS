// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/repository/PromocionCatalogoRepository.java
package com.Barberia.Barberia_MultiTenant_SaaS.repository;

import com.Barberia.Barberia_MultiTenant_SaaS.model.PromocionCatalogo;
import com.Barberia.Barberia_MultiTenant_SaaS.model.PromocionCatalogoId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PromocionCatalogoRepository
        extends ReactiveCrudRepository<PromocionCatalogo, PromocionCatalogoId> {

    Flux<PromocionCatalogo> findByPromocionId(Integer promocionId);
    Flux<PromocionCatalogo> findByCatalogoId(Integer catalogoId);
}