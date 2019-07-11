import SinglyNode.SinglyNode;

/**
 * @program: Data Structures
 * @description: 基于链表队列
 * @author: boyscoding
 * @create: 2019-07-01
 **/
public class LinkQueue<T> {
	private SinglyNode<T> frontNode;
	private SinglyNode<T> rearNode;
	public LinkQueue(){
		frontNode = null;
		rearNode = null;
	}
	public boolean isEmpty(){
		return (frontNode == null);
	}
	int size(){
		int length = 0;
		SinglyNode  currentNode = frontNode;
		while (currentNode != null){
			currentNode = currentNode.getNext();
			length++;
		}
		return length;
	}
	public void  enQueue(T data){
		SinglyNode<T> newNode = new SinglyNode<>(data);
		if(rearNode != null){
			rearNode.setNext(newNode);
		}
		rearNode = newNode;
		if(frontNode == null){
			frontNode = rearNode;
		}
	}
	public T deQueue(){
		if(isEmpty()){
			throw new RuntimeException("empty");
		}else {
			T result = frontNode.getData();
			if(frontNode == rearNode){
				frontNode = null;
				rearNode = null;
			}else{
				frontNode = frontNode.getNext();
			}
			return result;
		}
	}
	T front(){
		return frontNode.getData();
	}
	void deleteQueue(){
		frontNode = null;
		rearNode = null;
	}
}
