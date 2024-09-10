package com.corenetworks.miproyecto.servicio;

import com.corenetworks.miproyecto.modelo.Tarea;
import com.corenetworks.miproyecto.repositorio.ICRUDTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioTarea implements IServicioTarea {

    @Autowired
    private ICRUDTarea repoTarea;

    @Override
    public List<Tarea> consultarTodos() {
        return repoTarea.consultarTodos();
    }

    @Override
    public Tarea consultarUno(int idTarea) {
        return repoTarea.consultarUno(idTarea);
    }

    @Override
    public Tarea insertar(Tarea t) {
        return repoTarea.insertar(t);
    }

    @Override
    public Tarea modificar(Tarea t) {
        return repoTarea.modificar(t);
    }

    @Override
    public void eliminar(int idTarea) {
        repoTarea.eliminar(idTarea);
    }
}
