package com.binaryTrees;

public class Test {
	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree(7);
		bt.add(5);
		bt.add(10);
		bt.add(3);
		bt.add(2);
		bt.add(100);
		bt.add(4);
		bt.add(8);

		/* Tree looks like this:
		            7
		         5     10
		       3     8   100
		     2   4
		 */
		System.out.println("Print tree by rows:");
		bt.printTreeByRows();
		System.out.print("\n");

		System.out.println("Print nodes in order:");
		bt.printInOrder();
		System.out.print("\n");

		System.out.println("Print the path to every leaf");
		bt.printPathToEveryLeaf();
		System.out.print("\n");

		System.out.println("Print the vertical sums");
		/*
		 Brief explanation:
		 Vertical sum @ 0 = 15 because the nodes containing 7 and 8 are both offset 0.
		 Vertical sum @ -1 = 9 because the nodes containing 5 and 4 are both offset -1.
		 */
		bt.printVerticalSums();
		System.out.print("\n");

		System.out.println("Print route to leaves.");
		bt.printRouteToLeaves();
		System.out.print("\n");

	}
}
