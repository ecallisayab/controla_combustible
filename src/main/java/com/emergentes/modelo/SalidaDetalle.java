package com.emergentes.modelo;

public class SalidaDetalle {
    private int id;
    private int salida_id;
    private int item_id;
    private String item;
    private int cantidad;

    public SalidaDetalle() {
        id = 0;
        salida_id = 0;
        item_id = 0;
        item = "";
        cantidad = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalida_id() {
        return salida_id;
    }

    public void setSalida_id(int salida_id) {
        this.salida_id = salida_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
