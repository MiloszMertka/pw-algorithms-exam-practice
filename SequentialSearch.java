public class SequentialSearch {

	public static int sequentialSearch(double[] nums, double value) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == value) {
				return i;
			}
		}

		return -1;
	}
}