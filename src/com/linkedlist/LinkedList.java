package com.linkedlist;

public class LinkedList {
	Node head;
	private int size = 0;

	public LinkedList(int headValue) {
		head = new Node(headValue);
		size++;
	}

	public int size() {
		return size;
	}

	// Append data to the end of the list.
	public void add(int data) {
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
		size++;
	}

	//Insert a node after the specified index
	public void insertNode(int index, int data) {
		if (index > size - 1 || index < 0) {
			System.out.println("Index exceeds bounds!");
			return;
		}
		Node current = getNodeAt(index);
		Node temp = current.next;
		Node newNode = new Node(data);
		current.next = newNode;
		newNode.next = temp;
		size++;
	}

	//Delete the node at the specified index
	public void deleteNode(int index) {
		Node current = head;
		int currentIndex = 0;
		if (index > size - 1 || index < 0) {
			System.out.println("Can't delete, Linked List bounds exceeded!");
			return;
		}

		if (index == 0) {
			head = current.next;
			size--;
			return;
		}

		while (currentIndex < index - 1) { //We want to get to the node before the one we want to delete.
			current = current.next;
			currentIndex++;
		}
		current.next = current.next.next;

		size--;
	}

	//Get the node at the specified index.
	private Node getNodeAt(int index) {
		int currentIndex = 0;
		Node current = head;

		if (index < 0 || index > size - 1) {
			System.out.println("Index exceeds bounds!");
			return null;
		}

		//Navigate to the node we want to insert after.
		while (currentIndex != index) {
			current = current.next;
			currentIndex++;
		}
		return current;
	}

	//Reverse the linked list
	public void reverse() {
		if (size <= 1) {
			return;
		}

		Node current = head;
		Node next;
		Node previous = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}

	// Print the linked list
	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print("\n");
	}

	class Node {
		public int data;
		public Node next = null;

		public Node(int data) {
			this.data = data;
		}

	}
}
