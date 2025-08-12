package org.rami;

import java.util.ArrayList;
import java.util.List;

public class ExamenMoto extends Examen {
    // Constantes
    private static final int CILINDRADA_ALTA_LIMITE = 150;
    private static final int MAX_CIRCUITOS_DESAPROBADOS_BAJA = 1;
    private static final int TIEMPO_TOTAL_MAX_BAJA = 120;
    private static final int SIN_CIRCUITOS_DESAPROBADOS = 0;

    private List<Circuito> circuitosHechos;

    public ExamenMoto(String fecha, Persona persona, Moto moto) {
        super(fecha, persona, moto);
        this.circuitosHechos = new ArrayList<>();
    }

    public void agregarCircuito(Circuito circuito) {
        circuitosHechos.add(circuito);
    }

    @Override
    public boolean estaAprobado() {
        boolean resultado = false;

        if (vehiculoValido()) {
            if (esAltaCilindrada()) {
                if (aprobarAltaCilindrada()) {
                    resultado = true;
                }
            } else {
                if (aprobarBajaCilindrada()) {
                    resultado = true;
                }
            }
        }

        return resultado;
    }

    private boolean esAltaCilindrada() {
        boolean resultado = false;

        Moto moto = (Moto) getVehiculo();
        if (moto.getCilindrada() > CILINDRADA_ALTA_LIMITE) {
            resultado = true;
        }

        return resultado;
    }

    private boolean aprobarAltaCilindrada() {
        boolean resultado = false;

        if (cantidadCircuitosDesaprobados() == SIN_CIRCUITOS_DESAPROBADOS) {
            resultado = true;
        }

        return resultado;
    }

    private boolean aprobarBajaCilindrada() {
        boolean resultado = false;

        if (cantidadCircuitosDesaprobados() <= MAX_CIRCUITOS_DESAPROBADOS_BAJA
                && tiempoTotalCircuitos() <= TIEMPO_TOTAL_MAX_BAJA) {
            resultado = true;
        }

        return resultado;
    }

    private int cantidadCircuitosDesaprobados() {
        int contador = 0;

        for (Circuito c : circuitosHechos) {
            if (!c.estaAprobado()) {
                contador++;
            }
        }

        return contador;
    }

    private int tiempoTotalCircuitos() {
        int total = 0;

        for (Circuito c : circuitosHechos) {
            total += c.getTiempo();
        }

        return total;
    }

    @Override
    public boolean vehiculoValido() {
        boolean resultado = false;

        if (getVehiculo() instanceof Moto) {
            resultado = true;
        }

        return resultado;
    }
}
