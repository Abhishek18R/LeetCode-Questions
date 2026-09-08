class Solution {
    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        // Array already sorted
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // mid is the minimum
            if (mid != 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // mid + 1 is the minimum
            else if (mid != nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Left part is sorted
            else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            }

            // Right part is sorted
            else {
                end = mid - 1;
            }
        }

        return -1;
    }
}