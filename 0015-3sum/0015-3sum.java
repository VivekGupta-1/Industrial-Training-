class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    int n = nums.length;
    int i = 0;

    while (i < n) {
        while (i > 0 && i < n && nums[i] == nums[i - 1]) {
            i++;
        }

        int j = i + 1;
        int k = n - 1;

        while (j < k) {
            int total = nums[i] + nums[j] + nums[k];

            if (total == 0) {
                List<Integer> trip = new ArrayList<>();
                trip.add(nums[i]);
                trip.add(nums[j]);
                trip.add(nums[k]);
                ans.add(trip);

                j++;
                while (j < k && nums[j] == nums[j - 1]) {
                    j++;
                }
            } else if (total < 0) {
                j++;
            } else {
                k--;
            }
        }
        i++;
    }
    return ans;
    }
}