package TP5.Ej_3;

import java.util.ArrayList;

public class MaxActivities {
    private int[] initialTimes;
    private int[] finalTimes;
    private int nrActivities;
    private ArrayList<Integer> activitiesPlan;

    public MaxActivities(int nrActivities) {
        this.initialTimes = new int[nrActivities]; // Array de tiempos de inicio de cada actividad
        this.finalTimes = new int[nrActivities];   // Array de tiempos de finalizacion de cada actividad
        this.nrActivities = nrActivities;       // Cantidad de actividades que se van a realizar
        this.activitiesPlan = new ArrayList<>();   // ArrayList solucion
    }

    // Metodo para agregar datos a los array de tiempos
    public void addTimes(int[] inicialTimes, int[] finalTimes) {
        for (int i = 0; i < nrActivities; i++) {
            this.initialTimes[i] = inicialTimes[i];
            this.finalTimes[i] = finalTimes[i];
        }
    }

    // Metodo solucion
    public ArrayList<Integer> solve() {
        int i = 0;
        int activity = 0;
        while (i < nrActivities) {   // Se busca en el array de actividades la que comienza primero
            for (int j = 0; j < this.nrActivities; j++) {
                if (this.initialTimes[i] < this.initialTimes[activity])
                    activity = i;
            }           
            i++;
        }        
        this.activitiesPlan.add(activity); // Se agrega la actividad obtenida como primera
        for (int k = 0; k < nrActivities; k++) { // En este ciclo se comparan los tiempos de finalizacion con el de inicio de la siguiente actividad
            if (!activitiesPlan.contains(k)) {  // para verificar que no se solapen, si es asi, se agregan al plan de actividades.
                if (finalTimes[activitiesPlan.get(activitiesPlan.size() - 1)] <= initialTimes[k])
                    activitiesPlan.add(k);
            }
        }
        
        return activitiesPlan;
    }
}
