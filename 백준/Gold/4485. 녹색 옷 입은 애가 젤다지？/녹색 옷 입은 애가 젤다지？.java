import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, result;
    static int [][] map;

    static int [][] cost;

    static boolean [][] visited;

    static StringBuilder sb;
    static int [][] dir = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};

    static class Node implements Comparable<Node>{
        int r;
        int c;

        int sumOfCost;


        @Override
        public int compareTo(Node o) {
            return this.sumOfCost - o.sumOfCost;
        }

        Node(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.sumOfCost = cost;
        }
    }

    static void sol(){
        cost[0][0] = map[0][0];
        int currentCost = cost[0][0];
        int currentR = 0;
        int currentC = 0;
        Node node = new Node(currentR,currentC,currentCost);

        PriorityQueue<Node> priQue = new PriorityQueue<>();

        priQue.add(node);
        visited[currentR][currentC] = true;
        while(!priQue.isEmpty()){
            Node popNode = priQue.poll();
            if(popNode.r ==N-1 && popNode.c == N-1) break;
            for(int i = 0; i < 4; i++){
                int newR = popNode.r + dir[i][0];
                int newC = popNode.c + dir[i][1];

                if(newR < 0 || newC < 0 || newR >= N || newC >= N) continue;
                if(visited[newR][newC]) continue;

                int sum = map[newR][newC] + popNode.sumOfCost;
                priQue.add(new Node(newR, newC, sum));
                cost[newR][newC] = Math.min(cost[newR][newC], sum);
                visited[newR][newC] = true;
            }
        }
        result = cost[N-1][N-1];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(stk.nextToken());
        int count = 1;
        while(N > 0){
            result = 0;
            map = new int [N][N];

            for(int i = 0; i <N; i++){
                stk = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            cost = new int [N][N];
            for(int i = 0; i < N; i++){
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }
            visited = new boolean [N][N];
            sol();
            sb.append("Problem " + count + ": " + result);
            sb.append("\n");
            count++;
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
        }
        System.out.println(sb);
    }
}
