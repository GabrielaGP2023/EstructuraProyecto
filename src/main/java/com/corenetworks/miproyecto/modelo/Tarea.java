package com.corenetworks.miproyecto.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tarea {
    private int idTarea;
    private String nombreTarea;
    private int prioridad;

}
