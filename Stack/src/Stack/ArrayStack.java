package Stack;

import java.util.EmptyStackException;

/**
 * @program: Data Structures
 * @description: 动态栈
 * @author: boyscoding
 * @create: 2019-07-01
 **/
public class ArrayStack {
	private int top;
	private int capacity;
	private int[] array;

	public ArrayStack() {
		capacity = 1;
		array = new int[capacity];
		top = -1;
	}
	public boolean isEmpty(){
		return (top ==-1);
	}
	public boolean isStackFull(){
		return (top == capacity-1);
	}
	public void push(Integer data){
		if(isStackFull()){
			doubleStack();
		}
		array[top+1] = data;
		top++;
	}
	public Integer pop(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		int result = array[top];
		top--;
		return result;
	}
	public Integer top(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return array[top];
	}
	public int size(){
		return top+1;
	}
	public void deleteStack(){
		top = -1;
	}
	public void doubleStack(){
		int[] newArray = new int[capacity * 2];
		System.arraycopy(array, 0, newArray,0, capacity);
		capacity = capacity * 2;
		array = newArray;
	}
}
