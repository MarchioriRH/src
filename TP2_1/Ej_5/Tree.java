package TP2_1.Ej_5;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private String value;
	private Tree left;
	private Tree right;

	public Tree (){
		super();
		this.value = null;
	}
	
	public Tree(String value) {
		this.value = value;
		//this. res = 0;
		this.left = null;
		this.right = null;
	}	

	public void setValue(String s){
		this.value = s;
	}

	public void setRight(Tree t){
		this.right = t;
	}

	public void setLeft(Tree t){
		this.left = t;
	}
	
	public String getValue() {
		return value;
	}

	public String getRoot() {
		return this.getValue();
	}

	public boolean isEmpty() {
		return this.getRoot().equals(null);
	}

	public void printData(String s){
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
	
	private int countVocals(String s){
		int cant = 0;
		String comp = "AEIOUaeiou";
		//System.out.println(s.length());
		for (int i = 0; i < s.length(); i++){
			if (comp.contains(String.valueOf(s.charAt(i))))
				cant++;
		}
		return cant;
	}

	public List<String> wordsWithNVocals(int limit){
		List<String> res = new ArrayList<>();
		String word = "";
		int vocals = 0;
		wordsRec(this, limit, word, vocals, res);
		return res;
	}

	public void wordsRec(Tree t, int lim, String word, int vocals, List<String> res){		
		if (t == null)
			return;
		
		if (t != null)
			word = word + t.getValue();
			
		if((t.left == null && t.right == null)){
			if (vocals + countVocals(word) == lim) 
				res.add(word);
		}
		else {	
			wordsRec(t.left, lim, word, vocals, res);
			wordsRec(t.right, lim, word, vocals, res);
		}
	} 

	

	

}