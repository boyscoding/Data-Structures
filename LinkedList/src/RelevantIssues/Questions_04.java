package RelevantIssues;

import SinglyNode.SinglyNode;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题4：如何判断给定的链表是以NULL结尾，还是形成了一个环？如果链表中存在环，则返回环的长度
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_04 {
	/**
	 * 在找到环之后，保持fastNode不动，接下来slowNode每次移动一个节点，同时计数器加一，
	 * 当它们再次相遇时即可求出环的长度
	 *
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @return
	 */
	public int findLoopLength(SinglyNode headNode){
		SinglyNode fastNode=headNode,slowNode=headNode;
		boolean loopExists = false; //是否存在环的标识
		int length = 0; //环的长度

		while(slowNode.getNext() != null && fastNode.getNext() != null && fastNode.getNext().getNext() != null){
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();

			if(slowNode == fastNode){
				loopExists = true;
				break;
			}
		}

		//如果存在环，则保持fastNode不动，slowNode逐个移动，直到二者再次相遇
		if(loopExists){
			slowNode = slowNode.getNext();
			length++;
			while(slowNode != fastNode){
				slowNode = slowNode.getNext();
				length++;
			}
		}
		return length;
	}

	@Test
	public void testMethods(){
		SinglyNode headNode1 = new SinglyNode(11);

		SinglyNode currentNode = headNode1;
		for(int i=2;i<=5;i++){
			SinglyNode tmpNode = new SinglyNode(11 * i);
			currentNode.setNext(tmpNode);
			currentNode = tmpNode;
		}

		//链表headNode2，人为构造了一个环
		SinglyNode headNode2 = new SinglyNode(11);
		SinglyNode ringStartNode = null;
		currentNode = headNode2;
		for(int i=2;i<=8;i++){
			SinglyNode tmpNode = new SinglyNode(11 * i);
			currentNode.setNext(tmpNode);
			currentNode = tmpNode;
			if(i == 3){
				ringStartNode = tmpNode;
			}else if(i == 8){
				tmpNode.setNext(ringStartNode);
			}
		}

		System.out.println("链表headNode1的环的长度：" + findLoopLength(headNode1)
				+ "；链表headNode2的环的长度：" + findLoopLength(headNode2));
	}
	/**
	 * 输出如下：
	 * 		链表headNode1的环的长度：0；链表headNode2的环的长度：6
	 */
}
