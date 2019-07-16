import Stack.LinkStack;

/**
 * @program: Data Structures
 * @description: 遍历树
 * @author: boyscoding
 * @create: 2019-07-01
 **/
public class TraversingTree {
	/**
	 * 前序遍历
	 * @param root
	 */
	public static void preOrder(BinaryTreeNode<Integer> root){
		if(root != null){
			System.out.println(root.getData() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	public static void preOrderByStack(BinaryTreeNode<Integer> root){
		LinkStack<BinaryTreeNode<Integer>> stack = new LinkStack<>();
		while (true){
			while (root != null){
				stack.push(root);
				System.out.println(root.getData() + " ");
				root = root.getLeft();
			}
			if(stack.isEmpty()){
				break;
			}
			BinaryTreeNode<Integer> temp = stack.pop();
			root = temp.getRight();
		}
	}

	public  static  void InOrder(BinaryTreeNode<Integer> root){
		if(root != null){
			InOrder(root.getLeft()); //遍历左子树
			System.out.print(root.getData() + " ");
			InOrder(root.getRight()); //遍历右子树
		}
	}
	public static void InOrderByStack(BinaryTreeNode<Integer> root){
		LinkStack<BinaryTreeNode<Integer> > stack = new LinkStack<>();
		while (true){
			while (root != null){
				stack.push(root);
				root = root.getLeft();
			}
			if(stack.isEmpty()){
				break;
			}
			BinaryTreeNode<Integer> temp = stack.pop();
			System.out.print(temp.getData() + " ");
			root = temp.getRight();
		}
	}
	public static void postOrder(BinaryTreeNode<Integer> root){
		if(root != null){
			postOrder(root.getLeft()); //遍历左子树
			postOrder(root.getRight()); //遍历右子树
			System.out.print(root.getData() + " ");
		}
	}

	/**
	 * 后续遍历
	 * @param root
	 */
	public static void postOrderByStack(BinaryTreeNode<Integer> root){
		LinkStack<BinaryTreeNode<Integer>> stack = new LinkStack<>();
		while (true){
			while (root != null) {
				stack.push(root);
				stack.push(root);
				root = root.getLeft();
			}
			if(stack.isEmpty()){
				break;
			}
			BinaryTreeNode<Integer> temp = stack.pop();
			BinaryTreeNode<Integer> topNode = null;
			if(!stack.isEmpty()){
				topNode = stack.top();
			}
			if(topNode != null && temp == topNode){
				root = temp.getRight();
			}else {
				System.out.println(temp.getData() + " ");
			}
		}
	}
	public static void levelOrder(BinaryTreeNode<Integer> root){
		LinkQueue<BinaryTreeNode<Integer>> queue = new LinkQueue<>();
		if(root != null){
			queue.enQueue(root);
		}
		while (!queue.isEmpty()){
			BinaryTreeNode<Integer> temp = queue.deQueue();
			System.out.println(temp.getData() + " ");
			if(temp.getLeft() != null){
				queue.enQueue(temp.getLeft());
			}
			if(temp.getRight() != null){
				queue.enQueue(temp.getRight());
			}
		}
	}

}
