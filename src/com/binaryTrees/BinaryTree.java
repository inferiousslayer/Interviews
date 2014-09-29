package com.binaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTree {
	Node root;

	public BinaryTree(int data) {
		root = new Node(data);
	}

	Node getRoot() {
		return root;
	}

	public void add(int data) {
		Node current = root;
		while (true) {
			if (data > current.data) {
				if (current.right == null) {
					current.right = new Node(data);
					return;
				} else {
					current = current.right;
				}
			}

			if (data < current.data) {
				if (current.left == null) {
					current.left = new Node(data);
					return;
				} else {
					current = current.left;
				}
			}

		}
	}

	public void printTreeByRows() {
		List<Node> treeQ = new ArrayList<Node>();
		treeQ.add(root);
		treeQ.add(null);

		while (!treeQ.isEmpty()) {
			Node current = treeQ.remove(0);
			if (current == null) {
				if (!treeQ.isEmpty()) {
					treeQ.add(null);
				}
				System.out.print("\n");
				continue;
			} else {
				System.out.print(current.data + " ");
			}

			if (current.left != null) {
				treeQ.add(current.left);
			}
			if (current.right != null) {
				treeQ.add(current.right);
			}
		}
	}

	//A vertical sum is the sum of all the nodes that are the same offset from the root.
	//For example, the root's left child's right child (-1 + 1 = 0) and the root's right child's left child (+1 + -1 = 0) are in the same vertical.
	public void printVerticalSums() {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		traverseVerticalSums(root, 0, hm);
		System.out.println(hm);
	}

	void traverseVerticalSums(Node current, int offset, HashMap<Integer, Integer> hm) {
		if (current == null) {
			return;
		}
		int val = 0;
		if (hm.containsKey(offset)) {
			val = hm.get(offset);
		}
		hm.put(offset, val + current.data);

		traverseVerticalSums(current.left, offset - 1, hm);
		traverseVerticalSums(current.right, offset + 1, hm);
	}

	public void printPathToEveryLeaf() {
		getPath(root, "");
	}

	private void getPath(Node current, String path) {
		if (current.left == null && current.right == null) { //It's a leaf.  Print the path to it.
			System.out.println(path + " " + current.data);
		}
		if (current.left != null) {
			getPath(current.left, path + " " + current.data);
		}
		if (current.right != null) {
			getPath(current.right, path + " " + current.data);
		}

	}

	public void printInOrder() {
		traverse(root);
		System.out.print("\n");
	}

	private void traverse(Node node) {
		if (node == null) {
			return;
		}

		//When you do an in-order traversal you visit Left then Middle (itself) then Right.  Only print when it visits itself.

		traverse(node.left); //Left
		System.out.print(node.data + " "); //Middle
		traverse(node.right); //Right

	}

	public void printRouteToLeaves() {
		traverseToLeaf(root, "");
	}

	public void traverseToLeaf(Node node, String path) {
		if (node == null) {
			return;
		}
		path += " " + node.data;

		if (node.left == null && node.right == null) {
			System.out.println(path);
			return;
		}
		traverseToLeaf(node.left, path);
		traverseToLeaf(node.right, path);
	}

	class Node {
		public int data;
		Node left = null;
		Node right = null;

		public Node(int data) {
			this.data = data;
		}

	}
}
