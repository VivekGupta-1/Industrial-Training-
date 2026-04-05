class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int ist =1;
        int second =2;
        for (int i=3 ;i<=n;i++){
            int third = ist +second;
            ist = second;
            second = third;
        }
        return second;
        }
}
