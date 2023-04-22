package TP1.Ej_8;

public class MyDoubleLinkedList {
    protected Node first;
    private int cantNodes;

    public MyDoubleLinkedList() {
        first = new Node();
        cantNodes = 0;
    }

    public void insertFront(Object o) { 
        Node tmp = new Node(o); 
        tmp.setNext(first); 
        first.setPrev(tmp);
        first = tmp;
        cantNodes++;
    }

    public void insertEnd(Object o){
        Node aux = new Node(o);
        Node pointer = new Node();
        
        if (isEmpty())
            first = aux;
        else{
            pointer = first;
            while(pointer.getNext() != null){
                pointer = pointer.getNext();
            }
            pointer.setNext(aux);
            aux.setPrev(pointer);
            cantNodes++;
        }
    }

    public void insertInPosition(Object o, int n){
        if (sysErrOutOfRange(n))
            return;
        else {
            Node aux = new Node(o);
            int i = 1;
            Node pointer = new Node();
            pointer = first;
            if (n == 0){
                this.insertFront(o);
            }
            else{
                while (i < n){
                    pointer = pointer.getNext();                
                    i++;
                }            
                if (pointer.getNext() == null){
                    pointer.setNext(aux);
                    aux.setPrev(pointer);
                } else {
                    aux.setNext(pointer.getNext());
                    pointer.setNext(aux);                    
                    aux.setPrev(pointer);
                }
                cantNodes++;
            }
        }       
        
    }

    public void deleteFromPosition(int n){
        if (sysErrOutOfRange(n))
            return;
        else {           
            Node pointer = new Node();
            pointer = first;
            if (n == 0){
                first = first.getNext();
                first.setPrev(null);
                cantNodes--;
            } else {
                int i = 1;
                while (i < n){
                    pointer = pointer.getNext();                
                    i++;
                }
                if (pointer.getNext().getNext() == null){
                    pointer.getNext().setPrev(null);
                    pointer.setNext(null);                    
                } else {               
                    pointer.getNext().getNext().setPrev(pointer);
                    pointer.setNext(pointer.getNext().getNext());
                }
                cantNodes--;
            }
        }       
    }

    public Object extractFront() { 
        Node aux = new Node();
        aux = first;
        first.setPrev(null);
        first = first.getNext();
        cantNodes--;
        return aux;
    }

    public boolean sysErrOutOfRange(int n){
        if (n > this.size() || n < 0 || isEmpty())
            return true;
        return false;
    }

    public Object print(int n) { 
        if (sysErrOutOfRange(n))
            return("El indice esta fuera de rango.");
        else {
            Node aux = new Node();
            int i = 0;
            aux = first;
            while (i < n){
                aux = aux.getNext();                
                i++;
            }            
            return(aux.getInfo());
        }            
    }

    public Object printAll(){
        String result = "";
        Node aux = new Node();
        aux = first;
        for (int i = 0; i < this.size(); i++){
            result = result + " - " + aux.getInfo(); 
            aux = aux.getNext();
        }
        return result;
    }

    public Object printReversed(){
        String result = "";
        Node pointer = new Node();
        Node backPointer = new Node();
        pointer = first;
        backPointer = first;
        while (pointer != null){
            backPointer = pointer;
            pointer = pointer.getNext();
        }
        while (backPointer!= null){
            
            backPointer = backPointer.getPrev();
            if (backPointer != null)
                result = result + " - " + backPointer.getInfo(); 
        }
        return result;
    }

    public boolean isEmpty() { 
        return first == null;
    }

    public int size () { 
        return cantNodes;
    }
}