class Solution {
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);

    }

    public void reverse(char [] s, int left, int right){
        if(right<left) return;
        char c = s[left];
        s[left] = s[right];
        s[right] = c;

        reverse(s, left+1, right-1);
    }
}