class Solution {
    private int[] nextSmallerElementToTheRight(int[] arr){
		int n = arr.length;
		Stack<Integer> stk = new Stack<>();
		int[] nseRight = new int[n];

		for(int i=0; i<n; i++){
			while(!stk.isEmpty() && arr[i] < arr[stk.peek()]){
				nseRight[stk.peek()] = i;
				stk.pop();
			}
			stk.push(i);
		}

		while(!stk.isEmpty()){
			nseRight[stk.peek()] = n;
			stk.pop();
		}

		return nseRight;
	}

    private int[] nextSmallerElementToTheLeft(int[] arr){
		int n = arr.length;
		Stack<Integer> stk = new Stack<>();
		int[] nseLeft = new int[n];

		for(int i=n-1; i>=0; i--){
			while(!stk.isEmpty() && arr[i] < arr[stk.peek()]){
				nseLeft[stk.peek()] = i;
				stk.pop();
			}
			stk.push(i);
		}

		while(!stk.isEmpty()){
			nseLeft[stk.peek()] = -1;
			stk.pop();
		}

		return nseLeft;
	}

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nseRight = nextSmallerElementToTheRight(heights);
        int[] nseLeft = nextSmallerElementToTheLeft(heights);
        
        int maxArea = 0;
        for(int i=0; i<n; i++){
            int width = nseRight[i] - nseLeft[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}