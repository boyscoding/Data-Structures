package RelevantIssues;

import Stack.LinkStack;
import org.junit.jupiter.api.Test;

/**
 * @program: Data Structures
 * @description: 问题3：给定一个由多个字符组成的字符串，如何判断该字符串是否是回文？
 * @author: boyscoding
 * @create: 2019-07-05
 **/
public class Questions_03 {
	/**
	 * 思路：分别定义从头遍历的指针low，从尾遍历的指针high。每次遍历时判断ch[low] 和 ch[high] 的字符是否相同即可
	 *
	 * @时间复杂度 O(n)
	 * @param str
	 * @return
	 */
	public boolean Method1(String str){
		int low = 0; //指向低位的指针
		int high = str.length() - 1; //指向高位的指针
		char[] ch = str.toCharArray();

		while (low < high && ch[low] == ch[high]) {
			low++;
			high--;
		}

		if(low < high){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 思路：将前半部分字符入栈，后半部分字符出栈，然后分别比较即可
	 *
	 * @时间复杂度 O(n)
	 * @param str
	 * @return
	 */
	public boolean Method2(String str){
		LinkStack<Character> stack = new LinkStack<>();
		char[] ch = str.toCharArray();
		int i=0;

		int halfLength = ch.length / 2;

		if(halfLength < 2){ //字符串小于两个字符，返回false
			return false;
		}

		//前半部分入栈
		while (i < halfLength) {
			stack.push(ch[i]);
			i++;
		}

		if(ch[i] == 'X'){ //如果中间是字符'X'，则跳过
			i++;
		}

		//后半部分出栈
		while (i < str.length()) {
			if(stack.isEmpty() || ch[i] != stack.pop()){
				return false;
			}
			i++;
		}

		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	@Test
	public void testMethods(){
		String str1 = "babaXabab";
		String str2 = "cabccabc";
		System.out.println("测试方法一： ");
		System.out.println(Method1(str1) + "----" + Method1(str2));

		System.out.println("测试方法二： ");
		System.out.println(Method2(str1) + "----" + Method2(str2));
		/**
		 * 输出如下：
		 * 		测试方法一：
		 * 		true----false
		 * 		测试方法二：
		 * 		true----false
		 */
	}
}
