package CirularNode;

import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 循环链表的操作方法
 * @author: boyscoding
 * @create: 2019-07-11 10:38
 **/
public class LinkList {
	/**
	 * 获取指定循环链表的长度
	 * 思路：
	 *         沿着指针遍历，当再次遍历到headNode时结束遍历
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 * @return 返回链表长度
	 */
	public int getLength(CircularNode headNode){
		int length = 0;
		CircularNode currentNode = headNode;

		while(currentNode != null){
			length++;
			currentNode = currentNode.getNext();

			if(currentNode == headNode){
				break; //结束遍历
			}
		}

		return length;
	}

	/**
	 * 遍历一个循环链表的data
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 */
	public static void print(CircularNode headNode){
		CircularNode currentNode = headNode;
		while(currentNode != null){
			System.out.print(currentNode.getData() + " ");
			currentNode = currentNode.getNext();

			if(currentNode == headNode){
				break; //结束遍历
			}
		}
		System.out.println();
	}

	/**
	 * 向循环链表的表头插入、中间插入以及末尾插入
	 * 思路：
	 *         类似单链表的插入，略
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 * @param newNode 新节点
	 * @param position 插入位置，从1开始
	 * @return 返回执行插入之后的链表的表头节点
	 */
	public CircularNode insertOneNode(CircularNode headNode,CircularNode newNode,int position){
		//如果链表为空，设置新节点为表头节点
		if(headNode == null){
			return newNode;
		}

		//链表长度
		int length = getLength(headNode);
		position = position % length;
		if(position < 0){
			position = length + position;
		}

		if(position == 0){ //在表头插入，设置循环链表的表头位置为0
			CircularNode currentNode = headNode;
			//找到表尾节点
			while(currentNode.getNext() != headNode){
				currentNode = currentNode.getNext();
			}

			currentNode.setNext(newNode);
			newNode.setNext(headNode);
			return newNode;
		}else{ //在表中间、表尾插入
			CircularNode previousNode = headNode; //插入之后newNode之前的节点
			for(int i=0;i<position-1;i++){
				previousNode = previousNode.getNext();
			}
			CircularNode currentNode = previousNode.getNext(); //插入之后newNode之后的节点

			previousNode.setNext(newNode); //previousNode --> newNode
			newNode.setNext(currentNode); //newNode --> currentNode

			return headNode;
		}
	}

	/**
	 * 删除循环链表中的某个节点
	 * 思路：
	 *         类似单链表的删除，略
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 * @param position 待删除节点位置
	 * @return 返回执行删除之后的链表的表头节点
	 */
	public CircularNode deleteOneNode(CircularNode headNode,int position){
		if(headNode == null){
			throw new RuntimeException("此链表不存在");
		}

		//链表长度
		int length = getLength(headNode);
		position = position % length;
		if(position < 0){
			position = length + position;
		}

		if(position == 0){ //删除表头节点
			CircularNode currentNode = headNode;
			//找到表尾节点
			while(currentNode.getNext() != headNode){
				currentNode = currentNode.getNext();
			}

			currentNode.setNext(headNode.getNext());
			CircularNode newHeadNode = headNode.getNext();
			headNode = null;
			return newHeadNode;
		}else{ //删除中间节点或者表尾节点
			CircularNode previousNode = headNode; //position位置前面一个节点
			for(int i=0;i<position-1;i++){
				previousNode = previousNode.getNext();
			}

			CircularNode currentNode = previousNode.getNext(); //position位置待删除的节点

			previousNode.setNext(currentNode.getNext());
			currentNode = null;
			return headNode;
		}
	}

	/**
	 * 测试用例
	 */
	@Test
	public void testMethods(){
		CircularNode headNode = new CircularNode(1);

		CircularNode currentNode = headNode;
		for(int i=2;i<=5;i++){
			CircularNode tmpNode = new CircularNode(1 * i);
			currentNode.setNext(tmpNode);
			currentNode = tmpNode;
			if(i == 5){
				currentNode.setNext(headNode);
			}
		}

		//1 获取链表长度
		System.out.println("此链表的长度是：" + getLength(headNode));
		System.out.println("--------------------------------------");

		//2 遍历链表数据
		System.out.println("遍历链表数据：");
		print(headNode);
		System.out.println("--------------------------------------");

		//3 插入一个新节点
		System.out.println("插入一个新节点：");
		CircularNode newNode = new CircularNode(6);
		headNode = insertOneNode(headNode, newNode, 5);
		print(headNode);
		System.out.println("--------------------------------------");

		//4 删除一个节点
		System.out.println("删除一个节点：");
		print(deleteOneNode(headNode, -1));
		System.out.println("--------------------------------------");
	}
}
