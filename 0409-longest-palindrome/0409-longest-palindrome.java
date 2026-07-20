class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                len += 2;
            } else {
                set.add(ch);
            }
        }
        if (!set.isEmpty()) {
            len++;
        }
        return len;
    }
}