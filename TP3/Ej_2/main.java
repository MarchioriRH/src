package TP3.Ej_2;

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

        Vertice<Integer> v1 = new Vertice<>(1);
        Vertice<Integer> v2 = new Vertice<>(2);
        Vertice<Integer> v3 = new Vertice<>(3);
        Vertice<Integer> v4 = new Vertice<>(4);
        Vertice<Integer> v5 = new Vertice<>(5);
        Vertice<Integer> v13 = new Vertice<>(13);

        g1.agregarVertice(v1);
        g1.agregarVertice(v2);
        g1.agregarVertice(v3);
        g1.agregarVertice(v4);
        g1.agregarVertice(v5);

        g1.agregarArco(v1, v3, 3);
        
        g1.agregarArco(v1, v5, 23);
        g1.agregarArco(v1, v4, 23);
        g1.agregarArco(v1, v2, 21);
        
        g1.agregarArco(v4, v5, 4);
        g1.agregarArco(v2, v4, 21);
        g1.agregarArco(v3, v2, 12);
        g1.agregarArco(v5, v2, 2);

        //System.out.println(g1.toString());

        g1.DFS();

        
        System.out.println(g1.toString());
        
        
        /* Arco<Integer> res = g1.obtenerArco(v1,v3);
        printArch(res);
        System.out.println("Cantidad de vertices: " + g1.cantidadVertices());
        System.out.println("Cantidad de arcos: " + g1.cantidadArcos());
        System.out.println("Borrar arco (1, 3): ");
        g1.borrarArco(v1,v3);
        res = g1.obtenerArco(v1,v3);
        System.out.print("Obtener arco (1,3): "); printArch(res);
       
        //g1.borrarVertice(2);
        System.out.println("Cantidad de vertices: " + g1.cantidadVertices());
        System.out.println(g1.toString());
        System.out.println(g1.contieneVertice(v13));
        System.out.println(g1.existeArco(v4, v5));
        System.out.println(g1.existeArco(v5, v4));
        System.out.println("Cantidad de arcos: " + g1.cantidadArcos());

        Iterator<Vertice<Integer>> itAdy = g1.obtenerAdyacentes(v5);
        System.out.print("Adyacentes de 5: ");
        while (itAdy.hasNext()){
            Vertice<Integer> data = itAdy.next();
            System.out.print(data + ", ");
        }
        System.out.println();

        Iterator<Vertice<Integer>> itVertices = g1.obtenerVertices();
        System.out.print("Vertices: ");
        while (itVertices.hasNext()){
            Vertice<Integer> data = itVertices.next();
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

        itArcos = g1.obtenerArcos(v4);
        System.out.print("Arcos del vertice 4: ");
        while (itArcos.hasNext()){
            Arco<Integer> data = itArcos.next();
            System.out.print(data + ", ");
        }
        System.out.println();
  */
    }
}
