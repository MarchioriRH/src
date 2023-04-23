package TP2_1.Ej_4;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;

	public Tree (){
		super();
		this.value = null;
	}
	
	public Tree(Integer value) {
		this.value = value;
		//this. res = 0;
		this.left = null;
		this.right = null;
	}	

	public void setValue(Integer s){
		this.value = s;
	}

	public void setRight(Tree t){
		this.right = t;
	}

	public void setLeft(Tree t){
		this.left = t;
	}
	
	public Integer getValue() {
			return value;
	}

	public Integer getRoot() {
		return this.getValue();
	}

	public boolean isEmpty() {
		return this.getRoot().equals(null);
	}

	public void printData(Integer s){
		System.out.print (s + " ");
	}

	public void printInOrder(){
		printInOrder(this);
	}

	private void printInOrder(Tree t){
		if (t == null)
			return;
		printInOrder(t.left);
		printData(t.getValue());
		printInOrder(t.right); 			
	}
	
	// Metodo que permite completar las hojas internas de un ABB con la resta de sus hijos.
	public Integer fillTree(Tree t){	
		// Si el arbol es null retorna 0	
		if (t == null)
			return 0;

		// Recursivamente obtenemos los valores de los subarboles izq y der
		Integer leftVal = fillTree(t.left);
		Integer rightVal = fillTree(t.right);

		// Si tanto el hijo izq como el der son null
		if (t.left == null && t.right == null){
			// Si el valor de t == null, lo setea en 0
			if (t.getValue() == null)
				t.setValue(0);
			return t.getValue();
		}
			
		// Si el valor obtenido por izq == null y el der != null setea el valor no nulo
		if (leftVal == null && rightVal != null)
			t.setValue(t.right.getValue());

		// Inversa del anterio		
		if (rightVal == null && leftVal != null)
			t.setValue(-t.left.getValue());			
		
		// Si ninguno de los valores es nulo, realiza la operacion de resta y setea el valor
		// del nodo con el resultado obtenido
		if (leftVal != null && rightVal != null)
			t.setValue(rightVal - leftVal);
		
		// Devuelve el valor.
		return t.getValue();
	}


	private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
		Integer value = 0;
		if(this.right!=null) {
			this.right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
		}
		if (this.getValue() != null){
			value = this.getValue();
			sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value.toString()).append("\n");
		}
		else 
			sb.append(prefix).append(isTail ? "└── " : "┌── ").append("null").append("\n");
		if(this.left!=null) {
			this.left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
		}
		return sb;
	}
	
	@Override
	public String toString() {
		return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
	}

}