package TP5.Ej_2;

public class FractionalBackpack {
    private double [] weights;
    private double [] fractions;
    private double [] values;
    private double [] maxViWi; 
    private int weight, nrElem;

    public FractionalBackpack(int nrElem, int weight) {
        this.nrElem = nrElem;
        this.weight = weight;
        this.weights = new double [nrElem];
        this.values = new double [nrElem];
        this.fractions = new double[nrElem];
        this.maxViWi = new double[nrElem];
        for (int i = 0; i < nrElem; i++)
            fractions[i] = 0;
    }

    public void addData(int [] values, int[] weights) {
        for (int i = 0; i < this.nrElem; i++) {
            this.values[i] = values[i];
            this.weights[i] = weights[i];
        }
        generateMaxViWi();
    }

    private void generateMaxViWi() {
        for (int i = 0; i < this.nrElem; i++) {
            this.maxViWi[i] = this.values[i] / this.weights[i];
        }
    }

    private int selection() {
        int i = 0;
        double res = 0;
        int pos = 0;
        while (i < nrElem) {
            if (res <= this.maxViWi[i]) {
                pos = i;
                res = this.maxViWi[i];
            }
            i++;
        }
        this.maxViWi[pos] = 0;
        return pos;
    }

    public double[] solve() {
        double peso_actual = 0;
        while (peso_actual < this.weight) {
            int i = selection(); 
            if (peso_actual + weights[i] < this.weight) {
                fractions[i] = 1;
                peso_actual = peso_actual + weights[i];
            } else {
                fractions[i] = (weight - peso_actual) / weights[i];
                peso_actual = this.weight;
            }
        }
        return fractions;

    }
}
