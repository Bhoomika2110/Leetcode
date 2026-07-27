class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        generate(0, nums, new ArrayList<>());

        return ans;
    }

    private void generate(int start, int[] nums, List<Integer> curr) {
        ans.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {

            curr.add(nums[i]);

            generate(i + 1, nums, curr);

            curr.remove(curr.size() - 1);
        }

    }
}