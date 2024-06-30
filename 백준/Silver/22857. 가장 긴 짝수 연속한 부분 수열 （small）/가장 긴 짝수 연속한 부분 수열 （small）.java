import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        int [] S = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            S[i] = Integer.parseInt(stk.nextToken());
        }
        int i = 0;
        int j = 0;
        int result = 0;
        int oddNum = 0;
        while(j < N){

          if(oddNum < K){
              if(S[j] % 2 == 1) oddNum++; // 홀수, 지울 수 있음
                j++;
                result = Math.max(result, j - i - oddNum);
          }
          else if(S[j] % 2 == 0){ // 짝수
              j++;
              result = Math.max(result, j - i - oddNum);
          }
          else{ // 홀수, 지울 수 없음
              if(S[i] % 2 == 1) oddNum --; // 첫 숫자가 홀수면 이동하면서 숫자가 바뀌니까 하나제거
              i++;
          }

        }
        System.out.println(result);
    }
}
