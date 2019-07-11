package DoubleNode;

/**
 * @program: Data Structures
 * @description: 双向链表
 * @author: boyscoding
 * @create: 2019-07-01
 **/
public class DoubleNode {
	private int data; // 数据
	private DoubleNode previous; // 该节点的上个节点
	private DoubleNode next; // 该节点的下个节点

	public DoubleNode(int data) {
		this.data = data;
	}

	public DoubleNode(int data, DoubleNode previous, DoubleNode next) {
		this.data = data;
		this.previous = previous;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoubleNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleNode previous) {
		this.previous = previous;
	}

	public DoubleNode getNext() {
		return next;
	}

	public void setNext(DoubleNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "DoubleNode [data=" + data + "]";
	}
}
