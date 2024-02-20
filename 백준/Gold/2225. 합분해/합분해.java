import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        long [][] dp = new long [201][201];

        Arrays.fill(dp[1], 1);

        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }
        for(int k = 2 ; k <= K ; k++){
            for(int n = 1; n <= N; n++){
                dp[k][n] = (dp[k-1][n] + dp[k][n-1]) % 1000000000;
            }
        }

        System.out.println(dp[K][N] );



    }
}
