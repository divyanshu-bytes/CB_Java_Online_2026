class Solution {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public void letterCombinationsRec(String digits, int idx, StringBuilder curAns, List<String> ans){
        if(idx == digits.length()){
            ans.add(curAns.toString());
            return;
        }

        char digitChar = digits.charAt(idx);    // '2','3','5'
        String str = mapping[digitChar - '0'];

        for(int i=0; i<str.length(); i++){
            curAns.append(str.charAt(i));
            letterCombinationsRec(digits, idx+1, curAns, ans);
            curAns.deleteCharAt(curAns.length()-1);     // Backtracking
        }
        return;
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder curAns = new StringBuilder();
        letterCombinationsRec(digits, 0, curAns, ans);
        return ans;
    }
}