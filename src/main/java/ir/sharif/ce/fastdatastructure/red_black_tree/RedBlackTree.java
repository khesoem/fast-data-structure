package ir.sharif.ce.fastdatastructure.red_black_tree;

import ir.sharif.ce.fastdatastructure.shared.BasicTree;

public class RedBlackTree extends BasicTree {
	private Node root;

	public boolean contains(int value){
		if(root == null)
			return false;
		return root.contains(value);
	}
	
	public void print(){
		if(root != null)
			root.print();
	}
	
	public void insert(int newValue) {
		if (root == null) {
			root = new Node(newValue);
			root.setRed(false);
			return;
		}
		Node newNode = root.insertToSubTree(newValue);
		if(newNode != null)
			balance(newNode);
		if(root.getParent() != null){ // root has changed
			root = (Node) root.findRoot();
		}
	}

	private void balance(Node node) {
		if (!node.isRed())
			return;
		Node parent = node.getParent();
		if (parent == null) { // this node is root!
			node.setRed(false);
			return;
		}
		if (parent.isRed()) {
			Node pSibling = parent.getSibling();
			Node grandParent = parent.getParent(); // grandParent is not root
													// because parent's color is
													// red
			if (pSibling != null && pSibling.isRed()) {
				grandParent.setRed(true);
				node.setRed(false);
				pSibling.setRed(false);
			} else {
				grandParent.changeColor();
				parent.changeColor();
				if (parent.getValue() > node.getValue()) {
					if (grandParent.getValue() > parent.getValue()) {
						rotateRight(grandParent);
					} else {
						rotateRight(parent);
						rotateLeft(grandParent);
					}
				} else {
					if (parent.getValue() > grandParent.getValue()) {
						rotateLeft(grandParent);
					} else {
						rotateLeft(parent);
						rotateRight(grandParent);
					}
				}
			}
		}
	}

}
