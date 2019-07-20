package 冒泡排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @program: Data Structures
 * @description:
 * @author: boyscoding
 * @create: 2019-07-20
 **/
public class BubbleSort {

	public static void bubbleSort(int[] arr){
		if(arr == null){
			return;
		}
		int len = arr.length;
		//i控制循环次数，长度为len的数组只需要循环len-1次，i的起始值为0所以i<len-1
		for(int i=0;i<len-1;i++) {
			//j控制比较次数，第i次循环内需要比较len-i次
			//但是由于是由arr[j]跟arr[j+1]进行比较，所以为了保证arr[j+1]不越界，j<len-i-1
			for (int j = 0; j < len - i - 1; j++) {
				//如果前一个数比后一个数大，则交换位置将大的数往后放。
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}

		}
	}
	@Test
	public void test(){
		int[] arr= {3,8,6,2,1,8};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}