package RelevantIssues;

import SinglyNode.LinkList;
import SinglyNode.SinglyNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Data Structures
 * @description: 问题12：假设两个单向链表在某个节点相交后，成为一个单向链表，求该交点？
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_12 {
	/**
	 * 思路：使用散列表求解
	 * @时间复杂度 O(m) + O(n) = O(max(m,n))，即：O(m)或O(n)
	 * @param headNode1
	 * @param headNode2
	 * @return
	 */
	public SinglyNode findIntersection1(SinglyNode headNode1, SinglyNode headNode2){
		Map<Integer,SinglyNode> nodeMap = new HashMap<>();

		for(int i=1;headNode1!=null;i++){
			nodeMap.put(i, headNode1);
			headNode1 = headNode1.getNext();
		}

		while (headNode2 != null) {
			if(nodeMap.containsValue(headNode2)){
				return headNode2;
			}else{
				headNode2 = headNode2.getNext();
			}
		}
		return null;
	}

	/**
	 * 思路：1，分别获得两个链表的长度；2，计算出两个链表的长度差d；
	 *         3，较长的链表首先移动d步，然后两个链表同时向表尾移动
	 *         4，当出现两个节点相同时即为交点
	 * @时间复杂度 O(m) + O(n) + O(1) + O(d) + O(min(m,n)) = O(max(m,n))
	 * @param headNode1
	 * @param headNode2
	 * @return
	 */
	public SinglyNode findIntersection2(SinglyNode headNode1,SinglyNode headNode2){
		int length1 = 0,length2 = 0; //两个链表节点数
		int diff = 0;
		SinglyNode temp1 = headNode1,temp2 = headNode2;
		//1
		while (temp1 != null) {
			length1++;
			temp1 = temp1.getNext();
		}

		while (temp2 != null) {
			length2++;
			temp2 = temp2.getNext();
		}
		//2、3
		if(length1 > 0 && length2 > 0 && length2 >= length1){
			diff = length2 - length1;

			for(int i=1;i<=diff;i++){
				headNode2 = headNode2.getNext();
			}
		}else if(length1 > 0 && length2 > 0 && length2 < length1){
			diff = length1 - length2;

			for(int i=1;i<=diff;i++){
				headNode1 = headNode1.getNext();
			}
		}else{
			return null;
		}
		//4
		while(headNode1 != null && headNode2 != null){
			if(headNode1 == headNode2){
				return headNode1;
			}else{
				headNode1 = headNode1.getNext();
				headNode2 = headNode2.getNext();
			}
		}
		return null;
	}

	@Test
	public void testMethods(){
		//人为构造两个相交的链表
		SinglyNode a = new SinglyNode(11);
		SinglyNode b = new SinglyNode(22);

		SinglyNode currentA = a,currentB = b;
		for(int i=3;i<=8;i++){
			SinglyNode tmpNode = new SinglyNode(11 * i);

			if(i < 7){
				if(i%2 == 0){
					currentB.setNext(tmpNode);
					currentB = tmpNode;

					SinglyNode tmpNode2 = new SinglyNode(11 * i + 1);
					currentB.setNext(tmpNode2);
					currentB = tmpNode2;
				}else{
					currentA.setNext(tmpNode);
					currentA = tmpNode;
				}
			}else{
				currentB.setNext(tmpNode);
				currentB = tmpNode;
				currentA.setNext(tmpNode);
				currentA = tmpNode;
			}

		}

		//遍历初始链表
		System.out.print("A: ");
		LinkList.print(a);
		System.out.print("B: ");
		LinkList.print(b);

		System.out.println("方法一，其交点是: " + findIntersection1(a,b));
		System.out.println("方法二，其交点是: " + findIntersection2(a,b));
	}
	/**
	 * 输出如下：
	 * 		A: 11 33 55 77 88
	 * 		B: 22 44 45 66 67 77 88
	 * 		方法一，其交点是: SinglyNode [data=77]
	 * 		方法二，其交点是: SinglyNode [data=77]
	 */
}
