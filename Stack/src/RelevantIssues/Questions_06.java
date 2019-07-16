package RelevantIssues;

import Stack.LinkStack;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题6：给定一个整数栈，如何检查栈中每对相邻数字是否连续？如果栈中元素个数是奇数，则检查时忽略栈顶元素
 * @author: boyscoding
 * @create: 2019-07-05
 **/
public class Questions_06 {
	/**
	 * @时间复杂度 O(n)
	 * @param stack
	 */
	public boolean check(LinkStack<Integer> stack){
		if(stack.isEmpty()){
			return false;
		}

		int size = stack.size(); //栈中元素个数

		if(size % 2 == 1){
			stack.pop();
		}

		while (!stack.isEmpty()) {
			//连续出栈两次
			Integer num1 = stack.pop();
			Integer num2 = stack.pop();
			int sub = num1.intValue() - num2.intValue(); //两个元素之差

			if(sub != 1 && sub != -1){
				return false;
			}
		}
		return true;
	}

	@Test
	public void testMethods(){
		LinkStack<Integer> stack = new LinkStack<>();
		stack.push(4);
		stack.push(5);
		stack.push(7);
		stack.push(6);
		stack.push(-1);
		stack.push(-2);
		stack.push(2);

		System.out.println(check(stack));
	}
	/**
	 *
	 * 输出如下：
	 * 		true
	 */

}




