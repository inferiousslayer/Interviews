package com.binaryTrees;

import com.binaryTrees.BinaryTree.Node;

//Get the height of a binary tree
public class GetHeight {
	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree(7);
		bt.add(5);
		bt.add(10);
		bt.add(3);
		bt.add(2);
		bt.add(100);
		bt.add(4);
		bt.add(8);

		System.out.println(getHeight(bt.getRoot()));

		/* Tree looks like this:
		            7
		         5     10
		       3     8   100
		     2   4
		 */

	}

	static int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;

	}
}
