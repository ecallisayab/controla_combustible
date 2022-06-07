package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.ItemDao;
import com.emergentes.modelo.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImplementacion extends ConexionBaseDatos implements ItemDao {

    @Override
    public void insert(Item item, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO items (nombre, unidad_medida, stock_min, stock_actual, estado, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,?,?,?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, item.getNombre());
        ps.setString(2, item.getUnidad_medida());
        ps.setInt(3, item.getStock_min());
        ps.setInt(4, item.getStock_actual());
        ps.setInt(5, item.getEstado());
        ps.setInt(6, sesion.getUsuario_id());
        ps.setInt(7, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Item item, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE items SET nombre=?, unidad_medida=?, stock_min=?, stock_actual=?, estado=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, item.getNombre());
        ps.setString(2, item.getUnidad_medida());
        ps.setInt(3, item.getStock_min());
        ps.setInt(4, item.getStock_actual());
        ps.setInt(5, item.getEstado());
        ps.setInt(6, sesion.getUsuario_id());
        ps.setInt(7, item.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM items WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Item getById(int id) throws Exception {
        Item item = new Item();
        String sql = "SELECT * FROM items WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            item.setId(rs.getInt("id"));
            item.setNombre(rs.getString("nombre"));
            item.setUnidad_medida(rs.getString("unidad_medida"));
            item.setStock_min(rs.getInt("stock_min"));
            item.setStock_actual(rs.getInt("stock_actual"));
            item.setEstado(rs.getInt("estado"));
        }
        this.desconectar();
        return item;
    }

    @Override
    public List<Item> getAll() throws Exception {
        List<Item> lista = null;
        String sql = "SELECT * FROM items";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Item>();
        while (rs.next()) {            
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setNombre(rs.getString("nombre"));
            item.setUnidad_medida(rs.getString("unidad_medida"));
            item.setStock_min(rs.getInt("stock_min"));
            item.setStock_actual(rs.getInt("stock_actual"));
            item.setEstado(rs.getInt("estado"));
            lista.add(item);
        }
        this.desconectar();
        return lista;
    }
    
}
