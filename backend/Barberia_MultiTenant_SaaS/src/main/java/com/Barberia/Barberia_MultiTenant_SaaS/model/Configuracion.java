// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/Configuracion.java
package com.Barberia.Barberia_MultiTenant_SaaS.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("configuraciones")
public class Configuracion {

    @Id
    private Integer barberiaId;

    @Column("mostrar_logo")
    @Builder.Default
    private boolean mostrarLogo = true;

    @Column("mostrar_direccion")
    @Builder.Default
    private boolean mostrarDireccion = true;

    @Column("mostrar_telefono")
    @Builder.Default
    private boolean mostrarTelefono = true;

    @Column("mostrar_web")
    @Builder.Default
    private boolean mostrarWeb = true;

    @Column("mensaje_pie_recibo")
    private String mensajePieRecibo;

    @Column("color_primario")
    @Builder.Default
    private String colorPrimario = "#1a1a1a";

    @Column("color_secundario")
    @Builder.Default
    private String colorSecundario = "#ff6b00";

    @Column("idioma")
    @Builder.Default
    private String idioma = "es";

    @Column("usar_fidelidad")
    @Builder.Default
    private boolean usarFidelidad = true;

    @Column("usar_promociones")
    @Builder.Default
    private boolean usarPromociones = true;

    @Column("usar_citas")
    @Builder.Default
    private boolean usarCitas = true;

    @Column("usar_boletas")
    @Builder.Default
    private boolean usarBoletas = true;
}