// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/Reclamo.java
package com.Barberia.Barberia_MultiTenant_SaaS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("reclamos")
public class Reclamo {

    @Id
    private Integer id;

    @Column("barberia_id")
    private Integer barberiaId;

    @Column("cliente_id")
    private Integer clienteId;

    @Column("asunto")
    private String asunto;

    @Column("descripcion")
    private String descripcion;

    @Column("estado")
    @Builder.Default
    private ReclamoEstado estado = ReclamoEstado.pendiente;

    @Column("respondido_por")
    private Integer respondidoPor;

    @Column("respuesta")
    private String respuesta;

    @Column("fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column("fecha_respuesta")
    private LocalDateTime fechaRespuesta;
}