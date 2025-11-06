// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/Catalogo.java
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
@Table("catalogos")
public class Catalogo {

    @Id
    private Integer id;

    @Column("barberia_id")
    private Integer barberiaId;

    @Column("categoria_id")
    private Integer categoriaId;

    @Column("nombre")
    private String nombre;

    @Column("descripcion")
    private String descripcion;

    @Column("tipo")
    private CatalogoTipo tipo;

    @Column("precio")
    private BigDecimal precio;

    @Column("precio_descuento")
    private BigDecimal precioDescuento;

    @Column("duracion_minutos")
    private Integer duracionMinutos;

    @Column("url_imagen")
    private String urlImagen;

    @Column("estado_activo")
    @Builder.Default
    private boolean estadoActivo = true;

    @Column("requiere_barbero")
    @Builder.Default
    private boolean requiereBarbero = true;
}