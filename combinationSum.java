class Solution {
    List<List<Integer>> res;
    //int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        //this.target=target;
        check(candidates, 0, target, new ArrayList<>());
        return res;


    }
    void check(int []nums, int i, int target, ArrayList<Integer> arr){
        if (target==0){
            res.add(new ArrayList<>(arr));
            return ;
        }
        if(target<0 || i== nums.length) return ;
        arr.add(nums[i]);
        //target -= nums[i];
        check(nums, i, target-nums[i], arr);
        arr.remove(arr.size()-1);
       // target+= nums[i];
        check(nums, i+1, target, arr);
        

    }
}
