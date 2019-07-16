package RelevantIssues;

import Stack.LinkStack;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Data Structures
 * @description:问题1：如何使用栈来判断括号是否匹配？
 * @author: boyscoding
 * @create: 2019-07-05
 **/
public class Questions_01 {
	/**
	 * 思路：1. 从头开始遍历字符串的每个字符，碰到“开分隔符”就入栈，碰到“闭分隔符”先将最后压入栈中的“开分隔符”出栈，然后从Map中获取该“开分隔符”对应的“闭分隔符”。
	 *      2. 然后比较该Map中的“闭分隔符”和字符串中的“闭分隔符”是否相同。如果不同，则返回false；如果相同，继续遍历
	 *      3. 如果等到遍历完整个字符串后，此时栈中的字符为NULL（PS：没有多余的开分隔符），则说明这个字符串中的括号是匹配的
	 *
	 * @时间复杂度 O(n)
	 * @param bracketMap <开分隔符,闭分隔符>键值对
	 * @param checkStr
	 * @return
	 */
	public boolean Method1(Map<Character,Character> bracketMap, String checkStr){
		if(bracketMap == null || checkStr == null){
			return false;
		}

		LinkStack<Character> stack = new LinkStack<>(); //定义一个栈
		for(int i=0;i<checkStr.length();i++){
			char ch = checkStr.charAt(i);

			if(bracketMap.containsKey(ch)){ //碰到开分隔符执行入栈操作
				stack.push(ch); //入栈
			}else if(bracketMap.containsValue(ch)){ //碰到闭分隔符执行出栈操作
				if(stack.isEmpty()){
					return false;
				}else{
					Character bracketStart = stack.pop();
					if(ch != bracketMap.get(bracketStart)){
						return false;
					}
				}
			}

		}

		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}


	@Test
	public void testMethods(){
		Map<Character, Character> bracketMap = new HashMap<>();
		bracketMap.put('(', ')');
		bracketMap.put('[', ']');
		bracketMap.put('{', '}');

		String checkStr1 = "[(A+B)+](C-D)]";
		String checkStr2 = "((A+B)+(C-D))*E";
		String checkStr3 = "{[A+(B*C)-D/E]-[(F+(G-A)*B]}";

		System.out.println(Method1(bracketMap,checkStr1)); //false
		System.out.println(Method1(bracketMap,checkStr2)); //true
		System.out.println(Method1(bracketMap,checkStr3)); //false
	}
	/**
	 * 输出如下：
	 * 		false
	 * 		true
	 * 		false
	 */
}
