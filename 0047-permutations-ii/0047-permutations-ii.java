class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
         Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, new ArrayList<>());

        return ans;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> curr) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i])
                continue;

            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1])
                 continue;    

            visited[i] = true;
            curr.add(nums[i]);

            backtrack(nums, visited, curr);

            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}