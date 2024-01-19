class Solution {
    public int[] solution(String s) {
        
        
        int zeroCount = 0;
        int transformCount = 0;
        
        while(s.length() > 1){
            transformCount +=1;
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    count ++;
                }
            }
            zeroCount += count;
            String newS = "";
            for(int i = 0; i < s.length() - count ; i++){
                 newS += "1";
            }
            s = Integer.toString(newS.length(), 2);
            
        }
        int[] answer = new int[] {transformCount, zeroCount};
        return answer;
    }
}