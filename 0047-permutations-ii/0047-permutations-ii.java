class Solution {
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, new ArrayList<>());

        return new ArrayList<>(set);
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> curr) {
        if (curr.size() == nums.length) {
            set.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i])
                continue;

            visited[i] = true;
            curr.add(nums[i]);

            backtrack(nums, visited, curr);

            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}