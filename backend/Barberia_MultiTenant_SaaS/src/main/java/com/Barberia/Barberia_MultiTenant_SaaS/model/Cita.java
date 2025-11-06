// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/Cita.java
package com.Barberia.Barberia_MultiTenant_SaaS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("citas")
public class Cita {

    @Id
    private Integer id;

    @Column("barberia_id")
    private Integer barberiaId;

    @Column("sucursal_id")
    private Integer sucursalId;

    @Column("barbero_id")
    private Integer barberoId;

    @Column("cliente_id")
    private Integer clienteId;

    @Column("catalogo_id")
    private Integer catalogoId;

    @Column("fecha")
    private LocalDate fecha;

    @Column("hora")
    private LocalTime hora;

    @Column("duracion_minutos")
    private Integer duracionMinutos;

    @Column("estado")
    @Builder.Default
    private CitaEstado estado = CitaEstado.pendiente;

    @Column("puntos_otorgados")
    @Builder.Default
    private int puntosOtorgados = 0;

    @Column("notas")
    private String notas;
}