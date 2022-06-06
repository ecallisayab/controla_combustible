package com.emergentes.modelo;

public class Proveedor {
    private int id;
    private String nombre;
    private String fono1;
    private String fono2;
    private String direccion;
    private String correo;
    private int nit;
    private String rep_legal;
    private String rep_fono;
    private String rep_direccion;
    private String obs;
    
    public Proveedor() {
        id = 0;
        nombre = "";
        fono1 = "";
        fono2 = "";
        direccion = "";
        correo = "";
        nit = 0;
        rep_legal = "";
        rep_fono = "";
        rep_direccion = "";
        obs = "";
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

    public String getFono1() {
        return fono1;
    }

    public void setFono1(String fono1) {
        this.fono1 = fono1;
    }

    public String getFono2() {
        return fono2;
    }

    public void setFono2(String fono2) {
        this.fono2 = fono2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getRep_legal() {
        return rep_legal;
    }

    public void setRep_legal(String rep_legal) {
        this.rep_legal = rep_legal;
    }

    public String getRep_fono() {
        return rep_fono;
    }

    public void setRep_fono(String rep_fono) {
        this.rep_fono = rep_fono;
    }

    public String getRep_direccion() {
        return rep_direccion;
    }

    public void setRep_direccion(String rep_direccion) {
        this.rep_direccion = rep_direccion;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
}
