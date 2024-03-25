import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int [] num = new int[N];
        int [] sum = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(stk.nextToken());
        }
        sum[0] = num[0];
        for(int i = 1; i < N; i++){
            sum[i] = sum[i-1] + num[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            sb.append(sum[b-1] - sum[a-1] + num[a-1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
