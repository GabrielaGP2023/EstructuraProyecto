package com.corenetworks.miproyecto.controlador;

import com.corenetworks.miproyecto.modelo.Tarea;
import com.corenetworks.miproyecto.servicio.IServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tareas")
public class ControladorTarea {

    @Autowired
    private IServicioTarea servicioTarea;

    @GetMapping
    public List<Tarea> consultarTodos(){
        return servicioTarea.consultarTodos();
    }

    @GetMapping("{idtarea}")
    public Tarea consultarUno(@PathVariable("idtarea") int idTarea){
        return  servicioTarea.consultarUno(idTarea);
    }
    @PostMapping
    public Tarea insertar(@RequestBody Tarea t){
        return servicioTarea.insertar(t);
    }
    @PutMapping
    public Tarea modificar(@RequestBody Tarea t){
        return servicioTarea.modificar(t);
    }
    @DeleteMapping("{idtarea}")
    public void eliminar(@PathVariable("idtarea") int idtarea){
        servicioTarea.eliminar(idtarea);
    }

}
