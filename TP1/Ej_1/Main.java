package TP1.Ej_1;

public class Main {
    public static void main (String [] args){
        Lista<Integer> L1 = Lista.createWithComparable();

        L1.add(2);
        L1.add(8);
        L1.add(3);
        L1.add(14);
        L1.add(1);
        System.out.println("Lista: "+L1.toString());
        L1.insertFront(33);        
        System.out.println("Lista: "+L1.toString());
        System.out.println("Extract front: "+L1.extractFront());
        System.out.println("Lista: "+L1.toString());
        System.out.println("Get 4: "+L1.get(4));
    }
}
