
package com.emergentes.dao;

import com.emergentes.modelo.Vehiculo;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface VehiculoDao {
      public void insert(Vehiculo vehiculo, SesionUsuario sesion) throws Exception;
    public void update(Vehiculo vehiculo, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public Vehiculo getById(int id) throws Exception;
    public List<Vehiculo> getAll() throws Exception;
}
