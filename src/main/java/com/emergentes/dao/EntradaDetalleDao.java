package com.emergentes.dao;

import com.emergentes.modelo.EntradaDetalle;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface EntradaDetalleDao {
    public void insert(EntradaDetalle entrada_detalle, SesionUsuario sesion) throws Exception;
    public void update(EntradaDetalle entrada_detalle, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public EntradaDetalle getById(int id) throws Exception;
    public List<EntradaDetalle> getAll(int entrada_id) throws Exception;
}
