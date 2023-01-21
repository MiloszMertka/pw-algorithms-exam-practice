public class QuickSort {

	public static void quickSort(double[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}

	private static void quickSort(double[] nums, int start, int end) {
		if (start < end) {
			int pivot = partition(nums, start, end);
			quickSort(nums, start, pivot - 1);
			quickSort(nums, pivot + 1, end);
		}
	}

	private static int partition(double[] nums, int start, int end) {
		int left = start + 1;
		int right = end;

		while (left < right) {
			while (left < right && nums[left] < nums[start]) {
				left++;
			}

			while (left < right && nums[right] >= nums[start]) {
				right--;
			}

			if (left < right) {
				swap(nums, left, right);
			}
		}

		if (nums[left] >= nums[start]) {
			left--;
		}

		swap(nums, left, start);

		return left;
	}

	private static void swap(double[] nums, int firstIndex, int secondIndex) {
		if (firstIndex != secondIndex) {
			double tmp = nums[firstIndex];
			nums[firstIndex] = nums[secondIndex];
			nums[secondIndex] = tmp;
		}
	}
}
