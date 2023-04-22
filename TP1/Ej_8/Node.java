package TP1.Ej_8;

public class Node {
    private Object info;
    private Node next;
    private Node prev; 
    public Node() { 
        info = null; 
        next = null;
        prev = null;
    } 
    public Node(Object o, Node n, Node p) { 
        setInfo(o);
        setNext(n); 
        setPrev(p);
    } 

    public Node(Object o) { 
        setInfo(o);
        setNext(null); 
        setPrev(null);
    } 

    public void setInfo(Object o) {
        info = o; 
    } 
    public void setNext(Node n) { 
        next = n; 
    } 
    public void setPrev(Node p) { 
        prev = p; 
    } 
    public Object getInfo() {
        return info;
    } 
    public Node getNext() {
        return next; 
    }
    public Node getPrev() {
        return prev; 
    }
}