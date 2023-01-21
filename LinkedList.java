public class LinkedList {

	private Node head;

	public void insertAtHead(Object data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	public void insertAtTail(Object data) {
		Node node = new Node(data);

		if (head == null) {
			head = node;
			return;
		}

		Node iterator = head;
		while (iterator.next != null) {
			iterator = iterator.next;
		}

		iterator.next = node;
	}

	public boolean find(Object data) {
		if (head == null) {
			return false;
		}

		Node iterator = head;
		while (iterator.next != null) {
			if (iterator.data.equals(data)) {
				return true;
			}

			iterator = iterator.next;
		}

		return false;
	}

	public void remove(Object data) {
		if (head == null) {
			return;
		}

		Node iterator = head;
		Node previous = null;
		while (iterator.next != null) {
			if (iterator.data.equals(data)) {
				if (previous != null) {
					previous.next = iterator.next;
				} else {
					head = null;
				}
			}

			previous = iterator;
			iterator = iterator.next;
		}
	}

	private static class Node {
		private Object data;
		private Node next;

		public Node(Object data) {
			this.data = data;
		}
	}
}
