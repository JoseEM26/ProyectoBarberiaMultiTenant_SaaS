// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/Log.java
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
@Table("logs")
public class Log {

    @Id
    private Long id;

    @Column("barberia_id")
    private Integer barberiaId;

    @Column("usuario_id")
    private Integer usuarioId;

    @Column("nivel")
    private NivelLog nivel;

    @Column("mensaje")
    private String mensaje;

    @Column("detalles")
    private String detalles;

    @Column("fecha")
    private LocalDateTime fecha;

    @Column("accion")
    private String accion;
}