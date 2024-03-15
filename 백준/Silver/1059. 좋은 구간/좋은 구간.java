import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(stk.nextToken()); // 집합 S 크기, 50이하
        int [] S = new int[L]; // 중복 없음
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < L ; i++){
            S[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());

        Arrays.sort(S);
        int min = 0;
        int max = 1;
        int maxIndex = 0;
        for(int i = 0; i < L; i++){
            if(S[i] > n){
                maxIndex = i;
                max = S[i];
                break;
            }
        }
        if(maxIndex != 0){
            min = S[maxIndex-1];
        }


        int result = 0;
        for(int i = (min + 1); i <= n; i++) {
            for(int j = n; j < max; j++) {
                result++;
            }
        }
        if(result == 0) System.out.println(0);
        else System.out.println(result-1);




    }
}
