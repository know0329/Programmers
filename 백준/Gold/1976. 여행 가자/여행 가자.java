import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static Stack<Integer> stack ;

    static int [] parent;
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for(int i = 1; i <= N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int v = Integer.parseInt(stk.nextToken());
                if(v == 1){
                    union(i, j);
                }
            }
        }
        stk = new StringTokenizer(br.readLine());
        stack = new Stack<>();
        for(int i = 0; i < M; i++){
            stack.add(Integer.parseInt(stk.nextToken()));
        }
        int parentOfPrevious = find(stack.pop()) ;
        boolean stop = false;
        while(!stack.isEmpty()){
            int parentOfPresent = find(stack.pop());
            if(parentOfPresent == parentOfPrevious){
                parentOfPrevious = parentOfPresent;
            }
            else {
                stop = true;
                break;
            }
        }
        if(stop) System.out.println("NO");
        else System.out.println("YES");
    }
}
