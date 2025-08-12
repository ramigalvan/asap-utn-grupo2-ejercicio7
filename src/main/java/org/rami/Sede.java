package org.rami;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Sede {
    private String nombre;
    private List<Examen> examenes;

    public Sede(String nombre) {
        this.nombre = nombre;
        this.examenes = new ArrayList<>();
    }

    /**
     * @param examen
     */
    public void agregarExamen(Examen examen) {
        this.examenes.add(examen);
    }

    public String obtenerInforme() {
        Gson gson = new Gson();
        int reprobados = 0;
        int total = examenes.size();
        double porcReprobados = 0;
        for (Examen examen : examenes) {
            if (!examen.estaAprobado()) {
                reprobados++;
            }
        }
        if (total > 0) {
            porcReprobados = (reprobados * 100) / total;
        }
        double promTiempoAutosAprobados = promedioTiempoAutosAprobados();

        //armar json
        com.google.gson.JsonObject json = new com.google.gson.JsonObject();
        json.addProperty("porcReprobados", porcReprobados);
        json.addProperty("promTiempoAutosAprobados", promTiempoAutosAprobados);
        return gson.toJson(json);
    }

    private double promedioTiempoAutosAprobados() {
        double sumaTiempo = 0;
        int cantidad = 0;
        double promedio = 0;

        for (Examen examen : examenes) {
            if (examen instanceof ExamenAuto) {
                ExamenAuto examenAuto = (ExamenAuto) examen;
                if (examenAuto.estaAprobado()) {
                    sumaTiempo += examenAuto.getCircuito().getTiempo();
                    cantidad++;
                }
            }
        }

        if (cantidad > 0) {
            promedio = sumaTiempo / cantidad;
        }

        return promedio;
    }
}


