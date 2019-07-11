package DoubleNode;

import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 双向链表的操作方法
 * @author: boyscoding
 * @create: 2019-07-11 10:28
 **/
public class LinkList {
	/**
	 * 获取指定双链表的长度
	 * 思路：
	 *         1，沿着指针遍历，当next指针的值为NULL时结束遍历
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 * @return 返回链表长度
	 */
	public int getLength(DoubleNode headNode){
		int length = 0;
		DoubleNode currentNode = headNode;

		while(currentNode != null){
			length++;
			currentNode = currentNode.getNext();
		}

		return length;
	}

	/**
	 * 打印双链表的data
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 */
	public void print(DoubleNode headNode){
		while(headNode != null){
			System.out.print(headNode.getData() + " ");
			headNode = headNode.getNext();
		}
		System.out.println();
	}

	/**
	 * 向双链表的表头插入、中间插入以及末尾插入
	 * 思路：
	 *         1，如果在表头位置插入新节点，则将newNode的next设置为headNode，同时将headNode的previous设置为newNode，
	 * 并返回newNode
	 *         2，如果在链表中间或者末尾插入新节点，则找到插入之后newNode之前的节点（previousNode）
	 * 以及插入之后newNode之后的节点（currentNode），后面操作跟上面类似，略
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 * @param newNode 新节点
	 * @param position 插入位置，从1开始
	 * @return 返回执行插入之后的链表的表头节点
	 */
	public DoubleNode insertOneNode(DoubleNode headNode,DoubleNode newNode,int position){
		//如果链表为空，设置新节点为表头节点
		if(headNode == null){
			return newNode;
		}

		//链表长度
		int length = getLength(headNode);
		if(position < 1 || position > length+1){
			throw new RuntimeException("插入位置参数异常");
		}

		if(position == 1){ //在表头插入
			newNode.setNext(headNode); //newNode的下个结点为 原先的头结点
			newNode.setPrevious(null); //newNode的上个结点为 null
			headNode.setPrevious(newNode);//原先的头结点的上个结点设置为 newNode
			return newNode;
		}else{ //在表中间、表尾插入
			DoubleNode previousNode = headNode; //插入之后newNode之前的节点
			for(int i=1;i<position-1;i++){ //遍历到要插入的位置
				previousNode = previousNode.getNext();
			}
			DoubleNode currentNode = previousNode.getNext(); //插入之后newNode之后的节点

			previousNode.setNext(newNode); //previousNode --> newNode
			newNode.setPrevious(previousNode);

			newNode.setNext(currentNode); //newNode --> currentNode
			if(currentNode != null){
				currentNode.setPrevious(newNode);
			}

			return headNode;
		}
	}

	/**
	 * 删除双链表中的某个节点
	 * 思路：
	 *         1，如果删除表头节点，则首先找到表头节点的下一个节点，然后将表头节点置NULL，同时将表头节点的下一个节点的
	 * previous设置为NULL，最后返回表头节点的下一个节点
	 *         2，如果删除中间节点或者表尾节点，则首先找到待删除节点和它的前后节点，后面操作跟上面类似，略
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 * @param position 待删除节点位置
	 * @return 返回执行删除之后的链表的表头节点
	 */
	public DoubleNode deleteOneNode(DoubleNode headNode,int position){
		//链表长度
		int length = getLength(headNode);
		if(headNode == null || position < 1 || position > length){
			throw new RuntimeException("删除位置参数异常");
		}

		if(position == 1){ //删除表头节点
			DoubleNode currentNode = headNode.getNext();
			headNode = null;
			currentNode.setPrevious(null);
			return currentNode;
		}else{ //删除中间节点或者表尾节点
			DoubleNode previousNode = headNode; //position位置前面一个节点
			for(int i=1;i<position-1;i++){
				previousNode = previousNode.getNext();
			}
			DoubleNode currentNode = previousNode.getNext(); //position位置待删除的节点
			DoubleNode laterNode = currentNode.getNext(); //position位置后面一个节点

			previousNode.setNext(laterNode);
			currentNode = null;
			if(laterNode != null){
				laterNode.setPrevious(previousNode);
			}
			return headNode;
		}
	}

	/**
	 * 测试用例
	 */
	@Test
	public void testMethods(){
		DoubleNode headNode = new DoubleNode(1);

		DoubleNode currentNode = headNode;
		for(int i=2;i<=5;i++){
			DoubleNode tmpNode = new DoubleNode(1 * i);
			currentNode.setNext(tmpNode);
			tmpNode.setPrevious(currentNode);
			currentNode = tmpNode;
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
		DoubleNode newNode = new DoubleNode(6);
		headNode = insertOneNode(headNode, newNode, 2);
		print(headNode);
		System.out.println("--------------------------------------");

		//4 删除一个节点
		System.out.println("删除一个节点：");
		print(deleteOneNode(headNode, 2));
		System.out.println("--------------------------------------");

	}
}
