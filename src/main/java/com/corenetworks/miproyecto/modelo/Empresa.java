package com.corenetworks.miproyecto.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="empresas")
public class Empresa {
    @Id
    private String nie;

    @Column(length = 30, nullable = false)
    private String nombreEmpresa;

    @Column(length = 120, nullable = false)
    private String direccion;


}
