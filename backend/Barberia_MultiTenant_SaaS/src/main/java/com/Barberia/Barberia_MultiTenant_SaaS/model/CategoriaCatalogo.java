// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/CategoriaCatalogo.java
package com.Barberia.Barberia_MultiTenant_SaaS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("categorias_catalogo")
public class CategoriaCatalogo {

    @Id
    private Integer id;

    @Column("barberia_id")
    private Integer barberiaId;

    @Column("nombre")
    private String nombre;

    @Column("descripcion")
    private String descripcion;

    @Column("orden")
    @Builder.Default
    private int orden = 0;

    @Column("estado_activo")
    @Builder.Default
    private boolean estadoActivo = true;
}