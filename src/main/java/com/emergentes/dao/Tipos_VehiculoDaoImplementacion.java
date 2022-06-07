
package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.Tipos_VehiculoDao;
import com.emergentes.modelo.Tipos_Vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tipos_VehiculoDaoImplementacion extends ConexionBaseDatos implements Tipos_VehiculoDao {
   
    @Override
    public void insert(Tipos_Vehiculo tipos_vehiculo, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO catalogo_tipos_vehiculo (nombre, estado, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, tipos_vehiculo.getNombre());
        ps.setInt(2, tipos_vehiculo.getEstado());
        ps.setInt(3, sesion.getUsuario_id());
        ps.setInt(4, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Tipos_Vehiculo tipos_vehiculo, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE catalogo_tipos_vehiculo SET nombre=?, estado=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, tipos_vehiculo.getNombre());
        ps.setInt(2, tipos_vehiculo.getEstado());
        ps.setInt(3, sesion.getUsuario_id());
        ps.setInt(4, tipos_vehiculo.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM catalogo_tipos_vehiculo WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Tipos_Vehiculo getById(int id) throws Exception {
        Tipos_Vehiculo tipos_vehiculo = new Tipos_Vehiculo();
        String sql = "SELECT * FROM catalogo_tipos_vehiculo WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            tipos_vehiculo.setId(rs.getInt("id"));
            tipos_vehiculo.setNombre(rs.getString("nombre"));
            tipos_vehiculo.setEstado(rs.getInt("estado"));
        }
        this.desconectar();
        return tipos_vehiculo;
    }

    @Override
    public List<Tipos_Vehiculo> getAll() throws Exception {
        List<Tipos_Vehiculo> lista = null;
        String sql = "SELECT * FROM catalogo_tipos_vehiculo";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Tipos_Vehiculo>();
        while (rs.next()) {            
            Tipos_Vehiculo tipos_vehiculo = new Tipos_Vehiculo();
            tipos_vehiculo.setId(rs.getInt("id"));
            tipos_vehiculo.setNombre(rs.getString("nombre"));
            tipos_vehiculo.setEstado(rs.getInt("estado"));
            lista.add(tipos_vehiculo);
        }
        this.desconectar();
        return lista;
    }
    
}
