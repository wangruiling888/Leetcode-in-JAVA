// use one fixed number and two pointer
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        // condition that is not able to find three sum
        int length = nums.length;
        if (length == 0|| nums[0] > 0 || nums[length -1] < 0) return result;
        for (int i = 0; i < length; i++){
            // get the fixed temp 
            int temp = nums[i];
            // get two pointer to find two sum
            int start = i+1;
            int end = length - 1;
            if (i>0  && nums[i] == nums[i-1]) continue;
            while (start < end){
                if (nums[start] + nums[end] == -temp){
                    if (start == i+1 || end == length-1){
                        List<Integer> sub_result = new ArrayList<Integer>();
                        sub_result.add(temp);
                        sub_result.add(nums[start]);
                        sub_result.add(nums[end]);
                        result.add(sub_result);
                        start ++;
                        end --;
                    }
                    // remove duplicate: if next number is same as current one
                    // we do not need to compute it again to avoid duplication
                    else if (nums[start] == nums[start -1]) start ++;
                    else if (nums[end] == nums[end + 1]) end --;
                    else{
                        List<Integer> sub_result = new ArrayList<Integer>();
                        sub_result.add(temp);
                        sub_result.add(nums[start]);
                        sub_result.add(nums[end]);
                        result.add(sub_result);
                        start ++;
                        end --;
                    }
                    
                }
                // if two sum is too small, make it larger
                else if (nums[start] + nums[end] < -temp) start ++;
                else end--;
            }
        }
        return result;
    }
}
