package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.modelo.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao extends ConexionBaseDatos {
    public SesionUsuario autenticar(Login login) throws Exception {
        SesionUsuario sesion = new SesionUsuario();
        String sql = "SELECT id, nombres_apellidos, rol FROM usuarios WHERE usuario=? AND contrasena=MD5(?) LIMIT 1";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, login.getUsuario());
        ps.setString(2, login.getContrasena());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            sesion.setUsuario_id(rs.getInt("id"));
            sesion.setUsuario_nombre(rs.getString("nombres_apellidos"));
            sesion.setUsuario_rol(rs.getString("rol"));
        }
        this.desconectar();
        return sesion;
    }
}
