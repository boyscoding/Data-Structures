package RelevantIssues;

import Stack.LinkStack;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题4：给定一个栈，如何只使用push和pop操作逆置栈中的内容？
 * @author: boyscoding
 * @create: 2019-07-05
 **/
public class Questions_04 {
	/**
	 * 思路：
	 *         1. 首先将栈中的所有元素递归出栈，直至栈空
	 *         2. 每次递归向上步骤时，将上一步中出栈的元素插入栈底
	 * @时间复杂度 O(n²)
	 * @param stack
	 */
	public void reverseStack(LinkStack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}else{
			Integer data = stack.pop();
			reverseStack(stack);
			insertAtBottom(stack, data);
		}

	}

	private void insertAtBottom(LinkStack<Integer> stack,Integer data){
		if(stack.isEmpty()){
			stack.push(data);
			return;
		}else{
			Integer tmp = stack.pop();
			insertAtBottom(stack, data);
			stack.push(tmp);
		}
	}

	@Test
	public void testMethods(){
		LinkStack<Integer> stack = new LinkStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);

		reverseStack(stack);
		System.out.println("逆置之后栈中的内容是：");
		stack.print();
	}
}
/**
 * 输出如下：
 * 		逆置之后栈中的内容是：
 * 		6 5 4 3 2 1
 */

