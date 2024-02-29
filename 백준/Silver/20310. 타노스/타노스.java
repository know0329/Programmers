import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static String S ;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        S = stk.nextToken();
        int oneCount = 0;
        int zeroCount = 0;

        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '1'){
                oneCount ++;
            }
            else{
                zeroCount ++;
            }
        }
        oneCount = oneCount/2;
        zeroCount = zeroCount/2;
        String newS = S;
        for(int i = 0; i < newS.length(); i++){
            if(newS.charAt(i) == '1'){
                newS = newS.replaceFirst("1", "2");
                oneCount --;
            }
            if(oneCount == 0) break;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < newS.length(); i++){
            char s = newS.charAt(i);
            if(s != '2'){
                stack.push(s);
            }
        }
        String flipS = "";
        while(!stack.isEmpty()){
            flipS += stack.pop();
        }
        for(int i = flipS.length() -1; i >= 0; i--){
            if(flipS.charAt(i) == '0'){
                flipS = flipS.replaceFirst("0", "2");
                zeroCount --;
            }
            if(zeroCount == 0) break;
        }

        for(int i = 0; i < flipS.length(); i++){
            char s = flipS.charAt(i);
            if(s != '2'){
                stack.push(s);
            }
        }
        String flipS2 = "";
        while(!stack.isEmpty()){
            flipS2 += stack.pop();
        }



        for(int i = 0; i < flipS2.length(); i ++){
            if(flipS2.charAt(i) == '1' || flipS2.charAt(i) == '0'){
                System.out.print(flipS2.charAt(i));
            }
        }


    }
}
