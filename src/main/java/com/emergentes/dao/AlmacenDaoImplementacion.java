package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.AlmacenDao;
import com.emergentes.modelo.Almacen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlmacenDaoImplementacion extends ConexionBaseDatos implements AlmacenDao {

    @Override
    public void insert(Almacen almacen, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO almacenes (nombre, direccion, estado, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, almacen.getNombre());
        ps.setString(2, almacen.getDireccion());
        ps.setInt(3, almacen.getEstado());
        ps.setInt(4, sesion.getUsuario_id());
        ps.setInt(5, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Almacen almacen, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE almacenes SET nombre=?, direccion=?, estado=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, almacen.getNombre());
        ps.setString(2, almacen.getDireccion());
        ps.setInt(3, almacen.getEstado());
        ps.setInt(4, sesion.getUsuario_id());
        ps.setInt(5, almacen.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM almacenes WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Almacen getById(int id) throws Exception {
        Almacen almacen = new Almacen();
        String sql = "SELECT * FROM almacenes WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            almacen.setId(rs.getInt("id"));
            almacen.setNombre(rs.getString("nombre"));
            almacen.setDireccion(rs.getString("direccion"));
            almacen.setEstado(rs.getInt("estado"));
        }
        this.desconectar();
        return almacen;
    }

    @Override
    public List<Almacen> getAll() throws Exception {
        List<Almacen> lista = null;
        String sql = "SELECT * FROM almacenes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Almacen>();
        while (rs.next()) {            
            Almacen almacen = new Almacen();
            almacen.setId(rs.getInt("id"));
            almacen.setNombre(rs.getString("nombre"));
            almacen.setDireccion(rs.getString("direccion"));
            almacen.setEstado(rs.getInt("estado"));
            lista.add(almacen);
        }
        this.desconectar();
        return lista;
    }
    
}
