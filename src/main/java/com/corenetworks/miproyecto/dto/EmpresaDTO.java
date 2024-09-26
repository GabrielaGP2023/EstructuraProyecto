package com.corenetworks.miproyecto.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaDTO {

    private String nie;
    @NotEmpty
    @Size(min=5, max=20)
    private String nombreEmpresa;
    @NotEmpty
    private String direccion;


}
