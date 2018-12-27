package ir.sharif.ce.fastdatastructure.red_black_tree;

import ir.sharif.ce.fastdatastructure.shared.BasicNode;

public class Node extends BasicNode {
	private boolean isRed;

	public Node(int value) {
		super(value);
		this.isRed = true;
	}

	public Node insertToSubTree(int newValue) {
		Node newNode = new Node(newValue);
		newNode = (Node) super.insertToSubTree(newNode);
		return newNode;
	}
	
	public boolean isRed() {
		return isRed;
	}

	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}

	public void changeColor() {
		this.isRed = !this.isRed;
	}
	
	public Node getParent() {
		return (Node) super.getParent();
	}
	
	public Node getLeft(){
		return (Node) super.getLeft();
	}
	
	public Node getRight(){
		return (Node) super.getRight();
	}
	
	public Node getSibling(){
		return (Node) super.getSibling();
	}
}
