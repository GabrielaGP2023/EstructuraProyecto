package com.corenetworks.miproyecto.servicio.impl;

import com.corenetworks.miproyecto.modelo.Tarea;
import com.corenetworks.miproyecto.repositorio.IGenericRepo;
import com.corenetworks.miproyecto.repositorio.ITareaRepo;
import com.corenetworks.miproyecto.servicio.ITareaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TareaServicioImpl extends CRUDImpl<Tarea,Integer> implements ITareaServicio {

    @Autowired
    private ITareaRepo tareaRepo;

    @Override
    protected IGenericRepo<Tarea, Integer> getRepo() {
        return tareaRepo;
    }

}
