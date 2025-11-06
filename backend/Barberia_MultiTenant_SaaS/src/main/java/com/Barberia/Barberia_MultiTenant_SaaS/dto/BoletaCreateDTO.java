package com.Barberia.Barberia_MultiTenant_SaaS.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoletaCreateDTO {

    private Integer citaId;

    @NotNull
    private String metodoPago;

    @NotEmpty
    private List<DetalleDTO> detalles;

    @Min(0)
    private int puntosUsados = 0;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetalleDTO {
        @NotNull
        private Integer catalogoId;

        @Min(1)
        private int cantidad = 1;
    }
}