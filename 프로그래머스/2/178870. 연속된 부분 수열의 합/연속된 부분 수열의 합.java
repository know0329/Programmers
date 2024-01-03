class Solution {
    public int[] solution(int[] sequence, int k) {
   
        int start = 0, end = sequence.length;
        int sum = 0;
        for(int i = 0, j = 0; i < sequence.length; i++) {
            while(j < sequence.length && sum < k) {
                sum += sequence[j++];
            }
            
            if(sum == k) {
                if(end - start > j - i - 1) {
                    start = i;
                    end = j - 1;
                }
            }
            
            sum -= sequence[i];
        }
        
        int[] answer = {start, end};
        return answer;
    }
}