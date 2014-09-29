package com.binaryTrees;

import com.binaryTrees.BinaryTree.Node;

//Get the lowest common ancestor of two nodes.
public class LCA {

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree(7);
		bt.add(5);
		bt.add(10);
		bt.add(3);
		bt.add(2);
		bt.add(100);
		bt.add(4);
		bt.add(8);

		Node a = bt.getRoot().left.left.right; // 4
		Node b = bt.getRoot().left.left.left; // 2

		Node result = getLCA(bt.getRoot(), a, b);
		System.out.println(result.data);

		/* Tree looks like this:
		            7
		         5     10
		       3     8   100
		     2   4
		 */

	}

	public static Node getLCA(Node node, Node a, Node b) {
		if (node == a || node == b) {
			return node;
		}

		if (node.data > a.data && node.data > b.data) {
			return getLCA(node.left, a, b);
		}

		if (node.data < a.data && node.data < b.data) {
			return getLCA(node.right, a, b);
		}

		return node;

	}
}
