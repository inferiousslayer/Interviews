package com.linkedlist;

public class Test {
	public static void main(String args[]) {
		LinkedList ll = new LinkedList(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);

		System.out.print("The list is: ");
		ll.printList();

		System.out.print("Inserting 777 after index 3 in the list: ");
		ll.insertNode(3, 777);
		ll.printList();

		System.out.print("The list reversed is: ");
		ll.reverse();
		ll.printList();

		System.out.print("Removing the index 1 element from the list: ");
		ll.deleteNode(0);
		ll.printList();
		//ll.insertNode(2,7002340);

	}
}
