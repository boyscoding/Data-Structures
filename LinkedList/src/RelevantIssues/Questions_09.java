package RelevantIssues;

import SinglyNode.SinglyNode;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题9：判断一个链表的长度是奇数还是偶数？
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_09 {
	/**
	 * 思路：定义一个在链表中每次移动两个节点的指针，如果最后指针指向NULL，
	 *     则说明此链表的长度是偶数
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @return
	 */
	public void CheckList(SinglyNode headNode){
		while(headNode != null && headNode.getNext() != null){
			headNode = headNode.getNext().getNext();
		}
		if(headNode == null){
			System.out.println("此链表长度为偶数");
		}else{
			System.out.println("此链表长度为奇数");
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

		CheckList(headNode);
	}
	/**
	 *输出如下：
	 * 		此链表长度为奇数
	 */

}
