
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int result = 0;
    static boolean []  charArr;
    static int N, K;
    static List<String> list;
    static int isWord(){
        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = true;

            for (int j = 0; j < list.get(i).length(); j++) {

                if (!charArr[list.get(i).charAt(j) - 'a']) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }
        return count;
    }

    static void sol(int alpha, int count){
        if(count == 26 ) return;

        if(count == K - 5){
            result = Math.max(result, isWord());
            return;
        }
        for (int i = alpha; i < 26; i++) {
            if (!charArr[i]) {
                charArr[i] = true;
                sol(i, count + 1);
                charArr[i] = false;
            }
        }


    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken()); // 50이하 자연수, 남극 최대 단어 수
        K = Integer.parseInt(stk.nextToken()); // 26이하 자연수, 글자 수

        list = new ArrayList<>();
        charArr = new boolean[26];


        for(int i = 0;  i < N; i++){
            stk = new StringTokenizer(br.readLine());
            String str = stk.nextToken();
            list.add(str);
        }


        if(K < 5){
            System.out.println(0);
        }
        else if(K == 26) System.out.println(N);
        else{
            charArr['a' - 'a'] = true;
            charArr['n' - 'a'] = true;
            charArr['t' - 'a'] = true;
            charArr['i' - 'a'] = true;
            charArr['c' - 'a'] = true;
            sol(0, 0);
            System.out.println(result);
        }

    }
}
