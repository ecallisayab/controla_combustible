package com.emergentes.modelo;

public class Almacen {
    private int id;
    private String nombre;
    private String direccion;
    private int estado;
    
    public Almacen() {
        id = 0;
        nombre = "";
        direccion = "";
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
