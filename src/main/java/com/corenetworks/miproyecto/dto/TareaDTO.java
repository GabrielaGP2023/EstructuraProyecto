package com.corenetworks.miproyecto.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TareaDTO {

    private int idTarea;

    @NotEmpty(message="{nombre.vacio}")
    private String nombreTarea;
    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    private Integer prioridad;

}
