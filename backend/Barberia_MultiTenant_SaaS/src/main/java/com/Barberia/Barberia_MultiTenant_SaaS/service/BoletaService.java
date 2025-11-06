// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/service/BoletaService.java
package com.Barberia.Barberia_MultiTenant_SaaS.service;

import com.Barberia.Barberia_MultiTenant_SaaS.dto.*;
import com.Barberia.Barberia_MultiTenant_SaaS.model.*;
import com.Barberia.Barberia_MultiTenant_SaaS.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoletaService {

    private final BoletaRepository boletaRepo;
    private final BoletaDetalleRepository detalleRepo;
    private final CatalogoRepository catalogoRepo;
    private final UsuarioRepository usuarioRepo;
    private final CitaRepository citaRepo;

    public Mono<BoletaResponseDTO> emitir(BoletaCreateDTO dto, Integer barberiaId, Integer clienteId) {
        return calcularTotal(dto, barberiaId)
                .flatMap(totales -> {
                    Boleta boleta = Boleta.builder()
                            .barberiaId(barberiaId)
                            .citaId(dto.getCitaId())
                            .clienteId(clienteId)
                            .metodoPago(MetodoPago.valueOf(dto.getMetodoPago()))
                            .subtotal(totales.get("subtotal"))
                            .descuento(totales.get("descuento"))
                            .total(totales.get("total"))
                            .puntosUsados(dto.getPuntosUsados())
                            .puntosGanados(calcularPuntos(totales.get("total")))
                            .build();

                    return boletaRepo.save(boleta)
                            .flatMap(saved -> guardarDetalles(saved.getId(), dto.getDetalles())
                                    .then(Mono.just(saved)));
                })
                .flatMap(b -> toResponseDTO(b.getId()));
    }

    private Mono<Map<String, BigDecimal>> calcularTotal(BoletaCreateDTO dto, Integer barberiaId) {
        return Flux.fromIterable(dto.getDetalles())
                .flatMap(d -> catalogoRepo.findById(d.getCatalogoId())
                        .map(c -> c.getPrecio().multiply(BigDecimal.valueOf(d.getCantidad())))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .map(subtotal -> Map.of(
                        "subtotal", subtotal,
                        "descuento", BigDecimal.ZERO,
                        "total", subtotal
                ));
    }

    private int calcularPuntos(BigDecimal total) {
        return total.intValue() / 10;
    }

    private Mono<Void> guardarDetalles(Integer boletaId, List<BoletaCreateDTO.DetalleDTO> detalles) {
        return Flux.fromIterable(detalles)
                .flatMap(d -> catalogoRepo.findById(d.getCatalogoId())
                        .map(c -> BoletaDetalle.builder()
                                .boletaId(boletaId)
                                .catalogoId(d.getCatalogoId())
                                .cantidad(d.getCantidad())
                                .precioUnitario(c.getPrecio())
                                .subtotal(c.getPrecio().multiply(BigDecimal.valueOf(d.getCantidad())))
                                .build())
                )
                .as(detalleRepo::saveAll)
                .then();
    }

    private Mono<BoletaResponseDTO> toResponseDTO(Integer boletaId) {
        return boletaRepo.findById(boletaId)
                .zipWith(detalleRepo.findByBoletaId(boletaId).collectList())
                .flatMap(tuple -> {
                    Boleta boleta = tuple.getT1();
                    List<BoletaDetalle> detalles = tuple.getT2();

                    return Flux.fromIterable(detalles)
                            .flatMap(d -> catalogoRepo.findById(d.getCatalogoId())
                                    .map(c -> BoletaResponseDTO.DetalleResponseDTO.builder()
                                            .catalogoId(d.getCatalogoId())
                                            .nombreCatalogo(c.getNombre())
                                            .cantidad(d.getCantidad())
                                            .precioUnitario(d.getPrecioUnitario())
                                            .subtotal(d.getSubtotal())
                                            .build()))
                            .collectList()
                            .map(detalleDTOs -> BoletaResponseDTO.builder()
                                    .id(boleta.getId())
                                    .citaId(boleta.getCitaId())
                                    .metodoPago(boleta.getMetodoPago().name())
                                    .subtotal(boleta.getSubtotal())
                                    .descuento(boleta.getDescuento())
                                    .total(boleta.getTotal())
                                    .puntosUsados(boleta.getPuntosUsados())
                                    .puntosGanados(boleta.getPuntosGanados())
                                    .estado(boleta.getEstado().name())
                                    .fechaEmision(boleta.getFechaEmision())
                                    .detalles(detalleDTOs)
                                    .build());
                });
    }
}