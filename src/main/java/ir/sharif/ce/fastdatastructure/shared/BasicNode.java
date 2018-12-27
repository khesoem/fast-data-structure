package ir.sharif.ce.fastdatastructure.shared;

public class BasicNode {
	private int value;
	private BasicNode parent, left, right;
	
	public BasicNode(int value){
		this.value = value;
	}
	
	public void print(){
		if(left != null)
			left.print();
		System.out.print(value + " ");
		if(right != null)
			right.print();
	}
	
	public BasicNode findRoot(){
		if(parent == null)
			return this;
		return parent.findRoot();
	}
	
	public boolean contains(int value){
		if(this.value == value)
			return true;
		if(this.value > value && left != null && left.contains(value))
			return true;
		if(this.value < value && right != null && right.contains(value))
			return true;
		return false;
	}
	
	protected BasicNode insertToSubTree(BasicNode newNode) {
		if (value == newNode.getValue())
			return null;
		else if (value < newNode.getValue()) {
			return insertToRightSubTree(newNode);
		} else {
			return insertToLeftSubTree(newNode);
		}
	}

	protected BasicNode insertToRightSubTree(BasicNode newNode) {
		if (right == null) {
			right = newNode;
			right.setParent(this);
			return right;
		}
		return right.insertToSubTree(newNode);
	}

	protected BasicNode insertToLeftSubTree(BasicNode newNode) {
		if (left == null) {
			left = newNode;
			left.parent = this;
			return left;
		}
		return left.insertToSubTree(newNode);
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BasicNode getParent() {
		return parent;
	}
	
	public BasicNode getGrandParent(){
		if(parent == null)
			return null;
		return parent.getParent();
	}
	
	public BasicNode getSibling(){
		if(parent == null)
			return null;
		if (parent.getValue() > getValue())
			return parent.getRight();
		return parent.getLeft();
	}

	public void setParent(BasicNode parent) {
		this.parent = parent;
	}

	public BasicNode getLeft() {
		return left;
	}

	public void setLeft(BasicNode left) {
		this.left = left;
	}

	public BasicNode getRight() {
		return right;
	}

	public void setRight(BasicNode right) {
		this.right = right;
	}
}
