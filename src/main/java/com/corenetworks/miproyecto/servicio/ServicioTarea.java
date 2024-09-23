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
        return
                repoTarea.findAll();
    }

    @Override
    public Tarea consultarUno(int idTarea) {

        return repoTarea.findById(idTarea).orElse(new Tarea());
    }

    @Override
    public Tarea insertar(Tarea t) {

        return repoTarea.save(t);
    }

    @Override
    public Tarea modificar(Tarea t) {
        return repoTarea.save(t);
    }

    @Override
    public void eliminar(int idTarea) {

        repoTarea.deleteById(idTarea);
    }
}
