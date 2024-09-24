package com.corenetworks.miproyecto.controlador;

import com.corenetworks.miproyecto.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.miproyecto.modelo.Tarea;
import com.corenetworks.miproyecto.servicio.IServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tareas")
public class ControladorTarea {

    @Autowired
    private IServicioTarea servicioTarea;

    @GetMapping
    public ResponseEntity<List<Tarea>> consultarTodos(){
        return new ResponseEntity<>(servicioTarea.consultarTodos(),
                HttpStatus.OK);
    }

    @GetMapping("{idtarea}")
    public ResponseEntity<Tarea> consultarUno(@PathVariable("idtarea") int idTarea){
        Tarea respuestaBBDD = servicioTarea.consultarUno(idTarea);
        if(respuestaBBDD==null){
            throw new ExcepcionNoEncontradoModelo("ID No encontrado "+ idTarea);
        }
        return  new ResponseEntity<>(servicioTarea.consultarUno(idTarea),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Tarea> insertar(@RequestBody Tarea t){
        return new ResponseEntity<>(servicioTarea.insertar(t),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Tarea> modificar(@RequestBody Tarea t){
        Tarea respuestaBBDD = servicioTarea.consultarUno(t.getIdTarea());
        if(respuestaBBDD==null){
            throw new ExcepcionNoEncontradoModelo("ID No encontrado "+ t.getIdTarea());
        }
        return new ResponseEntity<>(servicioTarea.modificar(t),HttpStatus.OK);
    }
    @DeleteMapping("{idtarea}")
    public ResponseEntity<Void> eliminar(@PathVariable("idtarea") int idTarea){
        Tarea respuestaBBDD = servicioTarea.consultarUno(idTarea);
        if(respuestaBBDD==null){
            throw new ExcepcionNoEncontradoModelo("ID No encontrado "+ idTarea);
        }
        servicioTarea.eliminar(idTarea);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
