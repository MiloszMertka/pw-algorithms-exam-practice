public class HeapSort {

	public static void heapSort(double[] nums) {
		Heap heap = new Heap();

		for (int i = 0; i < nums.length; i++) {
			heap.put(nums[i]);
		}

		while (heap.size() > 0) {
			nums[heap.size() - 1] = heap.pop();
		}
	}

	private static class Heap {
		public void put(double value) {
		}

		public double pop() {
			return 0.0;
		}

		public int size() {
			return 0;
		}
	}
}
