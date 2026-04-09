class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), n, 0, 0);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder temp, int n, int open, int close) {

        if (temp.length() == 2 * n) {
            ans.add(temp.toString());
            return;
        }
        if (open < n) {
            temp.append('(');
            backtrack(ans, temp, n, open + 1, close);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (close < open) {
            temp.append(')');
            backtrack(ans, temp, n, open, close + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}