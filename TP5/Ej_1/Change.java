package TP5.Ej_1;

import java.util.ArrayList;

public class Change {
    private ArrayList<Integer> change;
    private ArrayList<Integer> solution;
    private int value;

    public Change(int value) {
        this.value = value;
        this.change = new ArrayList<>();
        this.solution = new ArrayList<>();
    }

    public void addChange(int coin) {
        this.change.add(coin);
    }

    public int getChange(int i) {
        return this.change.get(i);
    }

    private int getTotalChangeInSolution() {
        int total = 0;
        for (int i : solution)
            total += i;
        return total;
    }

    private boolean isSolution() {       
        return this.getTotalChangeInSolution() == this.value;
    }

    private int selectChange() {
        int totalSolution = this.getTotalChangeInSolution();
        int i = 0;
        while (i < change.size()) {
            if (this.getChange(i) <= (this.value - totalSolution))
                return change.get(i);
            i++;
        }   
        return -1;
    }

    private boolean isFactible(int x) {
        int total = getTotalChangeInSolution() + x;
        return total <= value;
    }

    public ArrayList<Integer> greedy() {       
        int x = 0;
        while (!isSolution() && x != -1) {
            x = selectChange(); // determina el mejor candidato del conjunto de opciones a seleccionar
            //C.borrar(x);  // no se borra del conjunto de opciones porque habia un numero ilimitado de cada billete
            if (x != -1 && isFactible(x))
                this.solution.add(x);
        }
        if (x == -1) {
            solution.clear();
            return new ArrayList<>();
        } else {        
            ArrayList<Integer> aux = new ArrayList<>(solution);
            return aux;
        }
    }
}