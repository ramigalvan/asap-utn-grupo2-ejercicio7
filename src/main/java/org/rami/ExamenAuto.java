package org.rami;

public class ExamenAuto extends Examen {
    private Circuito circuito;
    private static final int TIEMPO_MAXIMO_SEGUNDOS = 90;

    public ExamenAuto(String fecha, Persona persona, Auto auto, Circuito circuito) {
        super(fecha, persona, auto);
        this.circuito = circuito;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    @Override
    public boolean estaAprobado() {
        return vehiculoValido() && circuito.estaAprobado() && circuito.getTiempo() <= TIEMPO_MAXIMO_SEGUNDOS;
    }

    @Override
    public boolean vehiculoValido() {
        return getVehiculo() instanceof Auto;
    }

}

