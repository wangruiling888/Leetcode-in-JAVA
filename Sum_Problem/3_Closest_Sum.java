// Find three num from the specified array whose sum is closest to target
// same but easier than 3-sum 
// big O: O(n^2)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // assume that we only have one solution
        int min_differ = Integer.MAX_VALUE;
        int min_sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            int temp = nums[i];
            int start = i+1;
            int end = nums.length - 1;
            while(start < end){
                int differ = nums[start] + nums[end] + temp - target;
                if (differ > 0){ // so large may be we can get smaller & closer
                    if (min_differ > differ){
                        min_differ = differ;
                        min_sum = nums[start] + nums[end] + temp;
                    }
                    end --;
                }
                else{ // so small may be we can make it large to get closer
                    differ *= (-1);
                    if (min_differ > differ){
                        min_differ = differ;
                        min_sum = nums[start] + nums[end] + temp;
                    }
                    start ++;
                }
                
            }
        }
        return min_sum;     
    }
}
