class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] nge = new int[n];
        
        for(int i=0; i<n; i++){
            if(stk.isEmpty()){
                stk.push(i);
                continue;
            }
            
            while(!stk.isEmpty() && arr[i] > arr[stk.peek()]){
                nge[stk.peek()] = arr[i];
                stk.pop();
            }
            stk.push(i);
        }
        
        while(!stk.isEmpty()){
            nge[stk.peek()] = -1;
            stk.pop();
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            ans.add(nge[i]);
        }
        
        return ans;
    }
}