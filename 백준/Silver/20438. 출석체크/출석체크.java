
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [] attendance ;

    // 각 구간에 대해서 출석이 되지 않은 학생들의 수를 출력하라.

    // (1 ≤ K, Q ≤ N ≤ 5,000, 1 ≤ M ≤ 50,000)
    static int N, K, Q, M, S, E ;

    static List<Integer> sleepers;

    static List<Integer> coders;



    static void sol(int s, int e){
        System.out.println(attendance[e] - attendance[s-1]);

    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken()); // 3번부터 N + 2번
        K = Integer.parseInt(stk.nextToken()); // 조는 사람
        Q = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        sleepers = new ArrayList<>();
        coders = new ArrayList<>();
        attendance = new int [N+3];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            sleepers.add(Integer.parseInt(stk.nextToken()));
        }

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++){
            coders.add(Integer.parseInt(stk.nextToken()));
        }

        for(int i = 3; i <= N+2; i++){
            boolean flag = false;
            for(int coder : coders){
                if(sleepers.contains(coder)) continue;
                if(sleepers.contains(i)) continue;
                if(i % coder != 0) continue;
                flag = true;
                break;

            }

            if(flag){
                attendance[i] = attendance[i-1];
            }
            else{
                attendance[i] = attendance[i-1] + 1;
            }


        }

        for(int t = 0; t < M; t++){
            stk = new StringTokenizer(br.readLine());
            S = Integer.parseInt(stk.nextToken()); // 3 이상
            E = Integer.parseInt(stk.nextToken()); // N+2 이하
            sol(S, E);
        }



    }
}
