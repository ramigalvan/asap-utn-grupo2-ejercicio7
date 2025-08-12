package org.rami;

public class Auto extends Vehiculo {
    private int cantidadPuertas;

    public Auto(String patente, String marca, double cilindrada, int cantidadPuertas) {
        super(patente, marca, cilindrada);
        this.cantidadPuertas = cantidadPuertas;
    }

}
