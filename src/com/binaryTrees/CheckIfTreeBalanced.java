package com.binaryTrees;

import com.binaryTrees.BinaryTree.Node;

//Check if a binary search tree is balanced 
public class CheckIfTreeBalanced {

	//We find the height at every node.  But in order to save time, if we find the heights don't match, we return a -1.  

	//If getHeight() returns -1, we immediately return -1.  This will save us time by not traversing too far down subtrees that are unbalanced.

	public static void main(String args[]) {
		int a = 16 >> 2 | 1;
		System.out.println(a);

		BinaryTree unbal = new BinaryTree(7);
		unbal.add(5);
		unbal.add(4);
		unbal.add(3);

		BinaryTree bal = new BinaryTree(8);
		bal.add(4);
		bal.add(12);

		System.out.println(isBalanced(unbal.getRoot()));
		System.out.println(isBalanced(bal.getRoot()));

	}

	static boolean isBalanced(Node root) {
		if (getHeight(root) != -1) {
			return true;
		}
		return false;
	}

	static int getHeight(Node node) {
		if (node == null) {
			return 0;
		}

		int heightLeft = getHeight(node.left);
		if (heightLeft == -1) {
			return -1;
		}

		int heightRight = getHeight(node.right);
		if (heightRight == -1) {
			return -1;
		}

		if (Math.abs(heightLeft - heightRight) > 1) {
			return -1;
		}

		return Math.max(heightLeft, heightRight) + 1;
	}

}
