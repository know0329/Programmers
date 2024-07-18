import java.util.*;
import java.io.*;
public class Main {
    static boolean flag;
    static void sol(String s, String t, int start, int end){
        int count = 0;
        if(end > t.length()){
            end = t.length();
            for(int i = start; i < end; i++){
                if(t.charAt(i) != s.charAt(count++)) {
                    flag = false;
                    return;
                }
            }
            return;
        }


        for(int i = start; i < end; i++){
            if(t.charAt(i) != s.charAt(count++)) {
                flag = false;
                return;
            }
        }
        sol(s, t, start + s.length(), end + s.length());


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String s = stk.nextToken();
        stk = new StringTokenizer(br.readLine());
        String t = stk.nextToken();
        flag = true;
        if(t.length() > s.length()){
            sol(s, t+t, 0, s.length());
        }
        else{
            sol(t, s+s, 0, t.length());
        }
        if(flag) System.out.println(1);
        else System.out.println(0);

    }
}
