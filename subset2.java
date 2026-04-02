class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Step 1: sort
        check(nums, 0, new ArrayList<>(), res);
        return res;
    }

    void check(int[] nums, int i, ArrayList<Integer> arr, List<List<Integer>> res) {
        res.add(new ArrayList<>(arr)); 

        for (int j = i; j < nums.length; j++) {
            
            if (j > i && nums[j] == nums[j - 1]) continue;

            arr.add(nums[j]);
            check(nums, j + 1, arr, res);
            arr.remove(arr.size() - 1);
        }
    }
}
