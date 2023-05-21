package TP4.Ej_5;

import java.util.Arrays;

public class ProcessorDistribution {
    private int minTime; // Variable para almacenar el tiempo total mínimo
    private int[] bestDistribution; // Almacenar la mejor distribución encontrada

    public int[] distributeProcessors(int m, int[] executionTimes) {
        int n = executionTimes.length;
        int[] currentDistribution = new int[n];
        int[] processors = new int[m];
        minTime = Integer.MAX_VALUE;
        bestDistribution = new int[n];

        backtrack(0, executionTimes, currentDistribution, processors);

        return bestDistribution;
    }

    private void backtrack(int currentProcess, int[] executionTimes, int[] currentDistribution, int[] processors) {
        int n = executionTimes.length;
        if (currentProcess == n) {
            int maxTime = getMax(processors);
            if (maxTime < minTime) {
                minTime = maxTime;
                bestDistribution = Arrays.copyOf(currentDistribution, n);
            }
            return;
        }

        for (int i = 0; i < processors.length; i++) {
            processors[i] += executionTimes[currentProcess];
            currentDistribution[currentProcess] = i;

            backtrack(currentProcess + 1, executionTimes, currentDistribution, processors);

            processors[i] -= executionTimes[currentProcess];
        }
    }

    private int getMax(int[] processors) {
        int maxTime = Integer.MIN_VALUE;
        for (int time : processors) {
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        ProcessorDistribution processorDistribution = new ProcessorDistribution();
        int[] executionTimes = {2, 4, 5, 10, 3}; // Ejemplo de tiempos de ejecución
        int[] distribution = processorDistribution.distributeProcessors(5, executionTimes);

        System.out.println("Mejor distribución de procesadores:");
        for (int i = 0; i < executionTimes.length; i++) {
            System.out.println("Proceso " + i + ": Procesador " + distribution[i]);
        }
        System.out.println("Tiempo total mínimo: " + processorDistribution.minTime);
    }
}
