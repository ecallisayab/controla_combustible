
package com.emergentes.modelo;


public class Empleado {
    private int id;
    private String nombres;
    private String paterno;
    private String materno;
    private String ci;
    private String fecha_nac;
    private int cargo_id;
    private String telefono;
    private String cargo;
    
     public Empleado() {
        id = 0;
        nombres = "";
        paterno= "";
        materno= "";
        ci ="" ;
        fecha_nac = "";
        cargo_id = 0;
        telefono = "";
        cargo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
