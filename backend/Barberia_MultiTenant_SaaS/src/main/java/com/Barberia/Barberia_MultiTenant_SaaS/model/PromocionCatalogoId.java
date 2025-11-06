package com.Barberia.Barberia_MultiTenant_SaaS.model;

import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PromocionCatalogoId implements Serializable {
    private Integer promocionId;
    private Integer catalogoId;
}