package RelevantIssues;

import SinglyNode.LinkList;
import SinglyNode.SinglyNode;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题16：给定一个单向链表，要求从链表表尾开始找到第一个满足 i%k==0 的节点
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_16 {
	/**
	 * 思路：
	 *         headNode首先移动k个节点，然后headNode和result再分别逐步向表尾移动，
	 * 当headNode移动到NULL时，此时result即为目标节点
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @param k
	 * @return
	 */
	public SinglyNode getModularNode(SinglyNode headNode, int k){
		SinglyNode result = headNode;
		if(k <= 0){
			return null;
		}

		for(int i=1;i<=k;i++){
			if(headNode != null){
				headNode = headNode.getNext();
			}else{
				return null;
			}
		}

		while (headNode != null) {
			result = result.getNext();
			headNode = headNode.getNext();
		}

		return result;
	}

	@Test
	public void testMethods(){
		SinglyNode headNode = new SinglyNode(1);

		SinglyNode currentNode = headNode;
		for(int i=2;i<=7;i++){
			SinglyNode tmpNode = new SinglyNode(i);
			currentNode.setNext(tmpNode);
			currentNode = tmpNode;
		}

		//遍历初始链接
		LinkList.print(headNode);

		System.out.println("目标节点是： " + getModularNode(headNode,3));
	}
	/**
	 * 输出如下：
	 * 		1 2 3 4 5 6 7
	 * 		目标节点是： SinglyNode [data=5]
	 */

}
