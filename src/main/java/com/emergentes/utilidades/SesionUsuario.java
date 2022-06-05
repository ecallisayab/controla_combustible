package com.emergentes.utilidades;

public class SesionUsuario {
    private int usuario_id;
    private String usuario_nombre;
    private String usuario_rol;
    
    public SesionUsuario() {
        usuario_id = 0;
        usuario_nombre = "";
        usuario_rol = "";
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_rol() {
        return usuario_rol;
    }

    public void setUsuario_rol(String usuario_rol) {
        this.usuario_rol = usuario_rol;
    }
    
}
