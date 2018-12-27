package ir.sharif.ce.fastdatastructure.avl_tree;

import ir.sharif.ce.fastdatastructure.shared.BasicNode;

public class Node extends BasicNode {
	private int height;

	public Node(int value) {
		super(value);
		this.setHeight(1);
	}

	public Node insertToSubTree(int value) {
		Node newNode = new Node(value);
		newNode = (Node) super.insertToSubTree(newNode);
		return newNode;
	}

	public int getLeftHeight(){
		return getLeft() == null ? 0 : getLeft().getHeight();
	}
	
	public int getRightHeight(){
		return getRight() == null ? 0 : getRight().getHeight();
	}
	
	public Node getLeft() {
		return (Node) super.getLeft();
	}

	public Node getParent() {
		return (Node) super.getParent();
	}

	public Node getRight() {
		return (Node) super.getRight();
	}
	
	public Node getGrandParent(){
		return (Node) super.getGrandParent();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
