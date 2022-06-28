package com.emergentes.dao;

import com.emergentes.modelo.Entrada;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface EntradaDao {
    public void insert(Entrada entrada, SesionUsuario sesion) throws Exception;
    public void update(Entrada entrada, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public void deleteDetalle(int entrada_id) throws Exception;
    public Entrada getById(int id) throws Exception;
    public List<Entrada> getAll() throws Exception;
}
