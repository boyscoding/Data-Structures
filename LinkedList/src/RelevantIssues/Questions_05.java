package RelevantIssues;

import SinglyNode.SinglyNode;
import SinglyNode.LinkList;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题5：向有序链表中插入一个节点
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_05 {
	/**
	 * 向有序链表中插入一个节点
	 *
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @param newNode
	 * @return
	 */
	public SinglyNode insertIntoSortedList(SinglyNode<Integer> headNode, SinglyNode<Integer> newNode){
		if(newNode.getData() <= headNode.getData()){
			newNode.setNext(headNode);
			return newNode;
		}else{
			SinglyNode<Integer>  currentNode=headNode;
			while(currentNode.getNext() != null && newNode.getData() > currentNode.getNext().getData()){
				currentNode = currentNode.getNext();
			}
			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);

			return headNode;
		}
	}

	@Test
	public void testMethods(){
		SinglyNode headNode = new SinglyNode(11);

		SinglyNode currentNode = headNode;
		for(int i=2;i<=5;i++){
			SinglyNode tmpNode = new SinglyNode(11 * i);
			currentNode.setNext(tmpNode);
			currentNode = tmpNode;
		}

		//遍历初始链接
		LinkList.print(headNode);

		SinglyNode newNode = new SinglyNode(66);
		headNode = insertIntoSortedList(headNode, newNode);

		//遍历最终结果
		LinkList.print(headNode);
	}
	/**
	 * 输出如下：
	 * 		11 22 33 44 55
	 * 		11 22 33 44 55 66
	 */
}
