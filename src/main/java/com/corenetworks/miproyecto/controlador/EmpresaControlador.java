package com.corenetworks.miproyecto.controlador;

import com.corenetworks.miproyecto.dto.EmpresaDTO;
import com.corenetworks.miproyecto.excepciones.ExcepcionNoEncontradoModelo;
import com.corenetworks.miproyecto.modelo.Empresa;
import com.corenetworks.miproyecto.servicio.IEmpresaServicio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresas")
public class EmpresaControlador {

    @Autowired
    private IEmpresaServicio servicioEmpresa;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<Empresa>> consultarTodos() throws Exception {
        return new ResponseEntity<>(servicioEmpresa.listar(),
                HttpStatus.OK);
    }
    @GetMapping("{idEmpresa}")
    public ResponseEntity<Empresa> consultarUno(@PathVariable("idEmpresa") String idEmpresa) throws Exception {
        Empresa respuestaBBDD = servicioEmpresa.listarPorId(idEmpresa);
        if(respuestaBBDD==null){
            throw new ExcepcionNoEncontradoModelo("ID No encontrado "+ idEmpresa);
        }
        return  new ResponseEntity<>(servicioEmpresa.listarPorId(idEmpresa),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EmpresaDTO> insertar(@Validated @RequestBody EmpresaDTO e) throws Exception {
        System.out.println(e.toString());
        Empresa objeto = mapper.map(e, Empresa.class);
        EmpresaDTO dtoResponse = mapper.map(servicioEmpresa.registrar(objeto) ,EmpresaDTO.class);
        return new ResponseEntity<>(dtoResponse,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EmpresaDTO> modificar(@Validated @RequestBody EmpresaDTO e) throws Exception {
        System.out.println(e.toString());
        Empresa objeto = mapper.map(e, Empresa.class);
        Empresa respuestaBBDD = servicioEmpresa.listarPorId(objeto.getNie());
        if(respuestaBBDD==null){
            throw new ExcepcionNoEncontradoModelo("ID No encontrado "+ objeto.getNie());
        }
        return new ResponseEntity<>(mapper.map(servicioEmpresa.modificar(objeto), EmpresaDTO.class),HttpStatus.OK);
    }
    @DeleteMapping("{idEmpresa}")
    public ResponseEntity<Void> eliminar(@PathVariable("idEmpresa") String idEmpresa) throws Exception {
        Empresa respuestaBBDD = servicioEmpresa.listarPorId(idEmpresa);
        if(respuestaBBDD==null){
            throw new ExcepcionNoEncontradoModelo("ID No encontrado "+ idEmpresa);
        }
        servicioEmpresa.eliminar(idEmpresa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
