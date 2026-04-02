class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        check(nums, 0, new ArrayList<>(), res);
        return res;
        

    }
    void check(int []nums, int i, ArrayList<Integer> arr, List<List<Integer>> res){
        if (i==nums.length){
            res.add(new ArrayList<>(arr));
            return ;
        }
        arr.add(nums[i]);
        check(nums, i+1, arr, res);
        arr.remove(arr.size()-1);
        check(nums, i+1, arr, res);
    }
}
