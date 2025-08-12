package org.rami;

public class Moto extends Vehiculo {
    private boolean tieneEspejos;

    public Moto(String patente, String marca, double cilindrada, boolean tieneEspejos) {
        super(patente, marca, cilindrada);
        this.tieneEspejos = tieneEspejos;
    }


}
