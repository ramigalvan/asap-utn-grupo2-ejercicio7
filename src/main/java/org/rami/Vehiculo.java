package org.rami;

public abstract class Vehiculo {
    private String patente;
    private String marca;
    private double cilindrada;

    public Vehiculo(String patente, String marca, double cilindrada) {
        this.patente = patente;
        this.marca = marca;
        this.cilindrada = cilindrada;
    }

    public double getCilindrada() {
        return cilindrada;
    }
}
