public class BinarySearch {

	public static int binarySearch(double[] nums, double value) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int middle = left + (right - left) / 2;

			if (nums[middle] == value) {
				return middle;
			} else if (nums[middle] < value) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}

		return -1;
	}
}
