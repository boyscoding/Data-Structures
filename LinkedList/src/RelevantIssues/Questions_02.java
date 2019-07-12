package RelevantIssues;

import SinglyNode.SinglyNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Data Structures
 * @description: 问题2：如何判断给定的链表是以NULL结尾，还是形成了一个环？
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_02 {
	/**
	 * 方法一：使用散列表。从表头开始逐个遍历链表中的每个节点，检查其是否已经存在散列表中。
	 * 如果存在则说明已经访问过该节点了，也就是存在环；如果一直到表尾都没有出现已经访问过的节点，
	 * 则说明该链表不存在环
	 *
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @return
	 */
	public boolean Method1(SinglyNode headNode){
		Map<Integer,SinglyNode> nodeMap = new HashMap<>();
		SinglyNode currentNode = headNode;

		for(int i=1;currentNode!=null;i++){
			if(nodeMap.containsValue(currentNode)){
				return true;
			}else{
				nodeMap.put(i, currentNode);
				currentNode = currentNode.getNext();
			}
		}

		return false;
	}

	/**
	 * Floyd环判定算法：
	 * 使用两个在链表中具有不同移动速度的指针同时移动，一旦它们进入环就一定会相遇
	 * 原因：fast指针和slow指针只有当整个或者部分链表是一个环时才会相遇
	 *
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @return
	 */
	public boolean Method2(SinglyNode headNode){
		SinglyNode fastNode=headNode,slowNode=headNode;

		while(slowNode.getNext() != null && fastNode.getNext() != null && fastNode.getNext().getNext() != null){
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();

			if(slowNode == fastNode){
				return true;
			}
		}
		return false;
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

		//方法一
		System.out.println("方法一：链表headNode1是否存在环：" + Method1(headNode1)
				+ "；链表headNode2是否存在环：" + Method1(headNode2));
		//方法二
		System.out.println("方法二：链表headNode1是否存在环：" + Method2(headNode1)
				+ "；链表headNode2是否存在环：" + Method2(headNode2));
	}
	/**
	 * 输出如下：
	 * 方法一：链表headNode1是否存在环：false；链表headNode2是否存在环：true
	 * 方法二：链表headNode1是否存在环：false；链表headNode2是否存在环：true
	 */
}
