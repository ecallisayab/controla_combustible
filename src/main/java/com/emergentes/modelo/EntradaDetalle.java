package com.emergentes.modelo;

public class EntradaDetalle {
    private int id;
    private int entrada_id;
    private int item_id;
    private String item;
    private int cantidad;
    private float precio_unit;
    private String nro_factura;

    public EntradaDetalle() {
        id = 0;
        entrada_id = 0;
        item_id = 0;
        item = "";
        cantidad = 0;
        precio_unit = 0;
        nro_factura = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntrada_id() {
        return entrada_id;
    }

    public void setEntrada_id(int entrada_id) {
        this.entrada_id = entrada_id;
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

    public float getPrecio_unit() {
        return precio_unit;
    }

    public void setPrecio_unit(float precio_unit) {
        this.precio_unit = precio_unit;
    }

    public String getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(String nro_factura) {
        this.nro_factura = nro_factura;
    }
    
}
