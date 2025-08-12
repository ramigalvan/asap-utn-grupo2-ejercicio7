package org.rami;

public abstract class Examen implements Evaluable {
    private String fecha;
    private Persona persona;
    private Vehiculo vehiculo;

    public Examen(String fecha, Persona persona, Vehiculo vehiculo) {
        this.fecha = fecha;
        this.persona = persona;
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public abstract boolean vehiculoValido();
}


