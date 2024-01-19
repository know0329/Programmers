import java.util.*;
class Solution {
 
    static int Compress(String str, int size){
        List <String> subStrList = new ArrayList<>();
        int length = str.length();
        StringBuilder compressStr = new StringBuilder();
   
        for(int i = 0; i < length; i+=size){
            int next = i+size;
            if(next > length){
                next = length;
            }
            subStrList.add(str.substring(i, next));
        }
        String lastStr = "";
        int count = 1;
        for(String subStr : subStrList){
            
            if(subStr.equals(lastStr)){
                count++;
            }
            else{
                if(count > 1){
                    compressStr.append(count);
                }
                compressStr.append(lastStr);

                lastStr = subStr;
                count = 1;
            }
        }
        
        if(count > 1){
            compressStr.append(count);
        }
        compressStr.append(lastStr);
            
        
    
        return compressStr.toString().length();
        
    }
    
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length()/2; i++){
           answer = Math.min(answer, Compress(s, i));
        }
 
        
        return answer;
    }
}