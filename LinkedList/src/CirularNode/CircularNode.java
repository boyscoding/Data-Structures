package CirularNode;

/**
 * @program: Data Structures
 * @description: 循环链表
 * @author: boyscoding
 * @create: 2019-07-11 10:37
 **/
public class CircularNode {
	private int data; // 数据
	private CircularNode next; // 该节点的下个节点

	public CircularNode(int data) {
		this.data = data;
	}

	public CircularNode(int data, CircularNode next) {
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public CircularNode getNext() {
		return next;
	}

	public void setNext(CircularNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "CircularNode [data=" + data + "]";
	}

}
