package TP1.Ej_6_7;

public class Main {

    
    public static <T> void main (String [] args){
        Lista<String> L1 = Lista.createWithComparable();

        L1.insertFront("Pedro");
        L1.insertFront("Seba");
        L1.insertFront("Anibal");
        L1.insertFront("Jose");
        L1.insertFront("Federico");

        Lista<String> L2 = Lista.createWithComparable();

        L2.insertFront("Pedro");
        L2.insertFront("Anibal");
        L2.insertFront("Alberto");
        L2.insertFront("Martin");
        L2.insertFront("Luis");

        Lista<Integer> L3 = Lista.createWithComparable();

        L3.add(1);
        L3.add(30);
        L3.add(5);
        L3.add(12);
        L3.add(14);
       // L3.add(3);
        // L3.add(17);

        Lista<Integer> L4 = Lista.createWithComparable();

        L4.add(1);
        L4.add(5);
        L4.add(4);
        L4.add(15);
        L4.add(168);
        L4.add(19);
        L4.add(147);
        L4.add(3);
        

        /* Compose<String> c = new Compose<>();
        System.out.println("Lista de comunes desordenada: "+c.componerDesordenada(L1, L2));        
        System.out.println("Lista de distintos: "+c.componerDistintos(L1, L2)); */
        Compose<Integer> i = new Compose<>();
        //System.out.println("Lista de comunes ordenada: "+i.componerOrdenada(L3, L4));

        /* System.out.println("Lista 1: "+L1.toString());
        System.out.println("Lista 2: "+L2.toString()); */
        System.out.println("Lista 3: "+L3.toString());
        System.out.println("Lista 4: "+L4.toString());

        //System.out.println("Lista de comunes ordenada: "+i.componerOrdenadaIterador(L3, L4));
        System.out.println("Lista de distintos ordenada: "+i.componerDistintosIterador(L4, L3));
    }
}
