class Solution {

    public void generateParenthesesRec(int open, int close, StringBuilder curAns, List<String> ans){
        if(open == 0 && close == 0){
            ans.add(curAns.toString());
            return;
        }

        // open -> openAvailable
        // close -> closeAvailable
        if(open > 0){
            curAns.append('(');
            generateParenthesesRec(open-1, close, curAns, ans);
            curAns.deleteCharAt(curAns.length()-1);     // backtracking
        }

        if(close > open){
            curAns.append(')');
            generateParenthesesRec(open, close-1, curAns, ans);
            curAns.deleteCharAt(curAns.length()-1);     // backtracking
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder curAns = new StringBuilder();
        generateParenthesesRec(n, n, curAns, ans);
        return ans;
    }
}