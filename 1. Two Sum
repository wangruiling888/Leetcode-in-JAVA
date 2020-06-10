// Brute Force: traverse each combination one by one and check if there's sum that equals to target
// BigO: O(n^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        for (int i = 0; i < nums.length -1; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
