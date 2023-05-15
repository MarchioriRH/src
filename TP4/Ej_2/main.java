package TP4.Ej_2;

public class main {
    public static void main (String[] args){
        //Labyrinth lab = new Labyrinth(4);
        Data[][] lab = new Data[4][4];

        lab[0][0] = new Data(2,false, true, false, true);
        lab[0][1] = new Data(4,false, true, false, true);
        lab[0][2] = new Data(6,false, true, false, true);
        lab[0][3]= new Data(12,false, true, false, false);
        lab[1][0]= new Data(5,false, true, false, true);
        lab[1][1]= new Data(7,false, true, true, true);
        lab[1][2]= new Data(9,false, true, false, true);
        lab[1][3]= new Data(24,true, true, false, false);
        lab[2][0]= new Data(16,false, true, false, false);
        lab[2][1]= new Data(2,true, true, false, true);
        lab[2][2]= new Data(5,true, true, false, true);
        lab[2][3]= new Data(8,true, true, false, false);
        lab[3][0]= new Data(4,false, false, false, true);
        lab[3][1]= new Data(5,true, false, false, true);
        lab[3][2]= new Data(7,true, false, false, true);
        lab[3][3]= new Data(7,false, false, false, false);

        

        Labyrinth labyrinth = new Labyrinth(lab);

        System.out.println(labyrinth.recorrido(1, 1, 2, 2));

    }
}
