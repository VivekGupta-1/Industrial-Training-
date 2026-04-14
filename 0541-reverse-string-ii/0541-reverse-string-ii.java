class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            reverse(arr, i, Math.min(i + k - 1, arr.length - 1));
        }
        return new String(arr);
    }

    public void reverse(char[] s, int left, int right) {
        if (right < left) return;
        char c = s[left];
        s[left] = s[right];
        s[right] = c;

        reverse(s, left + 1, right - 1);
    }
}