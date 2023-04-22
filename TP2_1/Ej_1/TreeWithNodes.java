package TP2_1.Ej_1;

import java.util.ArrayList;
import java.util.List;

public class TreeWithNodes <T extends Comparable<? super T>> {

	private TreeNode<T> root;
	private boolean keyDeleted;
	private Integer res;

	// Empty Tree constructor
	public TreeWithNodes() {
		this.root = null;
		this.keyDeleted = false;
		this.res = 0;
	}

	// Inserte function
	public void insert(T value){
		// If root is null, this point to a new node with the new value
		if (this.root == null)
			this.root = new TreeNode<>(value);
		else
			// Else, private function insert is called.
			if (this.root.getValue() != value)
				insert(value, this.root);
	}
	
	// Private function insert new node in the tree
	private void insert(T value, TreeNode<T> node){
		// If value is less than node value, new node is inserted in the left subtree
		if (value.compareTo(node.getValue()) < 0) {
			if (node.getLeft() == null)
				node.setLeft(new TreeNode<T> (value));
			else
				insert(value, node.getLeft());
		} else if (value.compareTo(node.getValue()) > 0) { // Else, node is inserted y the right subtree
			if (node.getRight() == null)
				node.setRight(new TreeNode<T> (value));
			else
				insert(value, node.getRight());
		}
	}

	// Boolean function, control if root is not null
	public boolean isEmpty(){
		return (root == null);
	}

	public boolean hasElem(T elem){
		if (root == null)
			return false;
		else
			return hasElem(elem, this.root);
	}

	// Boolean function, control if root value is not null
	private boolean hasElem(T elem, TreeNode<T> root){
		if (root != null){
			if (root.getValue().equals(elem))
				return true;
			else
				if (root.getValue().compareTo(elem) > 0 && root != null)
					return hasElem(elem, root.getLeft());
				else
					return hasElem(elem, root.getRight());
			}
		return false;
	}

	// Return a root copy
	public T getRootValue(){
		return root.getValue();
	}

	public TreeNode<T> getRoot(){
		TreeNode<T> aux = root;
		return aux;
	}

	// Find max element y the tree
	public T getMaxElem(){
		return getMaxElem(root);
	}

	private T getMaxElem(TreeNode<T> node){ 		
		if (node == null) 
			return null; 
		else { // While right node is not null
			if (node.getRight() == null)
				return node.getValue();
			else
				return getMaxElem(node.getRight());
		}
	} 

	public T getMaxElemNONR(){
		return getMaxElemNONR(this.root);
	}

    public T getMaxElemNONR(TreeNode<T> node){
        T maxE = node.getValue();
        while (node.getRight() != null){
            maxE = node.getRight().getValue();
            node = node.getRight();
        }
        return maxE;
    }
 
	public Integer leafPlus(){
        //Integer res = 0;
        if (this.isEmpty())
            return 0;
        else 
            return plus(this.getRoot());
    }

	private Integer plus(TreeNode<T> t){
        if (t == null)
            return 0;
		if (t.getLeft() == null && t.getRight() == null)
			return 0;
        res = res + (Integer) t.getValue();
        plus(t.getLeft());
        plus(t.getRight());
        return res;
    }

	public List<T> getFrontier(){
		List<T> list = new ArrayList<>();
		getFrontier(this.root, list);
		return list;
	} 

	private List<T> getFrontier(TreeNode<T> node, List<T> list){		
		if(node == null)
			return list;
		else {
			if (node.getLeft() == null && node.getRight() == null)
				list.add(node.getValue());
			else {
				getFrontier(node.getLeft(), list);
				getFrontier(node.getRight(), list);
			}
		}
		return list;
	}

	public List<T> getLongestBranch(){
		return getLongestBranch(this.root);
	}

	private List<T> getLongestBranch(TreeNode<T> node){		
		// If root is null means there
		// is no binary tree so
		// return a empty vector
		if(node == null){
			List<T> output = new ArrayList<>();
			return output;
		}
		
		// Recursive call on root.right
		List<T> right = getLongestBranch(node.getRight());
		
		// Recursive call on node.left
		List<T> left = getLongestBranch(node.getLeft());
		
		// Compare the size of the two ArrayList
		// and insert current node accordingly
		if(right.size() < left.size()){
			left.add(node.getValue());
		} else {
			right.add(node.getValue());
		}
		
		// Return the appropriate ArrayList
		return (left.size() >
				right.size() ? left : right);
	}

	public boolean delete(T key){ 
		this.root = deleteRec(this.root, key);
		return keyDeleted;		
	}
 
    /* A recursive function to
      delete an existing key in BST
     */
    private TreeNode<T> deleteRec(TreeNode<T> node, T key){
        /* Base Case: If the tree is empty */
        if (node == null)
            return node;
 
        /* Otherwise, recur down the tree */
        if (key.compareTo(node.getValue()) < 0)
            node.setLeft(deleteRec(node.getLeft(), key));
        else if (key.compareTo(node.getValue()) > 0)
            node.setRight(deleteRec(node.getRight(), key));
 
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
			keyDeleted = true;
            // node with only one child or no child
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            node.setValue(getMinElem(node.getRight()));
 
            // Delete the inorder successor
            node.setRight(deleteRec(node.getRight(), node.getValue()));			
        } 
        return node;
    }
 
	public T getMinElem(){
		return getMinElem(this.root);
	}

    public T getMinElem(TreeNode<T> node){
        T minE = node.getValue();
        while (node.getLeft() != null){
            minE = node.getLeft().getValue();
            node = node.getLeft();
        }
        return minE;
    }
 

	public List<T> getNodesOnLevel(int level){
		List<T> list = new ArrayList<>();
		this.getNodesOnLevel(this.root, level, list);
		return list;
	}

	private void getNodesOnLevel(TreeNode<T> node, int level, List<T> list){
		if (node == null) 
			return;
		if (level == 0) {
			list.add(node.getValue());
		} else {
			getNodesOnLevel(node.getLeft(), level - 1, list);
			getNodesOnLevel(node.getRight(), level - 1, list);
		}
	}

	public int getHeight(){
		return getHeight(this.root);		
	}

	private int getHeight(TreeNode<T> node){
		if(node == null){
			return 0;
		} else {
			int leftHeight = getHeight(node.getLeft()); 
			int rightHeight = getHeight(node.getRight()); 
			int greatestHeight = Math.max(leftHeight, rightHeight); 
			return 1 + greatestHeight; 
		}
	}		

	public void printInorder(){
		printInOrderProcces(this.root);
	}

	public void printInPostOrder(){
		printPostorderProcces(this.root);
	}

	public void printInPreOrder(){
		printPreorderProcces(this.root);
	}

	private void printPreorderProcces(TreeNode<T> node){ 		
		if (node == null)
			return;
		System.out.printf("%s ", node.getValue()); 
		printPreorderProcces(node.getLeft()); 
		printPreorderProcces(node.getRight()); 
	}

	private void printPostorderProcces(TreeNode<T> node){ 
		if (node == null)
			return;
		printPostorderProcces(node.getLeft()); 
		printPostorderProcces(node.getRight()); 
		System.out.printf("%s ", node.getValue()); 
	}

	private void printInOrderProcces(TreeNode<T> node){ 
		if (node == null)
			return;
		printInOrderProcces(node.getLeft()); 
		System.out.printf("%s ", node.getValue()); 
		printInOrderProcces(node.getRight()); 
	}
}