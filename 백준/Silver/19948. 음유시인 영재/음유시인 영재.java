import java.io.*;
import java.util.*;

public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String content = br.readLine();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int countOfInputSpace = Integer.parseInt(stk.nextToken());

        int [] alpha = new int[26];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < 26; i++){
            alpha[i] = Integer.parseInt(stk.nextToken());
        }
        boolean flag = true;

        String title = "";
        title += content.charAt(0);
        alpha[Character.toLowerCase(content.charAt(0)) - 'a'] --;
        char prev = content.charAt(0);
        for(int i = 1; i < content.length(); i++){
            char ch = content.charAt(i);
            if(ch != prev){


                if(ch == ' '){
                    countOfInputSpace --;
                }
                else{
                    alpha[Character.toLowerCase(ch) - 'a'] --;
                    if(alpha[Character.toLowerCase(ch) - 'a'] < 0 ){
                        System.out.println(-1);
                        return;
                    }
                }
                if(countOfInputSpace < 0){
                    System.out.println(-1);
                    return;
                }
                if(prev == ' '){
                    title += ch;
                }
                prev = ch;
            }

        }
        for(int i = 0; i < title.length(); i++){
            char ch = title.charAt(i);
            alpha[Character.toLowerCase(ch) - 'a'] --;

            if(alpha[Character.toLowerCase(ch) - 'a'] < 0){
                System.out.println(-1);
                return;
            }

        }
        System.out.println(title.toUpperCase());

    }
}
