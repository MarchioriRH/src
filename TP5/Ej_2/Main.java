package TP5.Ej_2;

public class Main {
    public static void main(String[] args) {
        FractionalBackpack bpk = new FractionalBackpack(5, 100);

        int[] weight = {10, 20, 30, 40, 50};
        int[] values = {20, 30, 66, 40, 60};
        bpk.addData(values, weight);
        double[] res = bpk.solve();
       
        System.out.print("Valores: [ ");
        for (int i = 0; i < 5; i++) {
            if (i == values.length - 1)
                System.out.println(values[i] + " ]");
            else
                System.out.print(values[i]+" - ");
        }
        System.out.print("Pesos: [ ");
        for (int i = 0; i < 5; i++) {
            if (i == weight.length - 1)
                System.out.println(weight[i] + " ]");
            else
                System.out.print(weight[i]+" - ");
        }
        System.out.print("Mejor distribucion: [ ");
        for (int i = 0; i < 5; i++) {
            if (i == res.length - 1) {
                System.out.print(String.format("%.3f", res[i]));
                System.out.print(" ]");
            }
            else {
                System.out.print(String.format("%.3f", res[i]));
                System.out.print(" - ");
            }
        }
    }
}
