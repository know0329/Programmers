import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] num;
    static int [] cnt = new int[100000 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());

        num = new int[N+1];

        stk = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            num[i] = Integer.parseInt(stk.nextToken());
        }
        long result = 0L;
        int l = 1;
        int r = 0;
        while(l <= N){
          
            while(r + 1 <= N && cnt[num[r + 1]] == 0){
                r++; 
                cnt[num[r]]++; 
            }

            result += r - l + 1;
            
            cnt[num[l++]]--;
        }
        System.out.println(result);
    }
}
