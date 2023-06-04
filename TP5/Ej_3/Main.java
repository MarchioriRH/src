package TP5.Ej_3;

public class Main {
    public static void main(String[] args) {
        MaxActivities activities = new MaxActivities(10);

        int[] initialTimes = {6, 8, 17, 12, 13, 5, 18, 19, 20, 22};
        int[] finalTimes = {7, 12, 18, 13, 23, 16, 19, 23, 21, 23};

        activities.addTimes(initialTimes, finalTimes);

        System.out.println(activities.solve().toString());
    }
}
