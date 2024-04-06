import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [] belt;
    static boolean [] robots;

    static int level;


    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        level = 0;
        robots =  new boolean[N];
        belt = new int[N * 2];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(stk.nextToken());
        }
        while(true) {
            level++;

            // 1단계
            int tmp = belt[N*2-1];
            for (int i = N*2-1; i > 0; i--) {
                belt[i] = belt[i-1];
            }
            belt[0] = tmp;

            for (int i = N-1; i > 0; i--) {
                robots[i] = robots[i-1];
            }

            robots[0] = false;
            robots[N-1] = false;

            // 2단계
            for (int i = N-1; i > 0; i--) {
                if(robots[i-1] && !robots[i] && belt[i]>0) {
                    robots[i-1] = false;
                    robots[i] = true;
                    belt[i]--;
                    robots[N-1] = false;
                }
            }

            // 3단계
            if(belt[0]>0) {
                robots[0] = true;
                belt[0]--;
            }

            // 4단계
            int cnt = 0;
            for (int i = 0; i < N*2; i++) {
                if(belt[i] == 0) cnt++;
            }
            if(cnt>=K) break;

        }

        System.out.println(level);


    }
}
