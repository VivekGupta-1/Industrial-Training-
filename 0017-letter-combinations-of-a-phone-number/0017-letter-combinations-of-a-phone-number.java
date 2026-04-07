class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        String[] map = {"", "", "abc", "def", "ghi", "jkl","mno", "pqrs", "tuv", "wxyz"};

        backtrack(result, new StringBuilder(), digits, map);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder temp, String digits, String[] map) {

        if (temp.length() == digits.length()) {
            result.add(temp.toString());
            return;
        }

        int index = temp.length();
        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            temp.append(letters.charAt(i));

            backtrack(result, temp, digits, map);

            temp.deleteCharAt(temp.length() - 1);
        }
    }
}