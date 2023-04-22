package TP1.Ej_8;

public class Main {
    public static <T> void main (String[] args){

        MyDoubleLinkedList L1 = new MyDoubleLinkedList();
        System.out.println(L1.isEmpty());
        L1.insertFront(1);
        L1.insertFront(2);
        L1.insertFront(3);
        L1.insertFront(4);
        L1.insertFront(5);
        L1.insertFront(6);
        L1.insertFront(7);

        /* System.out.println(L1.print(1));
        System.out.println(L1.print(12));
        System.out.println(L1.size());
        System.out.println(L1.isEmpty());
        System.out.println(L1.printAll());
        System.out.println("----------------------------------------");
        Node nAux = (Node) L1.extractFront();
        System.out.println(nAux.getInfo());
        System.out.println(L1.size());
        System.out.println(L1.printAll());        
        System.out.println("----------------------------------------");
        L1.insertEnd(9);
        System.out.println(L1.size());
        System.out.println(L1.printAll());  
        System.out.println("----------------------------------------");
        L1.insertInPosition(10, 7);
        System.out.println(L1.size());
        System.out.println(L1.printAll());
        System.out.println("----------------------------------------");
        System.out.println(L1.printAll());
        L1.deleteFromPosition(6);
        System.out.println(L1.size());*/
        System.out.println(L1.printAll()); 
        System.out.println("----------------------------------------");
        System.out.println(L1.printReversed());
    }
}
