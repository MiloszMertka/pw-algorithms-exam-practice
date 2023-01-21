public class InsertionSort {

	public static void insertionSort(double[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int j = i - 1;
			double tmp = nums[i];

			while (j >= 0 && nums[j] > tmp) {
				nums[j + 1] = nums[j];
				j--;
			}

			nums[j + 1] = tmp;
		}
	}
}
