import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int cost;
        int end ;

        Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }


    static int N, M, X, result;
    static List<List<Node>> list;

    static int [][] dist;

    static void sol(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0));
        dist[start][start] = 0;
        while(!pq.isEmpty()){

            Node node = pq.poll();



            if(dist[start][node.end] < node.cost) continue;
            for(int i = 0; i < list.get(node.end).size(); i++){
                Node nxtNode = list.get(node.end).get(i);
                if (dist[start][nxtNode.end] > node.cost + nxtNode.cost) {
                    dist[start][nxtNode.end] = node.cost + nxtNode.cost;
                    // 갱신된 경우에만 큐에 넣는다.
                    pq.offer(new Node(nxtNode.end, dist[start][nxtNode.end]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        X = Integer.parseInt(stk.nextToken());
        result = 0;
        list = new ArrayList<>();
        dist = new int[N+1][N+1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < M ; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            Node d = new Node(b, c);
            list.get(a).add(d);
        }
        for(int i = 1; i <= N; i++) sol(i);
     

        for(int i = 1; i <= N; i++){
            result = Math.max(dist[X][i] + dist[i][X], result);
        }

        System.out.println(result);
    }
}
