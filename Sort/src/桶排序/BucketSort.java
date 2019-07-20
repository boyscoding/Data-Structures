package 桶排序;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: Data Structures
 * @description:
 * @author: boyscoding
 * @create: 2019-07-20
 **/
public class BucketSort {
	public static void bucketSort(int[] arr) {
		if(arr==null)
			return;
		int len=arr.length;
		//定义桶的个数，这里k的值要视情况而定，这里我们假设待排序数组里的数都是[0,100)之间的。
		int k=10;
		//用嵌套集合来模拟桶，外层集合表示桶，内层集合表示桶里边装的元素。
		List<List<Integer>> bucket=new ArrayList<>();
		//for循环初始化外层集合即初始化桶
		for(int i=0;i<k;i++){
			bucket.add(new ArrayList<>());
		}
		//循环是为了将待排序数组中的元素通过映射函数分别放入不同的桶里边
		for(int i=0;i<len;i++) {
			bucket.get(mapping(arr[i])).add(arr[i]);
		}
		//这个循环是为了将所有的元素个数大于1的桶里边的数据进行排序。
		for(int i=0;i<k;i++) {
			if(bucket.size()>1) {
				//因为这里是用集合来模拟的桶所以用java写好的对集合排序的方法。
				//其实应该自己写一个方法来排序的。
				Collections.sort(bucket.get(i));
			}

		}
		//将排好序的数重新放入待排序数组中
		int m=0;
		for(List<Integer> list:bucket) {
			if(list.size()>0) {
				for(Integer a:list) {
					arr[m++]=a;
				}
			}
		}
	}
	/**
	 * 映射函数
	 * @param num
	 * @return
	 */
	public static int mapping(int num) {
		return num/10;
	}
	@Test
	public void test(){
		int[] arr= {72,6,57,88,60,42,83,73,48,85};
		bucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
