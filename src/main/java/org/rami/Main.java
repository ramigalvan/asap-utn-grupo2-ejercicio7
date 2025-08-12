package org.rami;

public class Main {
    public static void main(String[] args) {
        Sede sede = new Sede("Sede Central");

        ExamenAuto examenAuto01 = new ExamenAuto(
                "2022-04-10",
                new Persona("11111111", "Laura", "Martinez"),
                new Auto("IHW900", "Fiat", 1400, 5),
                new Circuito(10, 2)
        );

        ExamenAuto examenAuto02 = new ExamenAuto(
                "2022-04-10",
                new Persona("22222222", "Marcelo", "Perez"),
                new Auto("LFP182", "Renault", 1400, 5),
                new Circuito(5, 2)
        );

        ExamenAuto examenAuto03 = new ExamenAuto(
                "2022-04-10",
                new Persona("33333333", "Victoria", "Gomez"),
                new Auto("CHC078", "Renault", 1400, 5),
                new Circuito(100, 1)
        );

        ExamenMoto examenMoto01 = new ExamenMoto(
                "2022-04-10",
                new Persona("44444444", "Damian", "Lopez"),
                new Moto("PAS911", "Kawasaki", 250, true)
        );

        examenMoto01.agregarCircuito(new Circuito(120, 1));
        examenMoto01.agregarCircuito(new Circuito(110, 0));

        sede.agregarExamen(examenAuto01);
        sede.agregarExamen(examenAuto02);
        sede.agregarExamen(examenAuto03);
        sede.agregarExamen(examenMoto01);

        System.out.println(sede.obtenerInforme());
    }
}
