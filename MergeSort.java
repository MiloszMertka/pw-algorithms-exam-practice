public class MergeSort {

	public static void mergeSort(double[] nums) {
		mergeSort(nums, 0, nums.length - 1);
	}

	private static void mergeSort(double[] nums, int start, int end) {
		if (start < end) {
			int middle = start + (end - start) / 2;

			mergeSort(nums, start, middle);
			mergeSort(nums, middle + 1, end);
			merge(nums, start, end);
		}
	}

	private static void merge(double[] nums, int left, int right) {
		int middle = left + (right - left) / 2;
		int leftSize = middle - left + 1;
		int rightSize = right - middle;
		double[] leftArray = new double[leftSize];
		double[] rightArray = new double[rightSize];

		for (int i = 0; i < leftSize; i++) {
			leftArray[i] = nums[left + i];
		}

		for (int i = 0; i < rightSize; i++) {
			rightArray[i] = nums[middle + i + 1];
		}

		int i = 0;
		int j = 0;
		int k = left;

		while (i < leftSize && j < rightSize) {
			if (leftArray[i] <= rightArray[j]) {
				nums[k++] = leftArray[i++];
			} else {
				nums[k++] = rightArray[j++];
			}
		}

		while (i < leftSize) {
			nums[k++] = leftArray[i++];
		}

		while (j < rightSize) {
			nums[k++] = rightArray[j++];
		}
	}
}
