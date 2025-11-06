// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/Sucursal.java
package com.Barberia.Barberia_MultiTenant_SaaS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("sucursales")
public class Sucursal {

    @Id
    private Integer id;

    @Column("barberia_id")
    private Integer barberiaId;

    @Column("nombre")
    private String nombre;

    @Column("direccion")
    private String direccion;

    @Column("telefono")
    private String telefono;

    @Column("hora_apertura")
    private java.time.LocalTime horaApertura;

    @Column("hora_cierre")
    private java.time.LocalTime horaCierre;

    @Column("estado_activo")
    @Builder.Default
    private boolean estadoActivo = true;
}