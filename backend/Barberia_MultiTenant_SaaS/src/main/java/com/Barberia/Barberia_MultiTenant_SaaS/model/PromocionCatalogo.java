// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/PromocionCatalogo.java
package com.Barberia.Barberia_MultiTenant_SaaS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("promociones_catalogos")
public class PromocionCatalogo {

    @Id
    private PromocionCatalogoId id; // ÚNICO @Id → clase compuesta

    // Campos de la clave compuesta (NO @Id aquí)
    @Column("promocion_id")
    private Integer promocionId;

    @Column("catalogo_id")
    private Integer catalogoId;

    // Constructor para crear la clave
    public PromocionCatalogo(Integer promocionId, Integer catalogoId) {
        this.id = new PromocionCatalogoId(promocionId, catalogoId);
        this.promocionId = promocionId;
        this.catalogoId = catalogoId;
    }
}