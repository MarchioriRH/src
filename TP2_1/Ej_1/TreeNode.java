package TP2_1.Ej_1;
public class TreeNode <T extends Comparable<? super T>> {

	private T value;
	private TreeNode<T> left;
	private TreeNode<T> right;

	public TreeNode() {
		this.value = null;
		this.left = null;
		this.right = null;
	}

	public TreeNode(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T v) {
		this.value = v;
	}


}
