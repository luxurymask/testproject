package whiteboard;

import java.util.Deque;
import java.util.LinkedList;

public class Tree {
	public static void postOrderTraverseNonrecursively(TreeNode<String> root){
		Deque<TreeNode<String>> stack = new LinkedList<>();
		TreeNode<String> current = root;
		TreeNode<String> last = null;
		while(!stack.isEmpty() || current != null){
			while(current != null){
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			if(current.right == null || current.right == last){
				System.out.print(current.val + " ");
				last = current;
				current = null;
			}else{
				stack.push(current);
				current = current.right;
			}
		}
	}
	
	public static void infixOrderTraverseNonrecursively(TreeNode<String> root){
		Deque<TreeNode<String>> stack = new LinkedList<>();
		TreeNode<String> current = root;
		while(!stack.isEmpty() || current != null){
			while(current != null){
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.print(current.val + " ");
			current = current.right;
		}
	}
	
	public static void preOrderTraverseNonrecursively(TreeNode<String> root){
		Deque<TreeNode<String>> stack = new LinkedList<>();
		TreeNode<String> current = root;
		while(!stack.isEmpty() || current != null){
			while(current != null){
				System.out.print(current.val + " ");
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			current = current.right;
		}
	}
	
	public static void main(String[] args){
		TreeNode<String> root = new TreeNode<>("1");
		root.left = new TreeNode<>("2");
		root.right = new TreeNode<>("3");
		root.left.left = new TreeNode<>("4");
		root.left.right = new TreeNode<>("5");
		root.right.left = new TreeNode<>("6");
		root.right.right = new TreeNode<>("7");
		preOrderTraverseNonrecursively(root);
		System.out.println();
		infixOrderTraverseNonrecursively(root);
		System.out.println();
		postOrderTraverseNonrecursively(root);
	}
}
