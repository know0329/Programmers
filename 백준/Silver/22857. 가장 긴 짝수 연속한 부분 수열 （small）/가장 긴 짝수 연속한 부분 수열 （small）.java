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
        int removeCount = K;
        while(i < N){
            if(j == N){
                result = Math.max(result, j - i  - K + removeCount);
                i++;
                j = i;
                removeCount = K;
                continue;
            }

            if(S[j] % 2 == 0){
                j++;
            }
            else if(S[j] % 2 == 1 && removeCount > 0){
                removeCount--;
                j++;
            }
            else if(S[j] % 2 == 1 && removeCount == 0){
                result = Math.max(result, j - i  - K + removeCount);
                i++;
                j = i;
                removeCount = K;
            }

        }
        System.out.println(result);
    }
}
