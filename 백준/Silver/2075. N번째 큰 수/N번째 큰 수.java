import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int[] arr = new int[N*N];
        int idx =0;
        for(int i=0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++) {
                arr[idx++] = Integer.parseInt(stk.nextToken());
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[N*N - N]);

    }
}
