package SinglyNode;

/**
 * @program: Data Structures
 * @description: 单链表
 * @author: boyscoding
 * @create: 2019-07-01
 **/
public class SinglyNode<T> {
	private T data; //数据
	public SinglyNode<T> next; //下一个结点

	public SinglyNode(T data) {
		this.data = data;
	}

	public SinglyNode(T data, SinglyNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SinglyNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "SinglyNode{" +
				"data=" + data +
				", next=" + next +
				'}';
	}
}
