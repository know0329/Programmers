import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int N, K, result;
    static boolean [] visited;

    static boolean Available(int num){
        if(num < 0 || num > 100_000) return false;

        return !visited[num];
    }

    static void Search() {

        Queue<int []> que = new LinkedList<>();
        int [] start = {N, 0, K};
        que.add(start);
        visited[N] = true;
        
        while(!que.isEmpty()){
            int [] node = que.poll();

            if(node[0] == K) {
                result = Math.min(node[1], result);
              
            }

            int [] newNode1 = {node[0] - 1, node[1] + 1, K};
            int [] newNode2 = {node[0] + 1, node[1] + 1, K};
            int [] newNode3 = {node[0] * 2, node[1] , K};

             if(Available(newNode3[0])) {
                que.add(newNode3);
                visited[newNode3[0]] = true;
            }
            
            if(Available(newNode1[0])) {
                que.add(newNode1);
                visited[newNode1[0]] = true;
            }

            if(Available(newNode2[0])) {
                que.add(newNode2);
                visited[newNode2[0]] = true;
            }
           

        }
    }



    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        visited = new boolean[100_001];
        result = 100_001;
        Search();
        System.out.println(result);
    }
}
