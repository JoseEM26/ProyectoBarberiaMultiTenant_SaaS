package com.Barberia.Barberia_MultiTenant_SaaS.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoletaResponseDTO {
    private Integer id;
    private Integer citaId;
    private String metodoPago;
    private BigDecimal subtotal;
    private BigDecimal descuento;
    private BigDecimal total;
    private int puntosUsados;
    private int puntosGanados;
    private String estado;
    private LocalDateTime fechaEmision;
    private List<DetalleResponseDTO> detalles;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetalleResponseDTO {
        private Integer catalogoId;
        private String nombreCatalogo;
        private int cantidad;
        private BigDecimal precioUnitario;
        private BigDecimal subtotal;
    }
}