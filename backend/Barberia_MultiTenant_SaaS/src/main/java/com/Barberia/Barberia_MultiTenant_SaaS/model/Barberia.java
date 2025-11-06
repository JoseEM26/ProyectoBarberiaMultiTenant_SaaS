// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/Barberia.java
package com.Barberia.Barberia_MultiTenant_SaaS.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "barberias")
public class Barberia {

    @Id
    private Integer id;

    @Column("nombre")
    private String nombre;

    @Column("slug")
    private String slug;

    @Column("descripcion")
    private String descripcion;

    @Column("fecha_creacion")
    private LocalDate fechaCreacion;

    @Column("logo_url")
    private String logoUrl;

    @Column("banner_url")
    private String bannerUrl;

    @Column("url_website")
    private String urlWebsite;

    @Column("facebook_url")
    private String facebookUrl;

    @Column("instagram_url")
    private String instagramUrl;

    @Column("twitter_url")
    private String twitterUrl;

    @Column("dias_abiertos")
    private String diasAbiertos;

    @Column("feriados")
    private JsonNode feriados;

    @Column("estado_activo")
    private boolean estadoActivo = true;
}