package TP2_1.Ej_1;


import java.util.Scanner;

public class Main {
    public static <T> void main(String[] args){
        Tree tree = new Tree(28);
        tree.insert(12);
        tree.insert(5);
        tree.insert(77);
        tree.insert(14);
       
        tree.insert(6);
        tree.insert(19);
        tree.insert(15);
        tree.insert(4);
        tree.insert(76);
        tree.insert(105);
        tree.insert(-6);
        tree.insert(-5);
        tree.insert(7);
        tree.insert(100);
       
        /* 
        Tree<String> tree = new Tree<>();
        tree.insert("casa");
        tree.insert("papa");
        tree.insert("cafe");
        tree.insert("silo");
        tree.insert("pito");
        tree.insert("mormon");
        tree.insert("turra");
        tree.insert("xavier");
        tree.insert("juan");
        tree.insert("dios");
        tree.insert("hora");
        tree.insert("barro");
        tree.insert("nariz"); */

        System.out.println("-----------Pos Order----------------");
        System.out.print("[ ");
        tree.printPosOrder();
        System.out.println(" ]");

        System.out.println("-----------Pre Order----------------");
        System.out.print("[ ");
        tree.printPreOrder();
        System.out.println(" ]");

        System.out.println("-----------In Order----------------");
        System.out.print("[ ");
        tree.printInOrder();
        System.out.println(" ]");

        System.out.println("---------------Tree Info----------------");        
        System.out.println("Suma de todas las hojas (tree de trees): " + tree.leafPlus());
        System.out.println("Tree mas derecho: " + tree.treeMostRight());
        System.out.println("Tree mas izquierdo: " + tree.treeMostLeft());        
        System.out.println("Longest Branch: " + tree.getLongestBranch());
        System.out.println("Frontera: " + tree.getFrontier());
        System.out.println("Tree height: " + tree.getHeight());
        System.out.println();
        System.out.println("Elementos en el nivel 0: " + tree.getElemAtLevel(0));
        System.out.println("Elementos en el nivel 1: " + tree.getElemAtLevel(1));
        System.out.println("Elementos en el nivel 2: " + tree.getElemAtLevel(2));
        System.out.println("Elementos en el nivel 3: " + tree.getElemAtLevel(3));
        System.out.println("Elementos en el nivel 4: " + tree.getElemAtLevel(4));
        System.out.println("Elementos en el nivel 5: " + tree.getElemAtLevel(5));
        System.out.println("Elementos en el nivel 6: " + tree.getElemAtLevel(6));
        System.out.println("Elementos en el nivel 7: " + tree.getElemAtLevel(7));
        System.out.println();
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Ingrese el valor minimo: ");
            Integer data = scanner.nextInt();
            System.out.println("Los valores mayores al ingresado en el ABB son: " + tree.getSuperiorList(data));
            System.out.println();
            System.out.print("Ingrese el elemento que quiere eleminiar del ABB: ");
            data = scanner.nextInt();
            if (tree.delete(data))
                System.out.println("Elemento eliminado.");
            else
                System.out.println("No se pudo eliminar el elemento.");
        
            System.out.println();
            System.out.println("Elementos en el nivel 0: " + tree.getElemAtLevel(0));
            System.out.println("Elementos en el nivel 1: " + tree.getElemAtLevel(1));
            System.out.println("Elementos en el nivel 2: " + tree.getElemAtLevel(2));
            System.out.println("Elementos en el nivel 3: " + tree.getElemAtLevel(3));
            System.out.println("Elementos en el nivel 4: " + tree.getElemAtLevel(4));
            System.out.println("Elementos en el nivel 5: " + tree.getElemAtLevel(5));
            System.out.println("Elementos en el nivel 6: " + tree.getElemAtLevel(6));
            System.out.println("Elementos en el nivel 7: " + tree.getElemAtLevel(7));
            System.out.println();
            
        }

        

        /* TreeWithNodes<Integer> nodesTree = new TreeWithNodes<>();
        nodesTree.insert(12);
        nodesTree.insert(5);
        nodesTree.insert(77);
        nodesTree.insert(14);       
        nodesTree.insert(6);
        nodesTree.insert(19);
        nodesTree.insert(15);

        System.out.println("Suma de las hojas (tree de nodos): " + nodesTree.leafPlus());
        
         
        //System.out.println(tree.hasElem(-100));
        /* System.out.println("-----------Post Order----------------");
        tree.printInPostOrder();
        System.out.println("");
        System.out.println("-----------Pre Order----------------");
        tree.printInPreOrder();
        System.out.println(""); */
       // Timer t1 = new Timer();
        //t1.start();
       // System.out.println("Maximo elemento recursivo: " + tree.getMaxElem());
       // System.out.println("Time: "+t1.stop());
       // t1.start();
        //System.out.println("Maximo elemento no recursivo: " + tree.getMaxElemNONR());
       // System.out.println("Time: "+t1.stop());
        /* System.out.println("Minimo elemento: " + tree.getMinElem());
        System.out.println("Altura del arbol: " + tree.getHeight());

        System.out.println("Level 0: " + tree.getNodesOnLevel(0));
        System.out.println("Level 1: " + tree.getNodesOnLevel(1));
        System.out.println("Level 2: " + tree.getNodesOnLevel(2));
        System.out.println("Level 3: " + tree.getNodesOnLevel(3));
        System.out.println("Level 4: " + tree.getNodesOnLevel(4));
        System.out.println("Level 5: " + tree.getNodesOnLevel(5));
        System.out.println("--------------------------");
        Integer key = 14;
        System.out.println("Se pudo eliminar " + key + ": " + tree.delete(key));

        System.out.println("--------------------------");
        System.out.println("Level 0: " + tree.getNodesOnLevel(0));
        System.out.println("Level 1: " + tree.getNodesOnLevel(1));
        System.out.println("Level 2: " + tree.getNodesOnLevel(2));
        System.out.println("Level 3: " + tree.getNodesOnLevel(3));
        System.out.println("Level 4: " + tree.getNodesOnLevel(4));
        System.out.println("Level 5: " + tree.getNodesOnLevel(5));
        System.out.println("-----------In Order----------------");
        tree.printInorder();
        System.out.println("");
        System.out.println("-----------Frontier---------------");
        System.out.println(tree.getFrontier());
        System.out.println("-------Longest Branch-----------");
        System.out.println(tree.getLongestBranch());



 */
    } 
}
