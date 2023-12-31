package DataStructures.Trees;

import java.util.Scanner;

//class Node {
//	Node left;
//	Node right;
//	int data;
//
//	Node(int data) {
//		this.data = data;
//		left = null;
//		right = null;
//	}
//}

class LowestCommonAncestor {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	 */
	public static Node lca(Node root, int v1, int v2) {
		// Write your code here.
//		Case: both data goes to left
		if(root.data > v1 && root.data > v2) {
			if(root.left != null) {
				root = lca(root.left, v1, v2);
			}
//		Case: both data goes to right
		}else if(root.data < v1 && root.data < v2){
			if(root.right != null) {
				root = lca(root.right, v1, v2);
			}
		}
			return root;
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
		int v1 = scan.nextInt();
		int v2 = scan.nextInt();
		scan.close();
		Node ans = lca(root,v1,v2);
		System.out.println(ans.data);
	}	
}