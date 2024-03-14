import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 모든 곡은 리스트에 적힌 순서대로 연주해야 한다.
    // 마지막 곡을 연주할 수 있는 볼륨 중 최댓값은?



    static int result;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()); // 곡 개수
        int S = Integer.parseInt(stk.nextToken()); // 시작 볼륨
        int M = Integer.parseInt(stk.nextToken()); // 최대 볼륨 값
        result = -1;
        int [] diff = new int [N];
        int [] dp = new int [M+1];
        
        for (int i = 0; i <= M; i++) {
            dp[i] = -1;
        }
        
        dp[S] = 0;
        
        stk = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
           diff[i] = Integer.parseInt(stk.nextToken());
        }
        
        for(int i = 1; i <= N; i++) {
            List<Integer> changer = new ArrayList<>();
            for(int j=0; j<M+1; j++){
                if(dp[j]==i-1){
                    int minus = j-diff[i-1];
                    int plus = j+diff[i-1];

                    if(minus>=0){
                        changer.add(minus);
                    }
                    if(plus<=M){
                        changer.add(plus);
                    }
                }
            }
            for(int k : changer) dp[k] = i;
        }
        for(int i=0; i<M+1; i++){
            if(dp[i]==N) result = Math.max(result, i);
        }
        System.out.println(result);

    }
}
