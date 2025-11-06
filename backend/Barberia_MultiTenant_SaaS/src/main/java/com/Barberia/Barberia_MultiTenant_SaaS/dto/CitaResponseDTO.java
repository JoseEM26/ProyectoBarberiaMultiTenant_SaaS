package com.Barberia.Barberia_MultiTenant_SaaS.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitaResponseDTO {
    private Integer id;
    private Integer clienteId;
    private Integer barberoId;
    private Integer catalogoId;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;
    private int puntosOtorgados;
    private String notas;
}