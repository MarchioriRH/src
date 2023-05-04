package TP3.Ej_1;

import java.util.Iterator;

public class main <T extends Comparable<? super T>> {

    public static <T> void printArch(Arco<T> a){        
        if (a == null) 
            System.out.println("No existe el arco.");
        else
            System.out.println(a.toString());
    }

    public static <T> void main (String[] args){
        Grafo<Integer> g1 = new GrafoDirigido<>();

        g1.agregarVertice(1);
        g1.agregarVertice(2);
        g1.agregarVertice(3);
        g1.agregarVertice(4);
        g1.agregarVertice(5);
        g1.agregarVertice(6);
        g1.agregarVertice(7);
        g1.agregarVertice(8);


        g1.agregarArco(1, 3, 3);        
        g1.agregarArco(1, 5, 23);        
        g1.agregarArco(1, 2, 21);
        g1.agregarArco(2, 3, 21);
        g1.agregarArco(2, 5, 2);
        g1.agregarArco(3, 1, 12);
        g1.agregarArco(4, 5, 4);
        g1.agregarArco(4, 6, 44);
        
        g1.agregarArco(5, 3, 2);
        g1.agregarArco(6, 5, 2);
        g1.agregarArco(7, 4, 2);
        g1.agregarArco(7, 8, 2);
        g1.agregarArco(7, 6, 2);
        g1.agregarArco(8, 5, 2);

        //System.out.println(g1.toString()); 
        
        g1.DFS();
        g1.printDFSTimes();

        //g1.BFS();
        /* Arco<Integer> res = g1.obtenerArco(1,3);
        printArch(res);
        System.out.println("Cantidad de vertices: " + g1.cantidadVertices());
        System.out.println("Cantidad de arcos: " + g1.cantidadArcos());
        System.out.println("Borrar arco (1, 3): ");
        g1.borrarArco(1,3);
        res = g1.obtenerArco(1,3);
        System.out.print("Obtener arco (1,3): "); printArch(res);
       
        //g1.borrarVertice(2);
        System.out.println("Cantidad de vertices: " + g1.cantidadVertices());
        System.out.println(g1.toString());
        System.out.println(g1.contieneVertice(13));
        System.out.println(g1.existeArco(4, 5));
        System.out.println(g1.existeArco(5, 4));
        System.out.println("Cantidad de arcos: " + g1.cantidadArcos());

        Iterator<Integer> itAdy = g1.obtenerAdyacentes(5);
        System.out.print("Adyacentes de 5: ");
        while (itAdy.hasNext()){
            Integer data = itAdy.next();
            System.out.print(data + ", ");
        }
        System.out.println();

        Iterator<Integer> itVertices = g1.obtenerVertices();
        System.out.print("Vertices: ");
        while (itVertices.hasNext()){
            Integer data = itVertices.next();
            System.out.print(data + ", ");
        }
        System.out.println();

        Iterator<Arco<Integer>> itArcos = g1.obtenerArcos();
        System.out.print("Arcos: ");
        while (itArcos.hasNext()){
            Arco<Integer> data = itArcos.next();
            System.out.print(data + ", ");
        }
        System.out.println();

        itArcos = g1.obtenerArcos(4);
        System.out.print("Arcos del vertice 4: ");
        while (itArcos.hasNext()){
            Arco<Integer> data = itArcos.next();
            System.out.print(data + ", ");
        }
        System.out.println();
  */
    }
}
