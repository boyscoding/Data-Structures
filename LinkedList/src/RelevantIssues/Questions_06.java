package RelevantIssues;

import SinglyNode.LinkList;
import SinglyNode.SinglyNode;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题6：如何逆置单向链表？
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_06 {
	/**
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @return
	 */
	public SinglyNode ReverseList(SinglyNode headNode){
		SinglyNode tempNode=null,nextNode=null;

		while(headNode != null){
			nextNode = headNode.getNext();
			headNode.setNext(tempNode);
			tempNode = headNode;
			headNode = nextNode;
		}
		return tempNode;
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

		headNode = ReverseList(headNode);

		//遍历最终结果
		LinkList.print(headNode);

	}
	/**
	 * 输出如下：
	 * 		11 22 33 44 55
	 * 		55 44 33 22 11
	 */
}
