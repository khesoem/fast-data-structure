package ir.sharif.ce.fastdatastructure.shared;

public abstract class BasicTree {
	protected void rotateLeft(BasicNode node) {
		BasicNode curRight = node.getRight(), curParent = node.getParent();

		node.setRight(curRight.getLeft());
		if (curRight.getLeft() != null)
			curRight.getLeft().setParent(node);
		
		node.setParent(curRight);
		curRight.setLeft(node);

		curRight.setParent(curParent);
		if (curParent == null)
			return;
		if (node.getValue() < curParent.getValue()) {
			curParent.setLeft(curRight);
		} else {
			curParent.setRight(curRight);
		}
	}

	protected void rotateRight(BasicNode node) {
		BasicNode curLeft = node.getLeft(), curParent = node.getParent();

		node.setLeft(curLeft.getRight());
		if (curLeft.getRight() != null)
			curLeft.getRight().setParent(node);
		
		node.setParent(curLeft);
		curLeft.setRight(node);

		curLeft.setParent(curParent);
		if (curParent == null)
			return;
		if (node.getValue() < curParent.getValue()) {
			curParent.setLeft(curLeft);
		} else {
			curParent.setRight(curLeft);
		}
	}
}
