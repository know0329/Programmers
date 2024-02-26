import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
// 리프 노드 수 구하기
    static int N, W;

    static double result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        W = Integer.parseInt(stk.nextToken());
        result = 0;

        List<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N+1; i ++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++){
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        for(int i=2; i<N+1; i++) {
            if(adj.get(i).size() == 1)
                result++;
        }

        System.out.println(W/result);
    }
}
