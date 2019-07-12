package RelevantIssues;

import SinglyNode.SinglyNode;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题3：如何判断给定的链表是以NULL结尾，还是形成了一个环？如果链表中存在环，则找到环的起始节点
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_03 {
	/**
	 * 在找到环之后，将slowNode重新设置为表头节点，接下来slowNode和fastNode每次分别移动一个节点，
	 * 当它们再次相遇时即为环的起始节点
	 *
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @return
	 */
	public SinglyNode findLoopStartNode(SinglyNode headNode){
		SinglyNode fastNode=headNode,slowNode=headNode;
		boolean loopExists = false; //是否存在环的标识

		while(slowNode.getNext() != null && fastNode.getNext() != null && fastNode.getNext().getNext() != null){
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();

			if(slowNode == fastNode){
				loopExists = true;
				break;
			}
		}

		//如果存在环，则slowNode回到表头
		if(loopExists){
			slowNode = headNode;
			while(slowNode != fastNode){
				slowNode = slowNode.getNext();
				fastNode = fastNode.getNext();
			}
			return fastNode;

		}
		return null;
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

		System.out.println("链表headNode1的环的起始节点：" + findLoopStartNode(headNode1)
				+ "；链表headNode2的环的起始节点：" + findLoopStartNode(headNode2));
	}
	/**
	 * 输出如下：
	 * 		链表headNode1的环的起始节点：null；链表headNode2的环的起始节点：SinglyNode [data=33]
	 */

}
