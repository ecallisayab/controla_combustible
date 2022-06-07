
package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.VehiculoDao;
import com.emergentes.modelo.Vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDaoImplementacion extends ConexionBaseDatos implements VehiculoDao{
    @Override
    public void insert(Vehiculo vehiculo, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO vehiculos (tipo_id, marca, modelo, placa, tipo_combustible, estado, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,?,?,?,?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, vehiculo.getTipo_id());
        ps.setString(2, vehiculo.getMarca());
        ps.setString(3, vehiculo.getModelo());
        ps.setString(4, vehiculo.getPlaca());
        ps.setString(5, vehiculo.getTipo_combustible());
        ps.setInt(6, vehiculo.getEstado());
        ps.setInt(7, sesion.getUsuario_id());
        ps.setInt(8, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Vehiculo vehiculo, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE vehiculos SET tipo_id=?,marca=?, modelo=?,placa=?,tipo_combustible=?, estado=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, vehiculo.getTipo_id());
        ps.setString(2, vehiculo.getMarca());
        ps.setString(3, vehiculo.getModelo());
        ps.setString(4, vehiculo.getPlaca());
        ps.setString(5, vehiculo.getTipo_combustible());
        ps.setInt(6, vehiculo.getEstado());
        ps.setInt(7, sesion.getUsuario_id());
        ps.setInt(8, vehiculo.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM vehiculos WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Vehiculo getById(int id) throws Exception {
        Vehiculo vehiculo = new Vehiculo();
        String sql = "SELECT * FROM vehiculos WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            vehiculo.setId(rs.getInt("id"));
            vehiculo.setTipo_id(rs.getInt("tipo_id"));
             vehiculo.setMarca(rs.getString("marca"));
             vehiculo.setModelo(rs.getString("modelo"));
             vehiculo.setPlaca(rs.getString("placa"));
             vehiculo.setTipo_combustible(rs.getString("tipo_combustible"));
             vehiculo.setEstado(rs.getInt("estado"));
        }
        this.desconectar();
        return vehiculo;
    }

    @Override
    public List<Vehiculo> getAll() throws Exception {
        List<Vehiculo> lista = null;
        String sql = "SELECT t1.*, t2.nombre FROM vehiculos t1 INNER JOIN catalogo_tipos_vehiculo t2 ON t2.id=t1.tipo_id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Vehiculo>();
        while (rs.next()) {            
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setId(rs.getInt("id"));
            vehiculo.setTipo_nombre(rs.getString("nombre"));
            vehiculo.setMarca(rs.getString("marca"));
             vehiculo.setModelo(rs.getString("modelo"));
             vehiculo.setPlaca(rs.getString("placa"));
             vehiculo.setTipo_combustible(rs.getString("tipo_combustible"));
            vehiculo.setEstado(rs.getInt("estado"));
            lista.add(vehiculo);
        }
        this.desconectar();
        return lista;
    }
}
