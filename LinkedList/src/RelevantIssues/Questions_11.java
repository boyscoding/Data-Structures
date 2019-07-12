package RelevantIssues;

import SinglyNode.*;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题11：如何找到链表的中间节点？
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_11 {
	/**
	 * 思路：分别定义两个移动速度为：1节点/次、2节点/次的指针，
	 *         当速度较快的指针移动到链表末尾时，此时速度较慢的指针指向的节点即为中间节点
	 * @时间复杂度 O(n/2) = O(n)
	 * @param headNode
	 * @return
	 */
	public SinglyNode findMiddle(SinglyNode headNode){
		if(headNode != null){
			SinglyNode slow = headNode,fast = headNode;

			while(fast != null && fast.getNext() != null && fast.getNext().getNext() != null){
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}
			return slow;
		}else{
			return null;
		}
	}

	@Test
	public void testMethods(){
		SinglyNode headNode = new SinglyNode(11);

		SinglyNode currentNode = headNode;
		for(int i=2;i<=6;i++){
			SinglyNode tmpNode = new SinglyNode(11 * i);
			currentNode.setNext(tmpNode);
			currentNode = tmpNode;
		}

		//遍历初始链接
		LinkList.print(headNode);

		System.out.println("链表中间节点是： " + findMiddle(headNode));
	}
	/**
	 * 输出如下：
	 * 11 22 33 44 55 66
	 * 链表中间节点是： SinglyNode [data=33]
	 */
}
