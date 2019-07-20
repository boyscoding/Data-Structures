package 插入排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @program: Data Structures
 * @description:
 * @author: boyscoding
 * @create: 2019-07-20
 **/
public class InsertSort {
	public static void insertSort(int[] arr) {
		if(arr==null)
			return;
		int len=arr.length;
		//i控制循环次数，因为已经默认第一个数的位置是正确的，所以i的起始值为1，i<len，循环len-1次
		for(int i=1;i<len;i++) {
			int j=i;//变量j用来记录即将要排序的数的位置即目标数的原位置
			int target=arr[j];//target用来记录即将要排序的那个数的值即目标值
			//while循环用来为目标值在已经排好序的数中找到合适的位置，
			//因为是从后向前比较，并且是与j-1位置的数比较，所以j>0
			while(j>0 && target<arr[j-1]) {
				//当目标数的值比它当前位置的前一个数的值小时，将前一个数的位置向后移一位。
				//并且j--使得目标数继续与下一个元素比较
				arr[j]=arr[j-1];
				j--;
			}
			//更目标数的位置。
			arr[j]=target;
			//打印每次循环结束之后数组的排序状态（方便理解）
			System.out.println("第"+(i)+"次循环之后效果："+ Arrays.toString(arr));
		}
	}
	@Test
	public void test(){
		int[] arr= {3,8,6,2,1,8};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
