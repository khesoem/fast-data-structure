package ir.sharif.ce.fastdatastructure.avl_tree;


import ir.sharif.ce.fastdatastructure.shared.BasicTree;

public class AvlTree extends BasicTree {
	private Node root;

	public boolean contains(int value) {
		if (root == null)
			return false;
		return root.contains(value);
	}

	public void print() {
		root.print();
	}

	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
			return;
		}
		Node newNode = root.insertToSubTree(value);
		if (newNode != null)
			balance(newNode);
		if (root.getParent() != null) { // root has changed
			root = (Node) root.findRoot();
		}
	}

	private void balance(Node curNode) {
		if (curNode == null)
			return;
		int leftHeight = curNode.getLeftHeight(), rightHeight = curNode.getRightHeight();
		updateHeight(curNode);
		if (leftHeight > rightHeight + 1) {
			Node curLeft = curNode.getLeft();
			int childLeftHeight = curLeft.getLeftHeight(), childRightHeight = curLeft.getRightHeight();
			if (childLeftHeight > childRightHeight) {
				rotateRight(curNode);
			} else {
				rotateLeft(curLeft);
				updateHeight(curLeft);
				updateHeight(curNode.getLeft()); // left child after rotation is
													// the right child of
													// curLeft
				rotateRight(curNode);
			}
		}
		if (leftHeight + 1 < rightHeight) {
			Node curRight = curNode.getRight();
			int childLeftHeight = curRight.getLeftHeight(), childRightHeight = curRight.getRightHeight();
			if (childRightHeight > childLeftHeight) {
				rotateLeft(curNode);
			}else{
				rotateRight(curRight);
				updateHeight(curRight);
				updateHeight(curNode.getRight()); // right child after rotation is the left child of curRight
				rotateLeft(curNode);
			}
		}
		updateHeight(curNode);
		balance(curNode.getParent());
	}

	private void updateHeight(Node node) {
		node.setHeight(Math.max(node.getLeftHeight(), node.getRightHeight()) + 1);
	}
}
