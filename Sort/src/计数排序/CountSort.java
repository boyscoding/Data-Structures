package 计数排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @program: Data Structures
 * @description:
 * @author: boyscoding
 * @create: 2019-07-20
 **/
public class CountSort {
	public static void countSort(int[] arr) {
		if(arr==null)
			return;
		int len=arr.length;
		//保存待排序数组中的最大值，目的是确定临时数组的长度（必须）
		int maxNum=arr[0];
		//保存待排序数组中的最小值，目的是确定最终遍历临时数组时下标的初始值（非必需，只是这样可以加快速度，减少循环次数）
		int minNum=arr[0];
		//for循环就是为了找到待排序数组的最大值和最小值
		for(int i=1;i<len;i++) {
			maxNum=maxNum>arr[i]?maxNum:arr[i];
			minNum=minNum<arr[i]?minNum:arr[i];
		}
		//创建一个临时数组
		int[] temp=new int[maxNum+1];
		//for循环是为了记录待排序数组中每个元素出现的次数，并将该次数保存到临时数组中
		for(int i=0;i<len;i++) {
			temp[arr[i]]++;
		}
		//k=0用来记录待排序数组的下标
		int k=0;
		//遍历临时数组，重新为待排序数组赋值。
		for(int i=minNum;i<temp.length;i++) {
			while(temp[i]>0) {
				arr[k++]=i;
				temp[i]--;
			}
		}
	}
	@Test
	public void test(){
		int[] arr= {72,6,57,88,60,42,83,73,48,85};
		countSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
