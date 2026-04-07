class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(ans, new ArrayList<>(), nums, visited);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;

            visited[i] = true;
            temp.add(nums[i]);
            backtrack(ans, temp, nums, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}