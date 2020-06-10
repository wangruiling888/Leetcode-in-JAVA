// Given a set of candidate numbers (candidates) (without duplicates) and a target number (target)
// find all unique combinations in candidates where the candidate numbers sums to target.
// recursion and iteration
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
        helper(result, sub, target, 0, candidates);
        return result;
    }
    public static void helper(List<List<Integer>> result, List<Integer> sub, int sum, int index, int[] candidates){
        if (sum < 0) return;
        else if (sum == 0){
            result.add(new ArrayList<>(sub));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            sub.add(candidates[i]);
            helper(result, sub, sum-candidates[i], i, candidates);
            sub.remove(sub.size()-1);
        }
        return;
    }
}
