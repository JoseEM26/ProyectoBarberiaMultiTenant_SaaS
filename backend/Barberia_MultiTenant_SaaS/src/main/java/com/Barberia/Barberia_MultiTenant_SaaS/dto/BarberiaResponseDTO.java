package com.Barberia.Barberia_MultiTenant_SaaS.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BarberiaResponseDTO {
    private Integer id;
    private String nombre;
    private String slug;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String logoUrl;
    private String bannerUrl;
    private String urlWebsite;
    private String facebookUrl;
    private String instagramUrl;
    private String twitterUrl;
    private String diasAbiertos;
    private JsonNode feriados;
    private boolean estadoActivo;
}