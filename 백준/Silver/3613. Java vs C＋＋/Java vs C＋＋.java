import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean isCpp(String s){
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && s.charAt(i) <= 'Z') return false;

        }
        return true;
    }

    static boolean isJava(String s){
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '_') return false;

        }
        return true;
    }
    static boolean isString(String s ){
        if(s.charAt(0) == '_' ||
                (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') ||
                s.charAt(s.length() - 1) == '_'
                 ) return false;

        for(int i = 0; i < s.length() - 1; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            if(c1 == '_' && c1 == c2) return false;
        }
        return true;
    }
    static String cppToJava(String s){
        String newStr = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                newStr += "_";
                newStr += Character.toString(c).toLowerCase();
            }
            else{
                newStr += Character.toString(c);
            }
        }
        return newStr;
    }

    static String javaToCpp(String s){
        String newStr = "";
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(flag){

                newStr += Character.toString(c).toUpperCase();
                flag = false;
                continue;
            }
            if(c == '_'){
                flag = true;
            }
            else{
                newStr += Character.toString(c);
            }

        }
        return newStr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String str = stk.nextToken();
        if((!isCpp(str) && !isJava(str)) ||
              !isString(str) ) System.out.println("Error!");
        else if(isCpp(str) && !isJava(str)) System.out.println(javaToCpp(str));
        else if(isCpp(str) && isJava(str)) System.out.println(str);
        else System.out.println(cppToJava(str));
    }

}
