package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.EntradaDao;
import com.emergentes.modelo.Entrada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntradaDaoImplementacion extends ConexionBaseDatos implements EntradaDao {
    
    @Override
    public void insert(Entrada entrada, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO entradas (fecha, hora, almacen_id, responsable_id, proveedor_id, obs, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,CURTIME(),?,?,?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, entrada.getFecha());
        ps.setInt(2, entrada.getAlmacen_id());
        ps.setInt(3, entrada.getResponsable_id());
        ps.setInt(4, entrada.getProveedor_id());
        ps.setString(5, entrada.getObs());
        ps.setInt(6, sesion.getUsuario_id());
        ps.setInt(7, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Entrada entrada, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE entradas SET fecha=?, hora=CURTIME(), almacen_id=?, responsable_id=?, proveedor_id=?, obs=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, entrada.getFecha());
        ps.setInt(2, entrada.getAlmacen_id());
        ps.setInt(3, entrada.getResponsable_id());
        ps.setInt(4, entrada.getProveedor_id());
        ps.setString(5, entrada.getObs());
        ps.setInt(6, sesion.getUsuario_id());
        ps.setInt(7, entrada.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM entradas WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void deleteDetalle(int entrada_id) throws Exception {
        String sql = "DELETE FROM entradas_detalle WHERE entrada_id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, entrada_id);
        ps.executeUpdate();
    }

    @Override
    public Entrada getById(int id) throws Exception {
        Entrada entrada = new Entrada();
        String sql = "SELECT * FROM entradas WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            entrada.setId(rs.getInt("id"));
            entrada.setFecha(rs.getString("fecha"));
            entrada.setHora(rs.getString("hora"));
            entrada.setAlmacen_id(rs.getInt("almacen_id"));
            entrada.setResponsable_id(rs.getInt("responsable_id"));
            entrada.setProveedor_id(rs.getInt("proveedor_id"));
            entrada.setObs(rs.getString("obs"));
        }
        this.desconectar();
        return entrada;
    }

    @Override
    public List<Entrada> getAll() throws Exception {
        List<Entrada> lista = null;
        String sql = "SELECT t1.id, DATE_FORMAT(t1.fecha, '%d/%m/%Y') AS fecha, t1.hora, t1.almacen_id, t1.responsable_id, t1.proveedor_id, t1.obs, t2.nombre AS almacen, CONCAT(t3.nombres,' ',t3.paterno, ' ',t3.materno) AS responsable, t4.nombre AS proveedor FROM entradas t1 INNER JOIN almacenes t2 ON t1.almacen_id=t2.id INNER JOIN empleados t3 ON t1.responsable_id=t3.id INNER JOIN proveedores t4 ON t1.proveedor_id=t4.id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Entrada>();
        while (rs.next()) {            
            Entrada entrada = new Entrada();
            entrada.setId(rs.getInt("id"));
            entrada.setFecha(rs.getString("fecha"));
            entrada.setHora(rs.getString("hora"));
            entrada.setAlmacen_id(rs.getInt("almacen_id"));
            entrada.setAlmacen(rs.getString("almacen"));
            entrada.setResponsable_id(rs.getInt("responsable_id"));
            entrada.setResponsable(rs.getString("responsable"));
            entrada.setProveedor_id(rs.getInt("proveedor_id"));
            entrada.setProveedor(rs.getString("proveedor"));
            entrada.setObs(rs.getString("obs"));
            lista.add(entrada);
        }
        this.desconectar();
        return lista;
    }
}
