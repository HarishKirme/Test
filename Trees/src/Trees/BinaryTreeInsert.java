package Trees;

public class BinaryTreeInsert {
	
	
	static class Node{
		
		int value;
		Node left,right;
		
		Node(int value) {
			
			this.value = value;
			left = null;
			right = null;
			
		}
	};
		
	static Node root = null;
	
	//Start add
	public static void add(int value) {
		
		root = addRecNode(root,value);
		
		
		
	}
		
	
	public static Node addRecNode(Node current,int value) {
		
		if(current ==null) {
			
			return new Node(value);
		}
		
		if(value < current.value) {
			
			current.left = addRecNode(current.left, value);
		}
		else if(value > current.value) {
			
			current.right = addRecNode(current.right,value);
			
		}
		
		return current;
		
	}
	
	//End add
	
	public static void inorder(Node root) {
		
		if(root==null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.value +" ");
		inorder(root.right);
		
	}
	
	
	//Start search
	public static boolean search(int value) {
		
		return searchNode(root,value);
			
	}
	
	public static boolean searchNode(Node current,int value) {
		
		boolean result = false;
		
		if(current == null) {
			return false;
		}
		
		if(current.value == value) {
			return true;
		}
		
		if(value < current.value) {
			result = searchNode(current.left,value);
			 
		}
		else if(value > current.value) {
			 result = searchNode(current.right,value);	 
			 
		}
		
		
		return result;
		
	}
	
	//End search
	
	//Delete start
	
	public static void delete(int value) {
		
		root = deleteRecNode(root,value);
	}
	
	public static Node deleteRecNode(Node current,int value) {
		
		if(current == null) {
			return null;
		}
		
		if(value < current.value) {
			
			current.left = deleteRecNode(current.left, value);	
		}
		else if(value > current.value) {
			
			current.right = deleteRecNode(current.right, value);
		}
		else {  			//case where node to be deleted is found 
			
			
			//case: 1
			if(current.left == null && current.right == null) {
				
				return null;
			}
			else if(current.left == null) {	//case:2
				
				return current.right;
				
			}
			else if(current.right == null) {   //case:2
				
				return current.left;
			}
			else {								 //case:3
				
				int minValue = findMinRight(current.right);
				
				current.value = minValue;
				
				current.right = deleteRecNode(current.right, minValue);
				
				return current;		
			}
			
			
			
		}
		return current;
	}
	
	
	public static int findMinRight(Node current) {
		
        return current.left == null ? current.value : findMinRight(current.left);

	}
	
	
	
	
	
	public static void main(String[] args) {
		
		int[] keys = {6,34,23,1,22,5,50,2,8};
		
		for(int i = 0;i<keys.length;i++) {
			
			add(keys[i]);	
			
		}
		
		inorder(root);
		
		System.out.println("\n"+root.value);
		
		
		if(search(22)) {
			System.out.println("value exist");
			
		}
		else {
			System.out.println("No value found");
		}
		
		
		delete(5);
		
		inorder(root);
	}
	
	
	
}