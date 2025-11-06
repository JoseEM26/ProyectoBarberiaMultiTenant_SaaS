package com.Barberia.Barberia_MultiTenant_SaaS.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BarberiaCreateDTO {

    @NotBlank @Size(max = 100)
    private String nombre;

    @NotBlank @Size(max = 100)
    private String slug;

    @Size(max = 1000)
    private String descripcion;

    @Size(max = 255)
    private String logoUrl;

    @Size(max = 255)
    private String bannerUrl;

    @Size(max = 255)
    private String urlWebsite;

    @Size(max = 255)
    private String facebookUrl;

    @Size(max = 255)
    private String instagramUrl;

    @Size(max = 255)
    private String twitterUrl;

    @Size(max = 100)
    private String diasAbiertos;
}