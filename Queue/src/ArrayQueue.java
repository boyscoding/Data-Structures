/**
 * @program: Data Structures
 * @description:动态队列
 * @author: boyscoding
 * @create: 2019-07-01
 **/
public class ArrayQueue {
	private int front; //队首
	private int rear; //队尾
	private int capacity; //容量
	private int[] array;

	public ArrayQueue() {
		capacity = 1;
		front = -1;
		rear = -1;
		array = new int[1];
	}

	/**
	 * 返回队列是否为空
	 * @时间复杂度 O(1)
	 * @return
	 */
	public boolean isEmpty(){
		return (front == -1);
	}

	/**
	 * 返回队列是否已满
	 * @时间复杂度 O(1)
	 * @return
	 */
	public boolean isFull(){
		return ((rear + 1) % capacity == front);
	}

	/**
	 * 返回存储在队列的元素个数
	 * @时间复杂度 O(1)
	 * @return
	 */
	public int size(){
		if(front == -1){
			return 0;
		}

		int size = ((rear - front + 1 + capacity) % capacity);
		if(size == 0){
			return capacity;
		}else{
			return size;
		}
	}

	/**
	 * 将队列大小扩大一倍
	 * @时间复杂度 O(n)
	 */
	public void resize(){
		int initCapacity = capacity;
		int[] initArray = array;
		capacity = capacity * 2;

		array = new int[capacity];

		//复制原数组元素
		for(int i=0;i<initArray.length;i++){
			array[i] = initArray[i];
		}

		/**
		 * 在原数组中，如果队列横跨了数组的起点，则需要移动部分元素
		 * 两种思路：
		 * 1. 将0 ~ front之前的数据分别向后移动initCapacity位置，并将rear + initCapacity
		 * 2. 将front ~ (initCapacity - 1)的数据分别向后移动initCapacity位置，并将front + initCapacity
		 */
		if(front > rear){
			for(int i=0;i<front;i++){
				array[i+initCapacity] = this.array[i];
				array[i] = 0;
			}
			rear += initCapacity;
		}
	}

	/**
	 * 入队
	 * @时间复杂度 O(1)
	 * @param data
	 */
	public void enQueue(Integer data){
		//如果队列空间已满，则容量扩大一倍
		if(isFull()){
			resize();
		}

		rear = (rear + 1) % capacity;
		array[rear] = data;
		if(front == -1){
			front = rear;
		}
	}

	/**
	 * 出队
	 * @时间复杂度 O(1)
	 * @return
	 */
	public Integer deQueue(){
		if(isEmpty()){
			throw new RuntimeException("Queue Empty!");
		}else{
			int result = array[front];

			if(front == rear){ //队列已空
				front = -1;
				rear = -1;
			}else{
				front = (front + 1) % capacity;
			}
			return result;
		}
	}

	/**
	 * 返回队首的元素，但不删除
	 * @时间复杂度 O(1)
	 */
	public Integer front() {
		if(isEmpty()){
			throw new RuntimeException("Queue Empty!");
		}else{
			return array[front];
		}
	}

	/**
	 * 遍历队列
	 * @时间复杂度 O(n)
	 * @return
	 */
	public void print() {
		if(array != null && array.length > 0){
			for(int data : array){
				System.out.print(data + " ");
			}
		}
	}

	/**
	 * 删除整个队列
	 * @时间复杂度 O(1)
	 * @return
	 */
	public void deleteQueue() {
		capacity = 1;
		front = -1;
		rear = -1;
		array = new int[1];
	}

}
