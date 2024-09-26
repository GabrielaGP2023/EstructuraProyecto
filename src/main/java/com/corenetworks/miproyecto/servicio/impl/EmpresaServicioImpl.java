package com.corenetworks.miproyecto.servicio.impl;

import com.corenetworks.miproyecto.modelo.Empresa;
import com.corenetworks.miproyecto.repositorio.IEmpresaRepo;
import com.corenetworks.miproyecto.repositorio.IGenericRepo;
import com.corenetworks.miproyecto.servicio.IEmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServicioImpl extends CRUDImpl<Empresa,String> implements IEmpresaServicio {

    @Autowired
    private IEmpresaRepo empresaRepo;


    @Override
    protected IGenericRepo<Empresa, String> getRepo() {
        return empresaRepo;
    }
}
