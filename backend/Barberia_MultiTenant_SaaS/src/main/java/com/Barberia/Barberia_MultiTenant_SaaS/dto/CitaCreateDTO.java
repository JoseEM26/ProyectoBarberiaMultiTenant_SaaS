package com.Barberia.Barberia_MultiTenant_SaaS.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitaCreateDTO {

    @NotNull
    private Integer sucursalId;

    @NotNull
    private Integer barberoId;

    @NotNull
    private Integer catalogoId;

    @FutureOrPresent
    private LocalDate fecha;

    @NotNull
    private LocalTime hora;

    private String notas;
}