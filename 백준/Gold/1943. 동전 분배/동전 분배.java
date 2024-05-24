import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Coin implements Comparable<Coin>{
        int cost;
        int num;

        Coin(int cost, int num){
            this.cost = cost;
            this.num = num;
        }

        @Override
        public int compareTo(Coin o) {
            return o.cost - this.cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int t = 0; t < 3; t++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken()); // 동전 종류
            int sumOfCoin = 0;
            Coin [] coins = new Coin[N+1];
            boolean [] dp = new boolean[100001];
            dp[0] = true;
            for(int i = 1; i <= N; i++){
                stk = new StringTokenizer(br.readLine());
                int cost = Integer.parseInt(stk.nextToken());
                int num = Integer.parseInt(stk.nextToken());

                sumOfCoin += (cost * num);

                coins[i] = new Coin(cost, num);
                for(int j = 1; j <= num; j++) {
                    dp[cost * j] = true;  // 각 종류의 동전으로 만들 수 있는 액수 먼저 체크
                }
            }
            if(sumOfCoin % 2 == 1) {
                System.out.println(0);
                continue;
            }else if(dp[sumOfCoin / 2]) {
                System.out.println(1);
                continue;
            }
            for(int i = 1; i <= N; i++) {
                int v = coins[i].cost;
                int q = coins[i].num;

                for(int j = sumOfCoin/2; j >= v; j--) {
                    if(dp[j - v]) {
                        for(int k = 1; k <= q; k++) {
                            if(j - v + v * k > sumOfCoin/2) break;
                            dp[j - v + v * k] = true;
                        }
                    }
                }
            }
            System.out.println(dp[sumOfCoin / 2] ? 1 : 0);
        }
    }
}
