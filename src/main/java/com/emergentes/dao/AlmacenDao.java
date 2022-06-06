package com.emergentes.dao;

import com.emergentes.modelo.Almacen;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface AlmacenDao {
    public void insert(Almacen almacen, SesionUsuario sesion) throws Exception;
    public void update(Almacen almacen, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public Almacen getById(int id) throws Exception;
    public List<Almacen> getAll() throws Exception;
}
