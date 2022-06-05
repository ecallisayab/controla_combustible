package com.emergentes.modelo;

public class Cargo {
    private int id;
    private String nombre;
    private int estado;
    
    public Cargo() {
        id = 0;
        nombre = "";
        estado = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
