class Solution {
    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int ele = Math.abs(nums[i]);

            if (nums[ele] > 0) {
                nums[ele] = -nums[ele];
            } else {
                return ele;
            }
        }

        return -1;
    }
}