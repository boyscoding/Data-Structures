package RelevantIssues;

import SinglyNode.SinglyNode;
import org.junit.jupiter.api.Test;
import SinglyNode.LinkList;
/**
 * @program: Data Structures
 * @description: 问题7：如何逐对逆置单向链表？
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_07 {
	/**
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @return
	 */
	public SinglyNode ReverseList(SinglyNode headNode){
		SinglyNode tempNode=null;

		if(headNode == null || headNode.getNext() == null){
			return headNode;
		}else{
			tempNode = headNode.getNext();
			headNode.setNext(tempNode.getNext());
			tempNode.setNext(headNode);
			tempNode.getNext().setNext(ReverseList(headNode.getNext()));

			return tempNode;
		}
	}

	@Test
	public void testMethods(){
		SinglyNode headNode = new SinglyNode(11);

		SinglyNode currentNode = headNode;
		for(int i=2;i<=7;i++){
			SinglyNode tmpNode = new SinglyNode(11 * i);
			currentNode.setNext(tmpNode);
			currentNode = tmpNode;
		}

		//遍历初始链表
		LinkList.print(headNode);

		headNode = ReverseList(headNode);

		//遍历最终结果
		LinkList.print(headNode);

	}
	/**
	 * 输出如下：
	 *	11 22 33 44 55 66 77
	 *	 22 11 44 33 66 55 77
	 */
}
