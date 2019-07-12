package RelevantIssues;

import SinglyNode.*;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题8：如何从表尾开始输出链表？
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_08 {

	/**
	 * 思路：递归，从链表末尾开始输出
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @return
	 */
	public void printFromEnd(SinglyNode headNode){
		if(headNode != null){
			if(headNode.getNext() != null){
				printFromEnd(headNode.getNext());
			}

			System.out.print(headNode.getData() + " ");
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

		//遍历初始链表
		LinkList.print(headNode);

		//从末尾开始遍历链表
		printFromEnd(headNode);
	}
	/**
	 * 输出如下：
	 * 		11 22 33 44 55
	 * 		55 44 33 22 11
	 */
}
