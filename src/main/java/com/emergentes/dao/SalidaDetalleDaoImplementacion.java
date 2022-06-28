package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.SalidaDetalleDao;
import com.emergentes.modelo.SalidaDetalle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalidaDetalleDaoImplementacion extends ConexionBaseDatos implements SalidaDetalleDao {
    
    @Override
    public void insert(SalidaDetalle salida_detalle, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO salidas_detalle (salida_id, item_id, cantidad, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, salida_detalle.getSalida_id());
        ps.setInt(2, salida_detalle.getItem_id());
        ps.setInt(3, salida_detalle.getCantidad());
        ps.setInt(4, sesion.getUsuario_id());
        ps.setInt(5, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(SalidaDetalle salida_detalle, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE salidas_detalle SET salida_id=?, item_id=?, cantidad=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, salida_detalle.getSalida_id());
        ps.setInt(2, salida_detalle.getItem_id());
        ps.setInt(3, salida_detalle.getCantidad());
        ps.setInt(4, sesion.getUsuario_id());
        ps.setInt(5, salida_detalle.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM salidas_detalle WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public SalidaDetalle getById(int id) throws Exception {
        SalidaDetalle salida_detalle = new SalidaDetalle();
        String sql = "SELECT * FROM salidas_detalle WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            salida_detalle.setId(rs.getInt("id"));
            salida_detalle.setSalida_id(rs.getInt("salida_id"));
            salida_detalle.setItem_id(rs.getInt("item_id"));
            salida_detalle.setCantidad(rs.getInt("cantidad"));
        }
        this.desconectar();
        return salida_detalle;
    }

    @Override
    public List<SalidaDetalle> getAll(int salida_id) throws Exception {
        List<SalidaDetalle> lista = null;
        String sql = "SELECT t1.*, t2.nombre FROM salidas_detalle t1 INNER JOIN items t2 ON t1.item_id=t2.id WHERE salida_id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, salida_id);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<SalidaDetalle>();
        while (rs.next()) {            
            SalidaDetalle salida_detalle = new SalidaDetalle();
            salida_detalle.setId(rs.getInt("id"));
            salida_detalle.setSalida_id(rs.getInt("salida_id"));
            salida_detalle.setItem_id(rs.getInt("item_id"));
            salida_detalle.setItem(rs.getString("nombre"));
            salida_detalle.setCantidad(rs.getInt("cantidad"));
            lista.add(salida_detalle);
        }
        this.desconectar();
        return lista;
    }
}
