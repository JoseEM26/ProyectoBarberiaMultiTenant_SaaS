// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/Promocion.java
package com.Barberia.Barberia_MultiTenant_SaaS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("promociones")
public class Promocion {

    @Id
    private Integer id;

    @Column("barberia_id")
    private Integer barberiaId;

    @Column("nombre")
    private String nombre;

    @Column("descripcion")
    private String descripcion;

    @Column("tipo")
    private PromocionTipo tipo;

    @Column("valor")
    private BigDecimal valor;

    @Column("aplicable_a")
    private AplicableA aplicableA;

    @Column("categoria_id")
    private Integer categoriaId;

    @Column("max_usos")
    private Integer maxUsos;

    @Column("usos_actuales")
    @Builder.Default
    private int usosActuales = 0;

    @Column("fecha_inicio")
    private LocalDate fechaInicio;

    @Column("fecha_fin")
    private LocalDate fechaFin;

    @Column("estado_activo")
    @Builder.Default
    private boolean estadoActivo = true;

    @Column("puntos_requeridos")
    private Integer puntosRequeridos;
}