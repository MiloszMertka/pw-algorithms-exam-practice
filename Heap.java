import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Heap {
	List<Comparable> values = new ArrayList<>();

	public void put(Comparable value) {
		values.add(value);
		heapUp(values.size() - 1);
	}

	public Comparable pop() {
		if (values.size() == 0) {
			return null;
		}

		Collections.swap(values, 0, values.size() - 1);
		Comparable value = values.remove(values.size() - 1);

		heapDown(0);

		return value;
	}

	private void heapUp(int nodeIndex) {
		int parentIndex = (nodeIndex - 1) / 2;

		if (nodeIndex == 0 || values.get(nodeIndex).compareTo(values.get(parentIndex)) <= 0) {
			return;
		}

		Collections.swap(values, nodeIndex, parentIndex);

		heapUp(parentIndex);
	}

	private void heapDown(int nodeIndex) {
		int leftChildIndex = 2 * nodeIndex + 1;
		int rightChildIndex = 2 * nodeIndex + 2;

		Comparable parent = values.get(nodeIndex);
		Comparable leftChild = values.get(leftChildIndex);
		Comparable rightChild = values.get(rightChildIndex);

		int greaterChildIndex = getGreaterChildIndex(leftChildIndex, rightChildIndex);

		if ((leftChild == null && rightChild == null) || parent.compareTo(values.get(greaterChildIndex)) >= 0) {
			return;
		}

		Collections.swap(values, nodeIndex, greaterChildIndex);

		heapDown(greaterChildIndex);
	}

	private int getGreaterChildIndex(int leftChildIndex, int rightChildIndex) {
		if (leftChildIndex >= values.size()) {
			return rightChildIndex;
		}

		if (rightChildIndex >= values.size()) {
			return leftChildIndex;
		}

		return values.get(leftChildIndex).compareTo(values.get(rightChildIndex)) >= 0 ? leftChildIndex
				: rightChildIndex;
	}
}
