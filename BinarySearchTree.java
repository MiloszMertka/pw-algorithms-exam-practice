public class BinarySearchTree {

	private Node root;

	public boolean find(Comparable data) {
		if (root == null) {
			return false;
		}

		Node iterator = root;
		while (iterator != null) {
			if (iterator.data.equals(data)) {
				return true;
			}

			if (data.compareTo(iterator.data) < 0) {
				iterator = iterator.leftChild;
			} else {
				iterator = iterator.rightChild;
			}
		}

		return false;
	}

	public void insert(Comparable data) {
		Node node = new Node(data);

		if (root == null) {
			root = node;
			return;
		}

		insert(root, data);
	}

	private void insert(Node node, Comparable data) {
		if (node.data.equals(data)) {
			return;
		}

		if (node.data.compareTo(data) < 0) {
			if (node.leftChild != null) {
				insert(node.leftChild, data);
			} else {
				node.leftChild = new Node(data);
			}
		} else {
			if (node.rightChild != null) {
				insert(node.rightChild, data);
			} else {
				node.rightChild = new Node(data);
			}
		}
	}

	public void remove(Comparable data) {
		root = remove(root, data);
	}

	private Node remove(Node node, Comparable data) {
		if (root == null) {
			return null;
		}

		if (data.compareTo(node.data) < 0) {
			node.leftChild = remove(node.leftChild, data);
		} else if (data.compareTo(node.data) > 0) {
			node.rightChild = remove(node.rightChild, data);
		} else {
			if (node.leftChild == null) {
				return node.rightChild;
			}

			if (node.rightChild == null) {
				return node.leftChild;
			}

			Node smallestNode = getSmallestNode(node);
			node.data = smallestNode.data;
			node.rightChild = remove(node.rightChild, smallestNode.data);
		}

		return node;
	}

	private Node getSmallestNode(Node node) {
		Node iterator = node;
		while (iterator.leftChild != null) {
			iterator = iterator.leftChild;
		}

		return iterator;
	}

	private static class Node {
		private Comparable data;
		private Node leftChild;
		private Node rightChild;

		public Node(Comparable data) {
			this.data = data;
		}
	}
}
