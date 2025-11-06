// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/BoletaDetalle.java
package com.Barberia.Barberia_MultiTenant_SaaS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("boletas_detalles")
public class BoletaDetalle {

    @Id
    private Integer id;

    @Column("boleta_id")
    private Integer boletaId;

    @Column("catalogo_id")
    private Integer catalogoId;

    @Column("cantidad")
    @Builder.Default
    private int cantidad = 1;

    @Column("precio_unitario")
    private BigDecimal precioUnitario;

    @Column("subtotal")
    private BigDecimal subtotal;
}