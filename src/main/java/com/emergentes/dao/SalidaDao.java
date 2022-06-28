package com.emergentes.dao;

import com.emergentes.modelo.Salida;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface SalidaDao {
    public void insert(Salida salida, SesionUsuario sesion) throws Exception;
    public void update(Salida salida, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public void deleteDetalle(int salida_id) throws Exception;
    public Salida getById(int id) throws Exception;
    public List<Salida> getAll() throws Exception;
}
