package com.mariusapps.pollolokoretrofit.model;

public class Camarero {



    private Long codigo;
    private String nombre;


    public Camarero() {

    }



    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Camarero{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';



    }
}
