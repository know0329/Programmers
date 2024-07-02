import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result;
    static int sol(int i, int j, int K, int [][] sumOfBenefit, int [][] benefit){
        return sumOfBenefit[i][j] - sumOfBenefit[i-K][j] - sumOfBenefit[i][j-K] + sumOfBenefit[i-K][j-K];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int [][] benefit = new int[N][N];
        result = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int b =  Integer.parseInt(stk.nextToken());
                benefit[i][j] = b;
            }
        }
        int [][] sumOfBenefit = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                sumOfBenefit[i][j] = sumOfBenefit[i-1][j] + sumOfBenefit[i][j-1] - sumOfBenefit[i-1][j-1] + benefit[i-1][j-1];
            }
        }
        for(int k = 1; k <= N; k++){
            for(int i = k; i < N +1; i++){
                for(int j = k; j < N +1; j++){
                    result = Math.max(sol(i, j, k, sumOfBenefit, benefit), result);
                }
            }
        }
        System.out.println(result);

    }
}
