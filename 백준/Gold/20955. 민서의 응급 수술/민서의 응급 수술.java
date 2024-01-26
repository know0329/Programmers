
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static int [] parent;

    static void union(int r1, int r2) {
        if (parent[r1] < parent[r2]) {
            parent[r1] += parent[r2];
            parent[r2] = r1;

        } else {
            parent[r2] += parent[r1];
            parent[r1] = r2;
        }
    }

    static int find(int u) {
        if (parent[u] < 0) return u;

        return parent[u] = find(parent[u]);
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        parent = new int[N+1];
        Arrays.fill(parent, -1);

        int count = 0;
        for(int i = 0; i < M; i++){
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int r1 = find(u);
            int r2 = find(v);

            // 싸이클 파악하기 => 싸이클이면 끊어줘야 하는데 끊는 작업은 연산에 들어감
            if(r1 == r2){
                count ++;
                continue;
            }
            union(r1, r2);

        }
        int group = 0;
        // root 노드 찾기 => root 노드를 찾아서 연결하는 작업 또한 연산에 들어감
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] < 0)
                group++;
        }

        // -1을 뺴주는 이유는 n개의 그룹이 카운트 되었을 때 연결하는 작업은 n-1번만 수행 하면 되므로 -1을 뺴준다
        System.out.print(count + group - 1);
    }
}
