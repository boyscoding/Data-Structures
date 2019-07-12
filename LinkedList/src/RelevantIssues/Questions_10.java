package RelevantIssues;

import SinglyNode.*;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题10：如何将两个有序链表合并成一个新的有序链表？
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_10 {

	/**
	 * 思路：递归依次比较大小
	 * @时间复杂度 O(n/2) = O(n)
	 * @param headNode1
	 * @param headNode2
	 * @return
	 */
	public SinglyNode MergeList(SinglyNode<Integer> headNode1, SinglyNode<Integer> headNode2){
		SinglyNode result = null;

		if(headNode1 == null) return headNode2;
		if(headNode2 == null) return headNode1;

		if(headNode1.getData() <= headNode2.getData()){
			result = headNode1;
			result.setNext(MergeList(headNode1.getNext(),headNode2));
		}else{
			result = headNode2;
			result.setNext(MergeList(headNode1, headNode2.getNext()));
		}
		return result;
	}

	@Test
	public void testMethods(){
		SinglyNode a = new SinglyNode(11);
		SinglyNode b = new SinglyNode(22);

		SinglyNode currentA = a,currentB = b;
		for(int i=3;i<=8;i++){
			SinglyNode tmpNode = new SinglyNode(11 * i);

			if(i%2 == 0){
				currentB.setNext(tmpNode);
				currentB = tmpNode;
			}else{
				currentA.setNext(tmpNode);
				currentA = tmpNode;
			}

		}

		//遍历初始链表
		System.out.print("A: ");
		LinkList.print(a);
		System.out.print("B: ");
		LinkList.print(b);

		System.out.print("合并之后: ");
		LinkList.print(MergeList(a, b));
	}
	/**
	 * 输出如下：
	 * 		A: 11 33 55 77
	 * 		B: 22 44 66 88
	 * 		合并之后: 11 22 33 44 55 66 77 88
	 */
}
