import SinglyNode.SinglyNode;

import java.util.EmptyStackException;

/**
 * @program: Data Structures
 * @description: 基于链表的栈
 * @author: boyscoding
 * @create: 2019-07-01
 **/
public class LinkStack<T> {

	private SinglyNode<T> headNode;
	public boolean isFull(){
		return false;
	}
	public boolean isEmpty(){
		return headNode == null?true:false;
	}
	public void push(T data){
		if(headNode == null){
			headNode = new SinglyNode<>(data);
		}else{
			SinglyNode newNode = new SinglyNode(data);
			newNode.setNext(headNode);
			headNode = newNode;
		}

	}
	public T pop(){
		if(headNode == null){
			throw new EmptyStackException();
		}else{
			T data = headNode.getData();
			headNode = headNode.getNext();
			return data;
		}


	}
	public T top(){
		if(headNode == null){
			throw  new EmptyStackException();
		}else{
			return headNode.getData();
		}
	}
	public int size(){
		if(headNode == null){
			return 0;
		}else{
			int length = 0;
			SinglyNode currentNode = headNode;
			while ((currentNode != null)) {
				length ++;
				currentNode = currentNode.getNext();
			}
			return length;
		}
	}

}
