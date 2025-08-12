package org.rami;

public class Circuito implements Evaluable {
    private int tiempo; // segundos
    private int numFaltas;

    public Circuito(int tiempo, int numFaltas) {
        this.tiempo = tiempo;
        this.numFaltas = numFaltas;
    }

    public int getTiempo() {
        return tiempo;
    }

    @Override
    public boolean estaAprobado() {
        return numFaltas <= 2;
    }
}

