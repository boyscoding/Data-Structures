package RelevantIssues;

import Stack.LinkStack;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: Data Structures
 * @description:问题1：如何设计一个栈，使得getMinimum() 操作的时间复杂度为O(1)？
 * @author: boyscoding
 * @create: 2019-07-05
 **/
public class Questions_02 {
	private LinkStack<Integer> elementStack = new LinkStack<>();
	private LinkStack<Integer> minStack = new LinkStack<>();


	public boolean isEmpty() {
		return elementStack.isEmpty();
	}

	public boolean isFull() {
		return false;
	}

	/**
	 * minStack入栈：当入栈元素小于等于当前minStack栈的最小值时才入栈
	 */
	public void push(Integer data) {
		elementStack.push(data);

		if(minStack.isEmpty() || data <= minStack.top()){
			minStack.push(data);
		}
	}

	/**
	 * minStack出栈：当elementStack出栈元素等于当前minStack栈的值时才出栈
	 */
	public Integer pop() {
		Integer result = elementStack.pop();

		if(result == minStack.top()){
			minStack.pop();
		}
		return result;
	}

	/**
	 * 获取当前栈的最小值
	 * @时间复杂度 O(1)
	 *
	 * @return
	 */
	public Integer getMinimum(){
		if(!minStack.isEmpty()){
			return minStack.top();
		}else{
			return null;
		}
	}

	public Integer top() {
		return elementStack.top();
	}

	public int size() {
		return elementStack.size();
	}

	public void deleteStack() {
		elementStack.deleteStack();
		minStack.deleteStack();
	}

	public void print() {
		elementStack.print();
	}

}
