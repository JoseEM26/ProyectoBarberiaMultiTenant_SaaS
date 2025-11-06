package com.Barberia.Barberia_MultiTenant_SaaS.service;

import com.Barberia.Barberia_MultiTenant_SaaS.dto.*;
import com.Barberia.Barberia_MultiTenant_SaaS.model.Barberia;
import com.Barberia.Barberia_MultiTenant_SaaS.repository.BarberiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BarberiaService {

    private final BarberiaRepository repo;

    public Mono<BarberiaResponseDTO> crear(BarberiaCreateDTO dto) {
        return Mono.just(dto)
                .map(d -> Barberia.builder()
                        .nombre(d.getNombre())
                        .slug(d.getSlug())
                        .descripcion(d.getDescripcion())
                        .logoUrl(d.getLogoUrl())
                        .bannerUrl(d.getBannerUrl())
                        .urlWebsite(d.getUrlWebsite())
                        .facebookUrl(d.getFacebookUrl())
                        .instagramUrl(d.getInstagramUrl())
                        .twitterUrl(d.getTwitterUrl())
                        .diasAbiertos(d.getDiasAbiertos())
                        .build())
                .flatMap(repo::save)
                .map(this::toResponseDTO);
    }

    public Mono<BarberiaResponseDTO> findBySlug(String slug) {
        return repo.findBySlug(slug)
                .map(this::toResponseDTO);
    }

    private BarberiaResponseDTO toResponseDTO(Barberia b) {
        return BarberiaResponseDTO.builder()
                .id(b.getId())
                .nombre(b.getNombre())
                .slug(b.getSlug())
                .descripcion(b.getDescripcion())
                .fechaCreacion(b.getFechaCreacion())
                .logoUrl(b.getLogoUrl())
                .bannerUrl(b.getBannerUrl())
                .urlWebsite(b.getUrlWebsite())
                .facebookUrl(b.getFacebookUrl())
                .instagramUrl(b.getInstagramUrl())
                .twitterUrl(b.getTwitterUrl())
                .diasAbiertos(b.getDiasAbiertos())
                .feriados(b.getFeriados())
                .estadoActivo(b.isEstadoActivo())
                .build();
    }
}