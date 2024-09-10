package com.corenetworks.miproyecto.controlador;

import com.corenetworks.miproyecto.modelo.Tarea;
import com.corenetworks.miproyecto.servicio.IServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorTarea {

    @Autowired
    private IServicioTarea servicioTarea;

    @GetMapping("/consultartodos")
    public List<Tarea> consultarTodos(){
        return servicioTarea.consultarTodos();
    }

}
