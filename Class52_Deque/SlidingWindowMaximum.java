class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> deq = new ArrayDeque<>();        // deq -> stores indices
        
        int ptr = 0;
        for(int i=0; i<n; i++){
            if(i >= k){
                ans[ptr++] = arr[deq.peekFirst()];
            }
            // remove old window elements from left side
            while(!deq.isEmpty() && deq.peekFirst() <= i-k){
                deq.removeFirst();
            }

            // add new element in window from right side
            while(!deq.isEmpty() && arr[deq.peekLast()] <= arr[i]){
                deq.removeLast();
            }
            deq.addLast(i);
        }

        ans[ptr++] = arr[deq.peekFirst()];

        return ans;
    }
}

/*
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> deq = new ArrayDeque<>();        // deq -> stores indices

        int i;
        for(i=0; i<k; i++){
            // add new element in window from right side
            while(!deq.isEmpty() && arr[deq.peekLast()] <= arr[i]){
                deq.removeLast();
            }
            deq.addLast(i);
        }
        int ptr = 0;
        for(i=k; i<n; i++){
            ans[ptr++] = arr[deq.peekFirst()];

            // remove old window elements from left side
            while(!deq.isEmpty() && deq.peekFirst() <= i-k){
                deq.removeFirst();
            }

            // add new element in window from right side
            while(!deq.isEmpty() && arr[deq.peekLast()] <= arr[i]){
                deq.removeLast();
            }
            deq.addLast(i);
        }

        ans[ptr++] = arr[deq.peekFirst()];

        return ans;
    }
}
*/