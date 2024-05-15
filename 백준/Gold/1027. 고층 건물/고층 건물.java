import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, result;
    static int [] building;


    public static int Count(int idx) {
        int cnt = 0;
        double tmp = 0;

        // 왼쪽
        for (int i=idx-1; i>=0; i--) {
            double slope = (double) (building[idx] - building[i]) / (idx - i);

            if (i == idx-1 || tmp > slope) {
                cnt++;
                tmp = slope;
            }
        }

        // 오른쪽
        for (int i=idx+1; i<N; i++) {
            double slope = (double) (building[idx] - building[i]) / (idx - i);

            if (i == idx+1 || tmp < slope) {
                cnt++;
                tmp = slope;
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        building = new int[N];
        for(int i = 0; i < N; i++){
            building[i] = Integer.parseInt(stk.nextToken());
        }
        for(int i = 0; i < N; i++){
            result = Math.max(Count(i), result);
        }

        System.out.println(result);
    }
}
