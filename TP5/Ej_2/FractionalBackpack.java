package TP5.Ej_2;

public class FractionalBackpack {
    private double [] weights; // array de pesos
    private double [] fractions; // array de fracciones SOLUCION
    private double [] values; // array de valores
    private double [] maxViWi; // array de coeficientes
    private int weight, nrElem;

    public FractionalBackpack(int nrElem, int weight) {
        this.nrElem = nrElem;
        this.weight = weight;
        this.weights = new double [nrElem];
        this.values = new double [nrElem];
        this.fractions = new double[nrElem];
        this.maxViWi = new double[nrElem]; 
        for (int i = 0; i < nrElem; i++) // se inicializa el array de fracciones en 0
            fractions[i] = 0;
    }

    // Metodo para agregar los datos a los arreglos de pesos y valores
    public void addData(int [] values, int[] weights) {
        for (int i = 0; i < this.nrElem; i++) {
            this.values[i] = values[i];
            this.weights[i] = weights[i];
        }
        generateMaxViWi(); // Se invoca al metodo que genera el arreglo de coeficientes ViWi (valores/pesos)
    }

    // Metodo para generar el arreglo de coeficientes
    private void generateMaxViWi() {
        for (int i = 0; i < this.nrElem; i++) {
            this.maxViWi[i] = this.values[i] / this.weights[i]; // Se divide el valor por el peso de cada uno y se guada
        }
        System.out.print("MaxViWi: [ ");
        for (int i = 0; i < 5; i++) {
            if (i == maxViWi.length - 1)
                System.out.println(maxViWi[i] + " ]");
            else
                System.out.print(maxViWi[i]+" - ");
        }
    }

    // Metodo de seleccion, se devuelve el indice en el arreglo de pesos del elemento de mayor coeficiente del array ViWi
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

    // Metodo de resolucion
    public double[] solve() {
        double peso_actual = 0;
        while (peso_actual < this.weight) {   // Mientras el peso actual no supere al peso bojetivo
            int i = selection();  // Selecciona la mejor opcion
            if (peso_actual + weights[i] < this.weight) {  // Si el peso actual + el peso del mejor candidato no suepra el peso objetivo 
                fractions[i] = 1; // Agregar un entero a la solucion
                peso_actual = peso_actual + weights[i]; // Agrega al peso actual el peso del candidato
            } else {
                fractions[i] = (weight - peso_actual) / weights[i]; // Si el peso actual + el peso del mejor candidato suepra el peso objetivo 
                peso_actual = this.weight;                          // calcula la fraccion a agregar (peso objetivo - peso actual)/peso del candidato; 
            }
        }
        return fractions;

    }
}
