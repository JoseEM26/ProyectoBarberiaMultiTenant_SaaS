package com.Barberia.Barberia_MultiTenant_SaaS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("boletas")
public class Boleta {

    @Id
    private Integer id;

    @Column("barberia_id")
    private Integer barberiaId;

    @Column("sucursal_id")
    private Integer sucursalId;

    @Column("cita_id")
    private Integer citaId;

    @Column("cliente_id")
    private Integer clienteId;

    @Column("metodo_pago")
    private MetodoPago metodoPago;

    @Column("subtotal")
    private BigDecimal subtotal;

    @Column("descuento")
    @Builder.Default
    private BigDecimal descuento = BigDecimal.ZERO;

    @Column("total")
    private BigDecimal total;

    @Column("puntos_usados")
    @Builder.Default
    private int puntosUsados = 0;

    @Column("puntos_ganados")
    @Builder.Default
    private int puntosGanados = 0;

    @Column("estado")
    @Builder.Default
    private BoletaEstado estado = BoletaEstado.emitida;

    @Column("fecha_emision")
    private LocalDateTime fechaEmision;


}