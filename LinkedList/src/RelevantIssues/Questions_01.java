package RelevantIssues;

import SinglyNode.SinglyNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Data Structures
 * @description: 问题1：找到链表的倒数第n个节点
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_01 {
	/**
	 * 方法一：使用散列表。通过遍历将所有节点存储到散列表中，再从散列表中返回目标节点
	 *
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @param n
	 * @return
	 */
	public SinglyNode Method1(SinglyNode headNode, int n){
		Map<Integer,SinglyNode> nodeMap = new HashMap<>();
		SinglyNode currentNode = headNode;

		for(int i=1;currentNode!=null;i++){
			nodeMap.put(i, currentNode);
			currentNode = currentNode.getNext();
		}

		if(n < 1 || n > nodeMap.size()){
			throw new RuntimeException("输入参数存在错误");
		}else{
			return nodeMap.get(nodeMap.size() - n + 1);
		}
	}

	/**
	 * 方法二：首先遍历获取链表长度，再次遍历得到目标节点
	 *
	 * @时间复杂度 T(n)=O(n)+O(n)≈O(n)
	 * @param headNode
	 * @param n
	 * @return
	 */
	public SinglyNode Method2(SinglyNode headNode,int n){
		//1，获取链表长度
		int length = 0;
		SinglyNode currentNode = headNode;

		while(currentNode != null){
			length++;
			currentNode = currentNode.getNext();
		}

		if(n < 1 || n > length){
			throw new RuntimeException("输入参数存在错误");
		}else{//2，再次遍历得到目标节点
			currentNode = headNode;
			for(int i=1;i<length-n+1;i++){
				currentNode = currentNode.getNext();
			}
			return currentNode;
		}
	}

	/**
	 * 方法三：定义两个指针，二者相差n-1个节点，然后一起移动直到链表末尾
	 *
	 * @时间复杂度 O(n)
	 * @param headNode
	 * @param n
	 * @return
	 */
	public SinglyNode Method3(SinglyNode headNode,int n){
		SinglyNode frontNode=headNode,laterNode=headNode;

		//1，frontNode先移动 n-1 次
		for(int i=1;i<n;i++){
			if(frontNode != null){
				frontNode = frontNode.getNext();
			}else{
				return null;
			}
		}

		//2，frontNode和laterNode一起移动到链表结束
		while(frontNode != null && frontNode.getNext() != null){
			frontNode = frontNode.getNext();
			laterNode = laterNode.getNext();
		}
		return laterNode;
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

		//方法一
		System.out.println("方法一：" + Method1(headNode, 2));
		//方法二
		System.out.println("方法二：" + Method2(headNode, 2));
		//方法三
		System.out.println("方法三：" + Method3(headNode, 2));

		/**
		 *输出如下：
		 * 		方法一：SinglyNode [data=44]
		 * 		方法二：SinglyNode [data=44]
		 * 		方法三：SinglyNode [data=44]
		 */
	}

}
