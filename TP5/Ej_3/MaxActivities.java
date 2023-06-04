package TP5.Ej_3;

import java.util.ArrayList;

public class MaxActivities {
    private int[] initialTimes;
    private int[] finalTimes;
    private int nrActivities;
    private ArrayList<Integer> activitiesPlan;

    public MaxActivities(int nrActivities) {
        this.initialTimes = new int[nrActivities];
        this.finalTimes = new int[nrActivities];
        this.nrActivities = nrActivities;
        this.activitiesPlan = new ArrayList<>();
    }

    public void addTimes(int[] inicialTimes, int[] finalTimes) {
        for (int i = 0; i < nrActivities; i++) {
            this.initialTimes[i] = inicialTimes[i];
            this.finalTimes[i] = finalTimes[i];
        }
    }

    public ArrayList<Integer> solve() {
        int i = 0;
        int activity = 0;
        while (i < nrActivities) {
            for (int j = 0; j < this.nrActivities; j++) {
                if (this.initialTimes[i] < this.initialTimes[activity])
                    activity = i;
            }           
            i++;
        }        
        this.activitiesPlan.add(activity);
        for (int k = 0; k < nrActivities; k++) {
            if (!activitiesPlan.contains(k)) {
                if (finalTimes[activitiesPlan.get(activitiesPlan.size() - 1)] <= initialTimes[k])
                    activitiesPlan.add(k);
            }
        }
        
        return activitiesPlan;
    }
}
