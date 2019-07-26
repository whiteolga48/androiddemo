package com.mariusapps.medicdataretrofitv3.Model;



public class Lectura {

    private String timestamp;
    private long diastolica;
    private long sistolica;
    private double peso;
    private double longitud;
    private double latitud;

    public Lectura() {
    }

    public Lectura(String timestamp, long diastolica, long sistolica, double peso, double longitud, double latitud) {

        this.timestamp = timestamp;
        this.diastolica = diastolica;
        this.sistolica = sistolica;
        this.peso = peso;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public long getDiastolica() {
        return diastolica;
    }

    public void setDiastolica(long diastolica) {
        this.diastolica = diastolica;
    }

    public long getSistolica() {
        return sistolica;
    }

    public void setSistolica(long sistolica) {
        this.sistolica = sistolica;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    @Override
    public String toString() {
        return "Lectura{" +
                "timestamp='" + timestamp + '\'' +
                ", diastolica=" + diastolica +
                ", sistolica=" + sistolica +
                ", peso=" + peso +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                '}';
    }
}