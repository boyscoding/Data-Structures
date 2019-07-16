package RelevantIssues;

import Stack.LinkStack;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题5：设计一个可以把栈中元素按照升序排列的排序算法
 * @author: boyscoding
 * @create: 2019-07-05
 **/
public class Questions_05 {
	/**
	 * 思路类似于插入排序：
	 *         每次从stack这个栈移除一个元素并将其插入到已排序的result栈的正确位置即可
	 * @时间复杂度 O(n²)
	 * @param stack
	 */
	public LinkStack<Integer> sort(LinkStack<Integer> stack){
		LinkStack<Integer> result = new LinkStack<>();

		while (!stack.isEmpty()) {
			Integer data = stack.pop();

			while (!result.isEmpty() && result.top() > data) {
				stack.push(result.pop());
			}
			result.push(data);
		}
		return result;
	}

	@Test
	public void testMethods(){
		LinkStack<Integer> stack = new LinkStack<>();
		stack.push(1);
		stack.push(6);
		stack.push(3);
		stack.push(5);
		stack.push(4);
		stack.push(2);

		stack = sort(stack);

		stack.print();
	}
	/**
	 * 输出如下：
	 * 		1 2 3 4 5 6
	 */
}




