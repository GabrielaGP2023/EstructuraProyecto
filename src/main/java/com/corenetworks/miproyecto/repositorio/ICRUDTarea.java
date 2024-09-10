package com.corenetworks.miproyecto.repositorio;

import com.corenetworks.miproyecto.modelo.Tarea;

import java.util.List;

public interface ICRUDTarea {
    List<Tarea> consultarTodos();
    Tarea consultarUno(int idTarea);
    Tarea insertar(Tarea t);
    Tarea modificar(Tarea t);
    void eliminar(int idTarea);
}
