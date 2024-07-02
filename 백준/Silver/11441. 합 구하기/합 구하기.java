import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int [] A = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stk.nextToken());
        }
        int [] S = new int[N];
        S[0] = A[0];
        for(int i = 1; i < N; i++){
            S[i] = S[i-1] + A[i];
        }

        stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(stk.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            sb.append(S[e-1] - S[s-1] + A[s-1]).append("\n");
        }
        System.out.print(sb);
    }
}
