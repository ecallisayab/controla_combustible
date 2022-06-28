package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.EntradaDetalleDao;
import com.emergentes.modelo.EntradaDetalle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntradaDetalleDaoImplementacion extends ConexionBaseDatos implements EntradaDetalleDao {
    @Override
    public void insert(EntradaDetalle entrada_detalle, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO entradas_detalle (entrada_id, item_id, cantidad, precio_unit, nro_factura, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,?,?,?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, entrada_detalle.getEntrada_id());
        ps.setInt(2, entrada_detalle.getItem_id());
        ps.setInt(3, entrada_detalle.getCantidad());
        ps.setFloat(4, entrada_detalle.getPrecio_unit());
        ps.setString(5, entrada_detalle.getNro_factura());
        ps.setInt(6, sesion.getUsuario_id());
        ps.setInt(7, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(EntradaDetalle entrada_detalle, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE entradas_detalle SET entrada_id=?, item_id=?, cantidad=?, precio_unit=?, nro_factura=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, entrada_detalle.getEntrada_id());
        ps.setInt(2, entrada_detalle.getItem_id());
        ps.setInt(3, entrada_detalle.getCantidad());
        ps.setFloat(4, entrada_detalle.getPrecio_unit());
        ps.setString(5, entrada_detalle.getNro_factura());
        ps.setInt(6, sesion.getUsuario_id());
        ps.setInt(7, entrada_detalle.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM entradas_detalle WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public EntradaDetalle getById(int id) throws Exception {
        EntradaDetalle entrada_detalle = new EntradaDetalle();
        String sql = "SELECT * FROM entradas_detalle WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            entrada_detalle.setId(rs.getInt("id"));
            entrada_detalle.setEntrada_id(rs.getInt("entrada_id"));
            entrada_detalle.setItem_id(rs.getInt("item_id"));
            entrada_detalle.setCantidad(rs.getInt("cantidad"));
            entrada_detalle.setPrecio_unit(rs.getFloat("precio_unit"));
            entrada_detalle.setNro_factura(rs.getString("nro_factura"));
        }
        this.desconectar();
        return entrada_detalle;
    }

    @Override
    public List<EntradaDetalle> getAll(int entrada_id) throws Exception {
        List<EntradaDetalle> lista = null;
        String sql = "SELECT t1.*, t2.nombre FROM entradas_detalle t1 INNER JOIN items t2 ON t1.item_id=t2.id WHERE entrada_id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, entrada_id);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<EntradaDetalle>();
        while (rs.next()) {            
            EntradaDetalle entrada_detalle = new EntradaDetalle();
            entrada_detalle.setId(rs.getInt("id"));
            entrada_detalle.setEntrada_id(rs.getInt("entrada_id"));
            entrada_detalle.setItem_id(rs.getInt("item_id"));
            entrada_detalle.setItem(rs.getString("nombre"));
            entrada_detalle.setCantidad(rs.getInt("cantidad"));
            entrada_detalle.setPrecio_unit(rs.getFloat("precio_unit"));
            entrada_detalle.setNro_factura(rs.getString("nro_factura"));
            lista.add(entrada_detalle);
        }
        this.desconectar();
        return lista;
    }
}
