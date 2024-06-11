class Solution {
    public long solution(int[] sequence) {
        int p = 1, m = -1;
        long pSum = sequence[0], mSum = sequence[0] * -1, pMin = 0, mMin = 0, max = Long.MIN_VALUE;
        
        for (int i = 1; i <= sequence.length; i++) {
            p *= -1;
            m *= -1;
            
            max = Math.max(max, pSum - pMin);
            max = Math.max(max, mSum - mMin);
            
            pMin = Math.min(pMin, pSum);
            mMin = Math.min(mMin, mSum);
            
            if (i == sequence.length) break;
            
            pSum += sequence[i] * p;
            mSum += sequence[i] * m;
        }
        
        return max;
    }
}