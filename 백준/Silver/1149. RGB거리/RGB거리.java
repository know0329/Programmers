import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()); // 집 수
        int [][] cost = new int [N+1][4];
        for(int i = 1; i <= N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <=3; j++){
                cost[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int [][] dp = new int[1001][4];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
        dp[1][3] = cost[1][3];
        for(int i = 2; i <= N; i++){
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + cost[i][2];
            dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][3];
        }
        System.out.println(Math.min(dp[N][1], Math.min(dp[N][2], dp[N][3])));
    }
}
