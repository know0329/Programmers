class Solution {
    
    static boolean check(long k, int [] times, int n){
        long count = 0;
        for(int time : times){
            count += (k / time);
            if(count >= n){
                return true;
            }
        }
        return false;
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long low = 0;
        long high = times[times.length-1] * (long)n;
        
        while(low <= high){
            long mid = (low + high) / 2;
            if(check(mid, times, n)){
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }
        
        return low;
    }
}