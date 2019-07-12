package RelevantIssues;

import CirularNode.CircularNode;
import CirularNode.LinkList;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题13：如何把一个循环链表分割成两个长度相等的部分？
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_13 {
	/**
	 * 思路：
	 *         定义两个移动速度不一样的指针：fastNode每次移动两个节点，slowNode每次移动一个节点。
	 * 当slowNode移动到中间节点的时候，如果链表有奇数个节点，此时fastNode.getNext()指向headNode；
	 * 如果链表有偶数个节点，此时fastNode.getNext().getNext()指向headNode
	 * @时间复杂度 O(n)
	 * @param headNode
	 */
	public void splitList(CircularNode headNode){
		if(headNode == null)
			return;
		CircularNode fastNode = headNode,slowNode = headNode;

		while(fastNode.getNext() != headNode && fastNode.getNext().getNext() != headNode){
			fastNode = fastNode.getNext().getNext();
			slowNode = slowNode.getNext();
		}

		CircularNode result1 = null,result2 = null; //定义两个分割之后的子链表
		result1 = headNode; //设置前半部分的head指针
		if(headNode.getNext() != headNode){
			result2 = slowNode.getNext(); //设置后半部分的head指针
		}

		//如果链表有偶数个节点，此时fastNode再向后移动一个节点
		if(fastNode.getNext().getNext() == headNode){
			fastNode = fastNode.getNext();
		}
		fastNode.setNext(slowNode.getNext()); //把后半部分闭合成环
		slowNode.setNext(headNode); //把前半部分闭合成环

		//测试输出两个子链表
		System.out.print("子链表1：");
		LinkList.print(result1);

		System.out.print("子链表2：");
		if(result2 != null){
			LinkList.print(result2);
		}
	}



	@Test
	public void testMethods(){
		CircularNode headNode = new CircularNode(11);

		CircularNode currentNode = headNode;
		for(int i=2;i<=7;i++){
			CircularNode tmpNode = new CircularNode(11 * i);
			currentNode.setNext(tmpNode);
			currentNode = tmpNode;

			if(i == 7){
				currentNode.setNext(headNode);
			}
		}

		//遍历初始链接
		LinkList.print(headNode);

		splitList(headNode);
	}
	/**
	 * 输出如下：
	 * 		11 22 33 44 55 66 77
	 * 		子链表1：11 22 33 44
	 * 		子链表2：55 66 77
	 */
}
