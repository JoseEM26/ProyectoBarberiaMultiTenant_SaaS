package com.Barberia.Barberia_MultiTenant_SaaS.service;

import com.Barberia.Barberia_MultiTenant_SaaS.dto.*;
import com.Barberia.Barberia_MultiTenant_SaaS.model.Cita;
import com.Barberia.Barberia_MultiTenant_SaaS.repository.CitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository repo;

    public Mono<CitaResponseDTO> crear(CitaCreateDTO dto, Integer barberiaId, Integer clienteId) {
        return repo.existsByBarberiaIdAndBarberoIdAndFechaAndHora(
                        barberiaId, dto.getBarberoId(), dto.getFecha(), dto.getHora())
                .flatMap(exists -> exists ?
                        Mono.error(new RuntimeException("Horario ocupado")) :
                        Mono.just(dto))
                .map(d -> Cita.builder()
                        .barberiaId(barberiaId)
                        .sucursalId(d.getSucursalId())
                        .barberoId(d.getBarberoId())
                        .clienteId(clienteId)
                        .catalogoId(d.getCatalogoId())
                        .fecha(d.getFecha())
                        .hora(d.getHora())
                        .notas(d.getNotas())
                        .build())
                .flatMap(repo::save)
                .map(this::toResponseDTO);
    }

    private CitaResponseDTO toResponseDTO(Cita c) {
        return CitaResponseDTO.builder()
                .id(c.getId())
                .clienteId(c.getClienteId())
                .barberoId(c.getBarberoId())
                .catalogoId(c.getCatalogoId())
                .fecha(c.getFecha())
                .hora(c.getHora())
                .estado(c.getEstado().name())
                .puntosOtorgados(c.getPuntosOtorgados())
                .notas(c.getNotas())
                .build();
    }
}