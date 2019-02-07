package co.grandcircus.lists;

public class MyLinkedList implements MyList {



	// head is the first node in the list. if null, the list is empty.

	private Node head = null;

	// for convenience, keep track of how many items are in the list

	private int length = 0;

	

	@Override

	public void addAtBeginning(String data) {

		// add a new node and set it as the new head

		// TODO #1
		Node node = new Node(data);
		node.setNext(head);
		head = node;
		length++;
		

	}

	

	@Override

	public void removeFromBeginning() {

		// find the second node and set it as the new head

		// TODO #4
		if(length == 0) {
			return;
		}
		
		head = head.getNext();
		length--;

	}

	

	@Override

	public void addAtEnd(String data) {

		// TODO Exercise
		Node node = head;
		Node newNode = new Node(data);
		while (node.getNext() != null) {
			node = node.getNext();
		}
		node.setNext(newNode);
		length++;
	}

	

	@Override

	public void removeFromEnd() {

		if (length < 2) {

			// The beginning is the end.

			removeFromBeginning();

		} else {

			// TODO #5
			Node node = getNodeAt(length - 2);
			node.setNext(null);
			length--;

		}

	}

	

	@Override

	public String get(int index) {

		// TODO #3
		Node node = getNodeAt(index);
		if(node == null) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return node.getData();
		}
	}

	

	public String toString() {

		StringBuilder sb = new StringBuilder();

		// start at the head

		Node node = head;

		// follow the links between nodes until it reaches the end 

		while (node != null) {

			// TODO #2
			sb.append(node);
			node = node.getNext();
		}

		return sb.toString();

	}

	

	@Override

	public int size() {

		return length;

	}

	

	private Node getNodeAt(int index) {

		// start at the head

		Node node = head;

		// follow the links between nodes until it counts off the right number

		for (int i = 0; i < index; i++) {

			if (node == null) {

				// In case we run out of nodes before we get up to the desired index, return null

				return null;

			}

			node = node.getNext();

		}

		return node;

	}
	
	public boolean removeAt(int index) {
		Node node = head;
		Node tempPrev = null;
		Node tempNext = null;
		if((index + 1) > length) {
			return false;
		}
		else {
			for (int i = 0; i < index; i++) {
					
				}
			tempPrev = node.getNext();
				if(tempPrev.getNext() != null) {
					node = tempPrev.getNext();
					tempNext = node.getNext();
				}
				tempPrev.setNext(tempNext);
				node = tempPrev;
				length--;
				return true;
			}
		}
	
	public boolean insertAt(String value, int index) {
		Node node = head;
		Node newNode = new Node(value);
		
		if(index == 0) {
			addAtBeginning(value);
		}
		for (int i = 0; i < index-1; i++) {
			if (node == null) {
				// In case we run out of nodes before we get up to the desired index, return null
				return false;
			}
			node = node.getNext();
		}
			if(node.getNext() != null) {
				Node temp = node.getNext();
				newNode.setNext(temp);
				node.setNext(newNode);
			}
			else {
				node.setNext(newNode);
				newNode.setNext(null);
			}
			length++;
			return true;
		}
}