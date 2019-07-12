package RelevantIssues;

import CirularNode.CircularNode;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题14：约瑟夫环：N个人想选出一个领头人
 * @author: boyscoding
 * @create: 2019-07-02
 **/
public class Questions_14 {

	/**
	 *
	 * @param N 人数
	 * @param M 每次数数个数
	 */
	public void getLastPerson(int N,int M){
		//构建一个环
		CircularNode headNode = new CircularNode(1);

		CircularNode currentNode = headNode;
		for(int i=2;i<=N;i++){
			CircularNode tmpNode = new CircularNode(i);
			currentNode.setNext(tmpNode);
			currentNode = tmpNode;

			if(i == N){
				currentNode.setNext(headNode);
			}
		}

		//当链表大于一个节点时一直循环排除下去
		while(headNode.getNext() != headNode){
			for(int i=1;i<M;i++){
				headNode = headNode.getNext();
			}
			headNode.setNext(headNode.getNext().getNext()); //排除headNode.getNext()这个人
		}
		System.out.println("剩下的人是： " + headNode.getData());
	}

	@Test
	public void testMethods(){
		getLastPerson(5,3);
	}
	/**
	 * 输出如下：
	 * 		剩下的人是： 5
	 */
}
