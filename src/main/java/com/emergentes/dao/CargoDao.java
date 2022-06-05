package com.emergentes.dao;

import com.emergentes.modelo.Cargo;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface CargoDao {
    public void insert(Cargo cargo, SesionUsuario sesion) throws Exception;
    public void update(Cargo cargo, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public Cargo getById(int id) throws Exception;
    public List<Cargo> getAll() throws Exception;
}
