package TP2_1.Ej_4;


public class Main {
    public static <T> void main(String[] args){
        Tree root = new Tree(null);
        Tree nodeA1 = new Tree(null);
        Tree nodeA2 = new Tree(null);
        root.setLeft(nodeA1);
        root.setRight(nodeA2);
        Tree nodeB1 = new Tree(null);
        Tree nodeB2 = new Tree(null);
        Tree nodeB3 = new Tree(null);
        nodeA1.setRight(nodeB1);
        nodeA1.setLeft(nodeB2);
        nodeA2.setRight(nodeB3);
        Tree nodeC1 = new Tree(null);
        Tree nodeC2 = new Tree(null);
        Tree nodeC3 = new Tree(null);
        Tree nodeC4 = new Tree(null);
        nodeB1.setLeft(nodeC1);
        nodeB2.setRight(nodeC3);
        nodeB2.setLeft(nodeC2);
        nodeB3.setLeft(nodeC4);
        Tree nodeD1 = new Tree(8);
        Tree nodeD2 = new Tree(-6);
        Tree nodeD3 = new Tree(15);
        Tree nodeD4 = new Tree(95);
        Tree nodeD5 = new Tree(-8);
        nodeC1.setLeft(nodeD1);
        nodeC1.setRight(nodeD2);
        nodeC2.setLeft(nodeD3);
        nodeC2.setRight(nodeD4);
        nodeC4.setRight(nodeD5);
       
       /*  System.out.print("Print in order : [ ");
        root.printInOrder();
        System.out.println("]"); */

        System.out.println(root.toString());
       
        root.fillTree(root);
        
        System.out.println(root.toString());
       
        
    } 
    
}
