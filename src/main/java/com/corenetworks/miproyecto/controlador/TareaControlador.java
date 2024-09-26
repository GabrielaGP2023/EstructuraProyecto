package com.corenetworks.miproyecto.controlador;

import com.corenetworks.miproyecto.dto.TareaDTO;
import com.corenetworks.miproyecto.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.miproyecto.modelo.Tarea;
import com.corenetworks.miproyecto.servicio.ITareaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tareas")
public class TareaControlador {

    @Autowired
    private ITareaServicio tareaServicio;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<TareaDTO>> consultarTodos() throws Exception {
        List<TareaDTO> resultado = tareaServicio.listar()
                .stream().map(x -> mapper.map(x, TareaDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(resultado,
                HttpStatus.OK);
    }
    @GetMapping("{idtarea}")
    public ResponseEntity<TareaDTO> consultarUno(@PathVariable("idtarea") int idTarea) throws Exception {
        Tarea respuestaBBDD = tareaServicio.listarPorId(idTarea);
        if(respuestaBBDD==null){
            throw new ExcepcionNoEncontradoModelo("ID No encontrado "+ idTarea);
        }
        return  new ResponseEntity<>(mapper.map(tareaServicio.listarPorId(idTarea), TareaDTO.class),HttpStatus.OK);
    }
    @GetMapping("/hateoas/{tareaId}")
    public EntityModel<TareaDTO> consultarUnoHateoas(@PathVariable("tareaId") int id) throws Exception {
        Tarea respuestaBBDD = tareaServicio.listarPorId(id);
        if(respuestaBBDD==null){
            throw new ExcepcionNoEncontradoModelo("ID Tarea No encontrado" + id);
        }
        WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).consultarUnoHateoas(id));
        return  EntityModel.of(mapper.map(respuestaBBDD,TareaDTO.class)).add(link1.withRel("self"));
    }
    @PostMapping("/hateoas")
    public ResponseEntity<Void> insertarConHateoas(@Validated @RequestBody TareaDTO tDto) throws Exception {
        Tarea objetoBBDD = tareaServicio.registrar(mapper.map(tDto,Tarea.class));
        TareaDTO objetoDto = mapper.map(objetoBBDD, TareaDTO.class);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(objetoDto.getIdTarea()).toUri();
        return ResponseEntity.created(location).build();
    }


    @PostMapping
    public ResponseEntity<TareaDTO> insertar(@Validated @RequestBody TareaDTO t) throws Exception {
        Tarea objetoBBDD = mapper.map(t, Tarea.class);
        TareaDTO dtoResponse = mapper.map(tareaServicio.registrar(objetoBBDD) ,TareaDTO.class);
        return new ResponseEntity<>(dtoResponse,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TareaDTO> modificar(@Validated @RequestBody TareaDTO t) throws Exception {
        Tarea objetoBBDD = mapper.map(t,Tarea.class);
        Tarea respuestaBBDD = tareaServicio.listarPorId(objetoBBDD.getIdTarea());
        if(respuestaBBDD==null){
            throw new ExcepcionNoEncontradoModelo("ID No encontrado "+ t.getIdTarea());
        }
        return new ResponseEntity<>(mapper.map(tareaServicio.modificar(objetoBBDD), TareaDTO.class),HttpStatus.OK);
    }
    @DeleteMapping("{idtarea}")
    public ResponseEntity<Void> eliminar(@PathVariable("idtarea") int idTarea) throws Exception {
        Tarea respuestaBBDD = tareaServicio.listarPorId(idTarea);
        if(respuestaBBDD==null){
            throw new ExcepcionNoEncontradoModelo("ID No encontrado "+ idTarea);
        }
        tareaServicio.eliminar(idTarea);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
