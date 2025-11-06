// src/main/java/com/Barberia/Barberia_MultiTenant_SaaS/model/Usuario.java
package com.Barberia.Barberia_MultiTenant_SaaS.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("usuarios")
public class Usuario {

    @Id
    private Integer id;

    @Column("barberia_id")
    private Integer barberiaId;

    @Column("sucursal_id")
    private Integer sucursalId;

    @Column("tipo")
    private UsuarioTipo tipo;

    @Column("nombre")
    private String nombre;

    @Column("apellido")
    private String apellido;

    @Column("correo")
    private String correo;

    @Column("telefono")
    private String telefono;

    @Column("genero")
    private Genero genero;

    @Column("fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column("contrasena_hash")
    private String contrasenaHash;

    @Column("puntos_fidelidad")
    @Builder.Default
    private int puntosFidelidad = 0;

    @Column("nivel_fidelidad")
    @Builder.Default
    private String nivelFidelidad = "bronce";

    @Column("estado_activo")
    @Builder.Default
    private boolean estadoActivo = true;
    @Column("alias")
    private String alias;

    @Column("celular")
    private String celular;

    @Column("fecha_registro")
    private LocalDateTime fechaRegistro;
}