package SinglyNode;

import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 单链表操作
 * @author: boyscoding
 * @create: 2019-07-01
 **/
public class LinkList {
	/**
	 * 获取指定单链表的长度
	 * 思路：
	 *         沿着指针遍历，当next指针的值为NULL时结束遍历
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 * @return 返回链表长度
	 */
	public int getLength(SinglyNode<Integer> headNode){
		int length = 0;
		SinglyNode<Integer> currentNode = headNode;
		while(currentNode != null){
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}

	/**
	 * 打印单链表的data
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 */
	public static void print(SinglyNode<Integer> headNode){
		while(headNode != null){
			System.out.print(headNode.getData() + " ");
			headNode = headNode.getNext();
		}
		System.out.println();
	}

	/**
	 * 向单链表的表头插入、中间插入以及末尾插入
	 * 思路：
	 *         1，如果在表头位置插入新节点，则将新节点的next设置为headNode，并返回newNode
	 *         2，如果在链表中间或者末尾插入新节点，则找到插入之后newNode之前的节点（previousNode）
	 * 以及插入之后newNode之后的节点（currentNode），然后再分别设置previousNode和newNode的next即可
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 * @param newNode 新节点
	 * @param position 插入位置，从1开始
	 * @return 返回执行插入之后的链表的表头节点
	 */
	public SinglyNode<Integer> insertOneNode(SinglyNode<Integer> headNode,SinglyNode<Integer> newNode,int position){
		//如果链表为空，设置新节点为表头节点
		if(headNode == null){
			return newNode;
		}

		//链表的长度
		int length = getLength(headNode);
		if(position < 1 || position > length+1){
			throw new RuntimeException("插入位置参数异常");
		}
		if(position == 1){ //在表头插入
			newNode.setNext(headNode);
			return newNode;
		}else{ //在表中间、表尾插入
			SinglyNode<Integer> previousNode = headNode; //插入之后newNode之前的节点
			for(int i=1;i<position-1;i++){
				previousNode = previousNode.getNext();
			}
			SinglyNode<Integer> currentNode = previousNode.getNext(); //插入之后newNode之后的节点
			previousNode.setNext(newNode); //previousNode --> newNode
			newNode.setNext(currentNode); //newNode --> currentNode
			return headNode;
		}
	}

	/**
	 * 删除单链表中的某个节点
	 * 思路：
	 *         1，如果删除表头节点，则首先找到表头节点的下一个节点，然后将表头节点置NULL，最后返回表头节点的下一个节点
	 *         2，如果删除中间节点或者表尾节点，则首先找到待删除节点和它的前后节点，然后将它前一个节点的next设置成它后
	 * 一个节点，并且将position位置的节点置NULL，最后返回表头节点headNode
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode 表头节点
	 * @param position 待删除节点位置
	 * @return 返回执行删除之后的链表的表头节点
	 */
	public SinglyNode<Integer> deleteOneNode(SinglyNode<Integer> headNode,int position){
		//链表长度
		int length = getLength(headNode);
		if(headNode == null || position < 1 || position > length){
			throw new RuntimeException("此链表不存在，或者待删除节点位置存在异常，请重新设置");
		}

		if(position == 1){ //删除表头节点
			SinglyNode<Integer> currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		}else{ //删除中间节点或者表尾节点
			SinglyNode<Integer> previousNode = headNode; //position位置前面一个节点
			for(int i=1;i<position-1;i++){
				previousNode = previousNode.getNext();
			}
			SinglyNode<Integer> currentNode = previousNode.getNext(); //position位置待删除的节点

			previousNode.setNext(currentNode.getNext());
			currentNode = null;
			return headNode;
		}
	}

	/**
	 * 删除整个单链表
	 * 思路：
	 * 		1，将头结点的下一个结点 赋值到 暂存结点
	 * 		2，头结点设置为null
	 * 		3，将暂存结点 设置为 头结点，循环逐个删除。
	 *
	 * @时间复杂度 O(n)
	 * @空间复杂度 O(1)
	 * @param headNode
	 */
	public void deleteAllNodes(SinglyNode<Integer> headNode){
		SinglyNode<Integer> tmpNode;
		while(headNode != null){
			tmpNode = headNode.getNext();
			headNode = null;
			headNode = tmpNode;
		}
	}

	/**
	 * 测试用例
	 */
	@Test
	public void testMethods(){
		SinglyNode<Integer> headNode = new SinglyNode<Integer>(1); //设置头结点
		SinglyNode<Integer> currentNode = headNode;
		for(int i=2;i<=5;i++){
			SinglyNode<Integer> tmpNode = new SinglyNode<Integer>(1 * i); //设置下一个结点
			currentNode.setNext(tmpNode);
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
		SinglyNode<Integer> newNode = new SinglyNode<Integer>(6);
		headNode = insertOneNode(headNode, newNode, 2);
		print(headNode);
		System.out.println("--------------------------------------");

		//4 删除一个节点
		System.out.println("删除一个节点：");
		print(deleteOneNode(headNode, 2));
		System.out.println("--------------------------------------");

	}

}
