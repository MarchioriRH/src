package TP2_1.Ej_5;



public class Main {
    public static <T> void main(String[] args){
        Tree root = new Tree("M");
        Tree nodeA = new Tree("A");
        root.setLeft(nodeA);
        Tree nodeSSS = new Tree("S");
        nodeA.setRight(nodeSSS);
        Tree nodeN = new Tree("N");
        nodeA.setLeft(nodeN);
        Tree nodeO = new Tree("O");
        nodeN.setLeft(nodeO);
        Tree nodeSS = new Tree("S");
        nodeO.setRight(nodeSS);
        Tree nodeAAA = new Tree("A");
        nodeN.setRight(nodeAAA);
        Tree nodeI = new Tree("I");
        root.setRight(nodeI);
        Tree nodeS = new Tree("S");
        nodeI.setLeft(nodeS);
        Tree nodeAA = new Tree("A");
        nodeI.setRight(nodeAA);
        Tree nodeAAAA = new Tree("A");
        nodeS.setLeft(nodeAAAA);

        Tree nodeE = new Tree("E");
        nodeS.setRight(nodeE);
        Tree nodeR = new Tree("R");
        nodeE.setRight(nodeR);
        Tree nodeII = new Tree("I");
        nodeR.setRight(nodeII);
        Tree nodeAAAAA = new Tree("A");
        nodeII.setLeft(nodeAAAAA);

        
        System.out.print(root.toString());
        
        System.out.println(root.wordsWithNVocals(2));
    } 
}
