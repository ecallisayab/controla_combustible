package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.UsuarioDao;
import com.emergentes.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImplementacion extends ConexionBaseDatos implements UsuarioDao {

    @Override
    public void insert(Usuario usuario, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO usuarios (nombres_apellidos, usuario, contrasena, rol, estado, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,?,MD5(?),?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getNombres_apellidos());
        ps.setString(2, usuario.getUsuario());
        ps.setString(3, usuario.getContrasena());
        ps.setString(4, usuario.getRol());
        ps.setInt(5, usuario.getEstado());
        ps.setInt(6, sesion.getUsuario_id());
        ps.setInt(7, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Usuario usuario, SesionUsuario sesion) throws Exception {
        String sql_contrasena = "";
        int pos = 0;
        if (!usuario.getContrasena().equals("")) {
            sql_contrasena = ", contrasena=MD5(?)";
            pos++;
        }
        String sql = "UPDATE usuarios SET nombres_apellidos=?, usuario=?, rol=?, estado=?, actualizado_por=?, fecha_actualizacion=NOW()"+sql_contrasena+" WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getNombres_apellidos());
        ps.setString(2, usuario.getUsuario());
        ps.setString(3, usuario.getRol());
        ps.setInt(4, usuario.getEstado());
        ps.setInt(5, sesion.getUsuario_id());
        if (!usuario.getContrasena().equals("")) {
            ps.setString(6, usuario.getContrasena());
        }
        ps.setInt(6+pos, usuario.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM usuarios WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario usuario = new Usuario();
        String sql = "SELECT id, nombres_apellidos, usuario, rol, estado FROM usuarios WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            usuario.setId(rs.getInt("id"));
            usuario.setNombres_apellidos(rs.getString("nombres_apellidos"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setContrasena("");
            usuario.setRol(rs.getString("rol"));
            usuario.setEstado(rs.getInt("estado"));
        }
        this.desconectar();
        return usuario;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        String sql = "SELECT id, nombres_apellidos, usuario, rol, estado FROM usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Usuario>();
        while (rs.next()) {            
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombres_apellidos(rs.getString("nombres_apellidos"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setRol(rs.getString("rol"));
            usuario.setEstado(rs.getInt("estado"));
            lista.add(usuario);
        }
        this.desconectar();
        return lista;
    }
    
}
