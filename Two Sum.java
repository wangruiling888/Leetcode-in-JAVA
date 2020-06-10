// method 1:
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
// method 2:
// Hashmap: average time complexity of insertion and search in hashMap are both O(1)
// BigO: O(n) cuz we just traverse nums once
// put: insert key-value pair into map
// get: get value by key from map
// remove: remove key-value pair from map and return value
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++){
            int differ = target - nums[i];
            if (numsMap.containsKey(differ)){
                result[0] = numsMap.get(differ);
                result[1] = i;
                return result;
            }
            numsMap.put(nums[i], i);
        }
        return result;
    }
}
