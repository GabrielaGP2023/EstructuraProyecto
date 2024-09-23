package com.corenetworks.miproyecto.repositorio;

import com.corenetworks.miproyecto.modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ICRUDTarea extends JpaRepository<Tarea,Integer> {

}
