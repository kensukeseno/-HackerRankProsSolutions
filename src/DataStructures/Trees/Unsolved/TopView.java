package DataStructures.Trees.Unsolved;

import java.util.Scanner;
import java.util.Stack;

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class TopView {
	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void topView(Node root) {
//		While pretraversing a tree, put data on a stack depending on its level
		Stack<Integer> stack = new Stack<>();
		
		
		
		//      if(root != null) {
//    	  System.out.print(root.data + " ");
//    	  if(root.right != null)
//    	  topView(root.right);
//      }
    }


	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}