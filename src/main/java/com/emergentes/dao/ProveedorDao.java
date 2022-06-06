package com.emergentes.dao;

import com.emergentes.modelo.Proveedor;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface ProveedorDao {
    public void insert(Proveedor proveedor, SesionUsuario sesion) throws Exception;
    public void update(Proveedor proveedor, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public Proveedor getById(int id) throws Exception;
    public List<Proveedor> getAll() throws Exception;
}
