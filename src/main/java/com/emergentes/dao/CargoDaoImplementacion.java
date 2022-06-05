package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.CargoDao;
import com.emergentes.modelo.Cargo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargoDaoImplementacion extends ConexionBaseDatos implements CargoDao {

    @Override
    public void insert(Cargo cargo, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO catalogo_cargos (nombre, estado, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cargo.getNombre());
        ps.setInt(2, cargo.getEstado());
        ps.setInt(3, sesion.getUsuario_id());
        ps.setInt(4, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Cargo cargo, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE catalogo_cargos SET nombre=?, estado=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cargo.getNombre());
        ps.setInt(2, cargo.getEstado());
        ps.setInt(3, sesion.getUsuario_id());
        ps.setInt(4, cargo.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM catalogo_cargos WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Cargo getById(int id) throws Exception {
        Cargo cargo = new Cargo();
        String sql = "SELECT * FROM catalogo_cargos WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            cargo.setId(rs.getInt("id"));
            cargo.setNombre(rs.getString("nombre"));
            cargo.setEstado(rs.getInt("estado"));
        }
        this.desconectar();
        return cargo;
    }

    @Override
    public List<Cargo> getAll() throws Exception {
        List<Cargo> lista = null;
        String sql = "SELECT * FROM catalogo_cargos";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Cargo>();
        while (rs.next()) {            
            Cargo cargo = new Cargo();
            cargo.setId(rs.getInt("id"));
            cargo.setNombre(rs.getString("nombre"));
            cargo.setEstado(rs.getInt("estado"));
            lista.add(cargo);
        }
        this.desconectar();
        return lista;
    }
    
}
