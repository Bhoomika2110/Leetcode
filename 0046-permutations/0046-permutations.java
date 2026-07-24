class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList<>());
        return ans;
    }
        private void backtrack(int[] nums, boolean[] visited, List<Integer> curr) {
            if(curr.size() == nums.length){
                ans.add(new ArrayList<>(curr));
                return;
            }

            for(int i = 0; i<nums.length;i++){
                if(visited[i])
                   continue;

                   visited[i] = true;
                   curr.add(nums[i]);

                   backtrack(nums , visited ,curr);

                   curr.remove(curr.size() - 1);
                   visited[i] = false;
            }
        }

}