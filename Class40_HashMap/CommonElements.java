public class Solution {
    public int[] solve(int[] A, int[] B) {
        
        int minLen = Math.min(A.length, B.length);
        int[] ans = new int[minLen];
        
        int commonElmtsCount = 0;
        Map<Integer, Integer> freqMapA = new HashMap<>();
        
        for(int el: A){
            freqMapA.put(el, freqMapA.getOrDefault(el, 0) + 1);
        }
        
        for(int el: B){
            if(freqMapA.getOrDefault(el, 0) > 0){
                ans[commonElmtsCount] = el;
                commonElmtsCount++;
                freqMapA.put(el, freqMapA.get(el) - 1);
            }
        }
        
        int[] res = new int[commonElmtsCount];
        for(int i=0; i<commonElmtsCount; i++){
            res[i] = ans[i];
        }
        
        return res;
    }
}
