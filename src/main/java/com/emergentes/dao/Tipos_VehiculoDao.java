/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Tipos_Vehiculo;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface Tipos_VehiculoDao {
     public void insert(Tipos_Vehiculo tipos_vehiculo, SesionUsuario sesion) throws Exception;
    public void update(Tipos_Vehiculo tipos_vehiculo, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public Tipos_Vehiculo getById(int id) throws Exception;
    public List<Tipos_Vehiculo> getAll() throws Exception;
}
