/**
 * @program: Data Structures
 * @description:
 * @author: boyscoding
 * @create: 2019-07-01
 **/
public class BinaryTreeNode<T> {

	private T data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}

	public BinaryTreeNode(T data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
}
