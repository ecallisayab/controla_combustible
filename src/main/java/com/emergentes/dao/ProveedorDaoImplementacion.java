package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.ProveedorDao;
import com.emergentes.modelo.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDaoImplementacion extends ConexionBaseDatos implements ProveedorDao {

    @Override
    public void insert(Proveedor proveedor, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO proveedores (nombre, fono_1, fono_2, direccion, correo, nit, rep_legal, rep_fono, rep_direccion, obs, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, proveedor.getNombre());
        ps.setString(2, proveedor.getFono1());
        ps.setString(3, proveedor.getFono2());
        ps.setString(4, proveedor.getDireccion());
        ps.setString(5, proveedor.getCorreo());
        ps.setInt(6, proveedor.getNit());
        ps.setString(7, proveedor.getRep_legal());
        ps.setString(8, proveedor.getRep_fono());
        ps.setString(9, proveedor.getRep_direccion());
        ps.setString(10, proveedor.getObs());
        ps.setInt(11, sesion.getUsuario_id());
        ps.setInt(12, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Proveedor proveedor, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE proveedores SET nombre=?, fono_1=?, fono_2=?, direccion=?, correo=?, nit=?, rep_legal=?, rep_fono=?, rep_direccion=?, obs=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, proveedor.getNombre());
        ps.setString(2, proveedor.getFono1());
        ps.setString(3, proveedor.getFono2());
        ps.setString(4, proveedor.getDireccion());
        ps.setString(5, proveedor.getCorreo());
        ps.setInt(6, proveedor.getNit());
        ps.setString(7, proveedor.getRep_legal());
        ps.setString(8, proveedor.getRep_fono());
        ps.setString(9, proveedor.getRep_direccion());
        ps.setString(10, proveedor.getObs());
        ps.setInt(11, sesion.getUsuario_id());
        ps.setInt(12, proveedor.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM proveedores WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Proveedor getById(int id) throws Exception {
        Proveedor proveedor = new Proveedor();
        String sql = "SELECT * FROM proveedores WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            proveedor.setId(rs.getInt("id"));
            proveedor.setNombre(rs.getString("nombre"));
            proveedor.setFono1(rs.getString("fono_1"));
            proveedor.setFono2(rs.getString("fono_2"));
            proveedor.setDireccion(rs.getString("direccion"));
            proveedor.setCorreo(rs.getString("correo"));
            proveedor.setNit(rs.getInt("nit"));
            proveedor.setRep_legal(rs.getString("rep_legal"));
            proveedor.setRep_fono(rs.getString("rep_fono"));
            proveedor.setRep_direccion(rs.getString("rep_direccion"));
            proveedor.setObs(rs.getString("obs"));
        }
        this.desconectar();
        return proveedor;
    }

    @Override
    public List<Proveedor> getAll() throws Exception {
        List<Proveedor> lista = null;
        String sql = "SELECT * FROM proveedores";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Proveedor>();
        while (rs.next()) {            
            Proveedor proveedor = new Proveedor();
            proveedor.setId(rs.getInt("id"));
            proveedor.setNombre(rs.getString("nombre"));
            proveedor.setFono1(rs.getString("fono_1"));
            proveedor.setFono2(rs.getString("fono_2"));
            proveedor.setDireccion(rs.getString("direccion"));
            proveedor.setCorreo(rs.getString("correo"));
            proveedor.setNit(rs.getInt("nit"));
            proveedor.setRep_legal(rs.getString("rep_legal"));
            proveedor.setRep_fono(rs.getString("rep_fono"));
            proveedor.setRep_direccion(rs.getString("rep_direccion"));
            proveedor.setObs(rs.getString("obs"));
            lista.add(proveedor);
        }
        this.desconectar();
        return lista;
    }
    
}
