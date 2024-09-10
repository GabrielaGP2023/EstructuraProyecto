package com.corenetworks.miproyecto.repositorio;

import com.corenetworks.miproyecto.modelo.Tarea;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CRUDTarea implements ICRUDTarea{
    @Override
    public List<Tarea> consultarTodos() {
        return List.of(new Tarea(1,"generar informes",1));
    }

    @Override
    public Tarea consultarUno(int idTarea) {
        return new Tarea(idTarea, "generar notas",2);
    }

    @Override
    public Tarea insertar(Tarea t) {
        return t;
    }

    @Override
    public Tarea modificar(Tarea t) {
        return t;
    }

    @Override
    public void eliminar(int idTarea) {
        System.out.println("simulando la eliminación");
    }
}
