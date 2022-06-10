
package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.EmpleadoDao;
import com.emergentes.modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDaoImplementacion extends ConexionBaseDatos implements EmpleadoDao {
     @Override
    public void insert(Empleado empleado, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO empleados (nombres, paterno, materno, ci, fecha_nac, cargo_id,telefono, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,?,?,?,?,?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, empleado.getNombres());
        ps.setString(2, empleado.getPaterno());
        ps.setString(3, empleado.getMaterno());
        ps.setString(4, empleado.getCi());
        ps.setString(5,empleado.getFecha_nac());
        ps.setInt(6,empleado.getCargo_id());
        ps.setString(7,empleado.getTelefono());
        
        ps.setInt(8, sesion.getUsuario_id());
        ps.setInt(9, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Empleado empleado, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE empleados SET nombres=?,paterno=?, materno=?,ci=?,fecha_nac=?, cargo_id=?, telefono=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        ps.setString(1, empleado.getNombres());
        ps.setString(2, empleado.getPaterno());
        ps.setString(3, empleado.getMaterno());
        ps.setString(4, empleado.getCi());
        ps.setString(5,empleado.getFecha_nac());
        ps.setInt(6,empleado.getCargo_id());
        ps.setString(7,empleado.getTelefono());
        ps.setInt(8, sesion.getUsuario_id());
        ps.setInt(9, empleado.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM empleados WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Empleado getById(int id) throws Exception {
        Empleado empleado = new Empleado();
        String sql = "SELECT * FROM vehiculos WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            empleado.setId(rs.getInt("id"));
            
            empleado.setNombres(rs.getString("nombres"));
            empleado.setPaterno(rs.getString("paterno"));
            empleado.setMaterno(rs.getString("materno"));
            empleado.setCi(rs.getString("ci"));
            empleado.setFecha_nac(rs.getString("fecha_nac"));
            empleado.setCargo_id(rs.getInt("cargo_id"));
            empleado.setTelefono(rs.getString("telefono"));
            
        }
        this.desconectar();
        return empleado;
    }

    @Override
    public List<Empleado> getAll() throws Exception {
        List<Empleado> lista = null;
        String sql = "SELECT t1.*, t2.nombre FROM empleados t1 INNER JOIN catalogo_cargos t2 ON t2.id=t1.cargo_id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Empleado>();
        while (rs.next()) {            
            Empleado empleado = new Empleado();
            empleado.setId(rs.getInt("id"));
            empleado.setNombres(rs.getString("nombres"));
            empleado.setPaterno(rs.getString("paterno"));
            empleado.setMaterno(rs.getString("materno"));
            empleado.setCi(rs.getString("ci"));
            empleado.setFecha_nac(rs.getString("fecha_nac"));
            empleado.setCargo_id(rs.getInt("cargo_id"));
            empleado.setTelefono(rs.getString("telefono"));
            
            
            lista.add(empleado);
        }
        this.desconectar();
        return lista;
    }
}
