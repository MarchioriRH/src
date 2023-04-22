package TP1.Ej_6_7;

public class Compose <T extends Comparable<? super T>> {
   
    public Lista<T> componerDesordenada(Lista<T> l1, Lista<T> l2){
        Lista<T> aux = Lista.createWithComparable();
        for (T elemL1 : l1){ // O(n1)
            for (T elemL2 : l2){ // O(n2)
                if (elemL2.equals(elemL1)) 
                    aux.add(elemL1);   // O(n3)    ///EN CLASE O(N^2)
            }
        }
        return aux;
    } // ¿O(n1 + n2 + n3)?

    public Lista<T> componerOrdenada(Lista<T> l1, Lista<T> l2){
        Lista<T> aux = Lista.createWithComparable();
        for (T elemL1 : l1){
            for (T elemL2 : l2){
                if (elemL2.equals(elemL1))
                 if (elemL2.compareTo(elemL1) > 0)  
                    aux.add(elemL1);   // O(n)
            }
        }
        return aux;
    }

    public Lista<T> componerOrdenadaIterador(Lista<T> L1, Lista<T> L2){
        MyIterator<T> itL1 = new MyIterator<>(L1.first);
        MyIterator<T> itL2 = new MyIterator<>(L2.first);
        Lista<T> aux = Lista.createWithComparable();

        while (itL1.hasNext() && itL2.hasNext()){
            if (itL1.getObj().compareTo(itL2.getObj()) > 0)
                itL2.nextObj();
            else
                if (itL2.getObj().compareTo(itL1.getObj()) > 0)
                    itL1.nextObj();
                else
                    if (itL1.getObj().equals(itL2.getObj())){
                        aux.addLast(itL1.getObj());
                        itL1.nextObj();
                        itL2.nextObj();
                    }
        }
        return aux;
    }
   
    public Lista<T> componerDistintos(Lista<T> l1, Lista<T> l2){
        Lista<T> aux = Lista.createWithComparable();
        Boolean found = false;
        for (T elemL1 : l1){      //O(n1)   ¿O(n^2)?
            for (T elemL2 : l2){  //O(n2)
                if (elemL1.equals(elemL2))
                    found = true;               
            }
            if (!found)    
                aux.add(elemL1); // O(n3)
            found = false;            
        }
        return aux;
    }

    public Lista<T> componerDistintosIterador(Lista<T> L1, Lista<T> L2){
        MyIterator<T> itL1 = new MyIterator<>(L1.first);
        MyIterator<T> itL2 = new MyIterator<>(L2.first);
        Lista<T> aux = Lista.createWithComparable();

        while (itL1.hasNext() && itL2.hasNext()){
            System.out.print("itL1: "+itL1.getObj());
            System.out.println(" - itL2: "+itL2.getObj());

            if (itL1.getObj().compareTo(itL2.getObj()) > 0){
                while (itL2.hasNext() && itL1.getObj().compareTo(itL2.getObj()) > 0 )
                    itL2.nextObj();
                if (itL2.hasNext()){
                    if (itL1.getObj().equals(itL2.getObj())){                        
                        itL1.nextObj();
                        itL2.nextObj();
                    } else {
                        aux.addLast(itL1.getObj());
                        itL1.nextObj();
                    }
                } else {
                    while (itL1.hasNext()){                
                        aux.addLast(itL1.getObj());
                        itL1.nextObj();
                    }
                }
            }
            else
                if (itL2.getObj().compareTo(itL1.getObj()) > 0){
                    aux.addLast(itL1.getObj());
                    itL1.nextObj();
                }
                else
                    if (itL1.getObj().equals(itL2.getObj())){                        
                        itL1.nextObj();
                        itL2.nextObj();
                    }
        }
        return aux;
    }
}
