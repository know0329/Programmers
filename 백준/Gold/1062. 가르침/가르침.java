import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int result = 0;
    static boolean []  charArr;
    static int N, K;
    static List<String> list;

    // 선택한 알파벳으로 문자를 만들 수 있는지 판독
    static int isWord(){
        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = true;

            for (int j = 0; j < list.get(i).length(); j++) {
                // 만들 수 없는 문자가 있다면 카운터 제외
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

        
        if(count == K - 5){
            result = Math.max(result, isWord());
            return;
        }

        // charArr에 알파벳 선택해서 담기
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

        list = new ArrayList<>(); // 문자 배열
        charArr = new boolean[26]; // 알파벳 배열


        // 문자 담기
        for(int i = 0;  i < N; i++){
            stk = new StringTokenizer(br.readLine());
            String str = stk.nextToken();
            list.add(str);
        }

        // "anta"로 시작되고, "tica"로 끝나니까 최소 a, n, t, i, c  5개의 알파벳은 필요함
        if(K < 5){
            System.out.println(0);
        }
        else if(K == 26) System.out.println(N); // 26개면 알파벳 다 배울 수 있으니까 문자 다 만들 수 있음
        else{
            // 필수 5개
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
