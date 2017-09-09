package whiteboard;

public class TreeNode<T> {
	TreeNode<T> left;
	TreeNode<T> right;
	T val;
	
	TreeNode(T val){
		this.val = val;
	}
}
