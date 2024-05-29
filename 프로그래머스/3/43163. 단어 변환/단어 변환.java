class Solution {
    
    static int result;
    static boolean [] used;
    static boolean check(String word, String target){
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != target.charAt(i)){
                count++;
                if(count >= 2){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    static void sol(String begin, String target, int count, String [] words){
        if(begin.equals(target)){
            result = Math.min(result, count);
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(check(begin, words[i])){
                if(!used[i]){
                    used[i] = true;
                    sol(words[i], target, count+1, words);
                    used[i] = false;
                }
            }
        }
        
    }
    
    public int solution(String begin, String target, String[] words) {
        result = Integer.MAX_VALUE;
        used = new boolean [words.length];
        sol(begin, target, 0, words);
        
        if(result == Integer.MAX_VALUE) return 0;
        else return result;
    }
}