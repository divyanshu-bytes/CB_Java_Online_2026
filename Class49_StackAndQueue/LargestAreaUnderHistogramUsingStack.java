class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();     // index

        int n = heights.length;
        int maxArea = 0;
        for(int i=0; i<=n; i++){
            while(!stk.isEmpty() && (i == n || heights[i] < heights[stk.peek()])){
                int ht = heights[stk.pop()];
                int nseRight = i;

                int nseLeft;
                if(!stk.isEmpty()){
                    nseLeft = stk.peek();
                }
                else{
                    nseLeft = -1;
                }

                int width = nseRight - nseLeft - 1;

                maxArea = Math.max(maxArea, ht*width);
            }

            stk.push(i);
        }

        return maxArea;
    }
}