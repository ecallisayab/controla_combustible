package com.emergentes.modelo;

public class Item {
    private int id;
    private String nombre;
    private String unidad_medida;
    private int stock_min;
    private int stock_actual;
    private int estado;
    
    public Item() {
        id = 0;
        nombre = "";
        unidad_medida = "";
        stock_min = 0;
        stock_actual = 0;
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

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public int getStock_min() {
        return stock_min;
    }

    public void setStock_min(int stock_min) {
        this.stock_min = stock_min;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
