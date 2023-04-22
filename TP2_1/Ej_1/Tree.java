package TP2_1.Ej_1;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private Integer value, res;
	private Tree left;
	private Tree right;

	public Tree (){
		super();
		this.value = null;
	}
	
	public Tree(int value) {
		this.value = value;
		this. res = 0;
		this.left = null;
		this.right = null;
	}	
	
	public Integer getValue() {  // Complejidad: O(1)
		return value;
	}

	public Integer getRoot() {  // Complejidad: O(1)
		return this.getValue();
	}

	public boolean isEmpty() {	// Complejidad: O(1)
		return this.getRoot().equals(null);
	}
	
	public void insert(Integer newValue) {	// Complejidad: O(h) h = altura, o O(log2 n) (si el arbol esta balanceado) 
		if (newValue < this.value) {		// donde n es la cantidad de nodos que componen el arbol.
			if (this.left == null)
				this.left = new Tree(newValue);
			else
				this.left.insert(newValue);
		} else if (newValue > this.value) {
			if (this.right == null)
				this.right = new Tree(newValue);
			else
				this.right.insert(newValue);
		}
	}

	public void printData(Integer s){ // Complejidad: O(1)
		System.out.print (s + " ");
	}

	public void printPreOrder(){
		printPreOrder(this);
	}

	private void printPreOrder(Tree t) {	// Complejidad: O(n)
		if (t == null)
			return;
		printData(t.getValue()); 
		printPreOrder(t.left); 
		printPreOrder(t.right); 	
	}

	public void printPosOrder(){	
		printPosOrder(this);
	}

	private void printPosOrder(Tree t) {	// Complejidad: O(n)
		if (t == null)
			return;
		printPosOrder(t.left); 
		printPosOrder(t.right); 
		printData(t.getValue()); 	
	}

	public void printInOrder(){
		printInOrder(this);
	}

	private void printInOrder(Tree t) {	// Complejidad: O(n), donde n es la cantidad de nodos del arbol 
		if (t == null)
			return;
		printInOrder(t.left); 
		printData(t.getValue()); 
		printInOrder(t.right); 	
	}

	public Integer leafPlus() {
		return plus(this);
	}

	private Integer plus(Tree t){	// Complejidad: O(n)
		if (t == null)
			return 0;
        if (t.left == null && t.right == null)
            return 0;
        res = res + t.getValue();
        plus(t.left);
        plus(t.right);
		return res;
    }

	public List<Integer> getFrontier(){
		ArrayList<Integer> frontier = new ArrayList<>();
		getFrontierRecursive(this, frontier);
		return frontier;
	}

	private void getFrontierRecursive(Tree t, ArrayList<Integer> frontier){	// Complejidad: O(n)
		if (t == null)
			return;
		if (t.left == null && t.right == null)
			frontier.add(t.getValue());
		getFrontierRecursive(t.left, frontier);
		getFrontierRecursive(t.right, frontier);
	}

	public List<Integer> getElemAtLevel(Integer level){
		List<Integer> elems = new ArrayList<>();
		Integer levelAt = 0;
		getElemAtLevelRecursive(this, elems, levelAt, level);
		return elems;
	}

	public void getElemAtLevelRecursive(Tree t, List<Integer> elems, Integer levelAt, Integer level){	// Complejidad: O(n)
		if (t == null)
			return;
		if (levelAt.equals(level)){
			elems.add(t.getValue());
			return;
		}
		getElemAtLevelRecursive(t.left, elems, levelAt + 1, level);
		getElemAtLevelRecursive(t.right, elems, levelAt + 1, level);
	}

	public Integer getHeight(){		
		return getHeightRecursive(this);
	}

	private Integer getHeightRecursive(Tree t){	// Complejidad: O(n) ¿O(log n)?
		if (t == null)
			return 0;
		
		int leftHeight = getHeightRecursive(t.left); 
		int rightHeight = getHeightRecursive(t.right); 
		int greatestHeight = Math.max(leftHeight, rightHeight); 
		return 1 + greatestHeight; 
	}

	public Boolean delete(Integer elem){
		Boolean deleted = false;
		return delete(this, elem, deleted);
	}

	private boolean delete(Tree t, Integer elem, Boolean deleted){ // Complejidad: O(h) donde h es la altura del arbol.
		if (t == null )
			return false;

		if (t.getValue() > elem)
			deleted = delete(t.left, elem, deleted);
		else if (t.getValue() < elem)
			deleted = delete(t.right, elem, deleted);
		else {				
				if (t.left == null && t.right == null){
					Tree aux = findPredecessor(t, this);
					if (aux.left != null && aux.left == t)
						aux.left = null;
					else
						aux.right = null;
					return true;
				} else 
					if ((t.left == null || t.right == null)){
						Tree aux = findPredecessor(t, this);					
						if (aux.left == t)
							aux.left = findSuccesor(t);
						else	
							aux.right = findSuccesor(t);
						return true;					
					} else {
						Tree aux = t.left.treeMostRightRecursive(t);
						t.value = aux.getValue();
						deleted = delete(aux, aux.getValue(), deleted);
					}				
		}	
		return deleted;
	}

	private Tree findSuccesor(Tree t){ // Complejidad: O(1)
		if (t.left == null)
			return t.right;
		else 
			return t.left;
	}

	private Tree findPredecessor(Tree t, Tree aux){	// Complejidad: O(h) donde h es la altura del arbol.
		if (aux == null)
			return null;
		else {
			if (aux.left == t || aux.right == t )
				return aux;		
			if (aux.getValue() > t.getValue())
				return findPredecessor(t, aux.left);
			else
				return findPredecessor(t, aux.right);	
		}	
	}

	public Integer treeMostRight(){	// O(h), donde h es la altura del arbol.
		Tree aux = treeMostRightRecursive(this);
		return aux.getValue();
	}

	private Tree treeMostRightRecursive(Tree t){
		if (t.right == null)
			return t;
		return treeMostRightRecursive(t.right);
	}

	public Integer treeMostLeft(){ // O(h), donde h es la atura del arbol.
		Tree aux = treeMostLeftRecursive(this);
		return aux.getValue();
	}

	private Tree treeMostLeftRecursive(Tree t){
		if (t.left == null)
			return t;
		return treeMostLeftRecursive(t.left);
	}

	public List<Integer> getSuperiorList(Integer elem){
		List<Integer> list = new ArrayList<>();
		getSuperiorListRec(this, elem, list);
		return list;
	}

	private void getSuperiorListRec(Tree t, Integer elem, List<Integer> list){ // O(n)
		if (t == null)
			return;

		if (t.getValue() > elem)
			list.add(t.getValue());
		
		getSuperiorListRec(t.right, elem, list);			
		getSuperiorListRec(t.left, elem, list);
	}

	/* public List<Integer> getLongestBranch(){
		return getLongestBranch(this);
	} */

	/* private List<Integer> getLongestBranch(Tree t){		
		
		if(t == null){
			List<Integer> output = new ArrayList<>();
			return output;
		}
				
		List<Integer> rightBranch = getLongestBranch(t.right);
				
		List<Integer> leftBranch = getLongestBranch(t.left);
		
		if(rightBranch.size() < leftBranch.size()){
			leftBranch.add(t.getValue());
		} else {
			rightBranch.add(t.getValue());
		}
				
		return (leftBranch.size() >
				rightBranch.size() ? leftBranch : rightBranch);
	} */

	public List<Integer> getLongestBranch() {
        List<Integer> branch = new ArrayList<>();
        getLongestBranchRecursive(this, branch);
        return branch;
    }
 
    private void getLongestBranchRecursive(Tree current, List<Integer> branch) {
        if (current == null) {
            return;
        }
 
        branch.add(current.value);
 
        if (current.left == null && current.right == null) {
            return;
        }
 
        if (current.left == null) {
            getLongestBranchRecursive(current.right, branch);
        } else if (current.right == null) {
            getLongestBranchRecursive(current.left, branch);
        } else {
            List<Integer> leftBranch = new ArrayList<>();
            List<Integer> rightBranch = new ArrayList<>();
            getLongestBranchRecursive(current.right, rightBranch);
            getLongestBranchRecursive(current.left, leftBranch);
            if (leftBranch.size() > rightBranch.size()) {
                branch.addAll(leftBranch);
            } else {
                branch.addAll(rightBranch);
            }
        }
    }

}