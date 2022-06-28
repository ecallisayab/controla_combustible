package com.emergentes.dao;

import com.emergentes.modelo.SalidaDetalle;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface SalidaDetalleDao {
    public void insert(SalidaDetalle salida_detalle, SesionUsuario sesion) throws Exception;
    public void update(SalidaDetalle salida_detalle, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public SalidaDetalle getById(int id) throws Exception;
    public List<SalidaDetalle> getAll(int entrada_id) throws Exception;
}
