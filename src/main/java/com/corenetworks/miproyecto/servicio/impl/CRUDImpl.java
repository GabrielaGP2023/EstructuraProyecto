package com.corenetworks.miproyecto.servicio.impl;

import com.corenetworks.miproyecto.repositorio.IGenericRepo;
import com.corenetworks.miproyecto.servicio.ICRUD;

import java.util.List;
import java.util.Optional;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T, ID> getRepo();


    public T registrar(T t) throws Exception{
        // TODO Auto-generated method stub
        return getRepo().save(t);
    }

    public T modificar(T t) throws Exception{
        // TODO Auto-generated method stub
        return getRepo().save(t);
    }

    public List<T> listar() throws Exception{
        // TODO Auto-generated method stub
        return getRepo().findAll();
    }

    public T listarPorId(ID id) throws Exception {
        // TODO Auto-generated method stub
        Optional<T> t1 = getRepo().findById(id);
        return t1.isPresent() ? t1.get() : null;
    }

    public void eliminar(ID id) throws Exception{
        // TODO Auto-generated method stub
        getRepo().deleteById(id);

    }
}
