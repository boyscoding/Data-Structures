package RelevantIssues;

import SinglyNode.LinkList;
import SinglyNode.SinglyNode;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题15：给定一个单向链表，要求从链表表头开始找到最后一个满足 i%k==0 的节点
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_15 {
	/**
	 * 思路：略
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @param k
	 * @return
	 */
	public SinglyNode getModularNode(SinglyNode headNode, int k){
		SinglyNode result = null;
		if(k <= 0){
			return null;
		}

		for(int i=1;headNode!=null;i++){
			if(i % k == 0){
				result = headNode;
			}
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
	 *		 1 2 3 4 5 6 7
	 * 		目标节点是： SinglyNode [data=6]
	 */
}
