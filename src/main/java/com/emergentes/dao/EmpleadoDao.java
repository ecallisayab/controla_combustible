
package com.emergentes.dao;

import com.emergentes.modelo.Empleado;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface EmpleadoDao {
      public void insert(Empleado empleado, SesionUsuario sesion) throws Exception;
    public void update(Empleado empleado, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public Empleado getById(int id) throws Exception;
    public List<Empleado> getAll() throws Exception;
}