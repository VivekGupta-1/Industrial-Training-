class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10 == 0 && x != 0)){
            return false;
        }
        int rhalf = 0;
        while(x > rhalf){
            rhalf = rhalf*10 + x % 10;
            x/=10;
        }
        return x== rhalf || x== rhalf/10;
    }
}