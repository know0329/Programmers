import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int node;
        int cost;
        Node(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
        @Override
        public int compareTo(Node o) {
            if(this.cost>o.cost)
                return 1;
            return -1;
        }
    }
    static int n, m, s, t;

    static ArrayList<Node>[] graph;
    static int [] node;
    static void sol(){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(s,0));
        boolean [] visited =new boolean[n+1];
        int [] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s] = 0;
        while(!pq.isEmpty()) {

            int v = pq.poll().node;
            if(visited[v]) continue;
            visited[v]=true;

            for(Node next : graph[v]) {
                if(dist[next.node] > dist[v]+next.cost) {
                    dist[next.node] = dist[v]+next.cost;
                    pq.add(new Node(next.node,dist[next.node]));
                }
            }
        }
        System.out.println(dist[t]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        graph = new ArrayList[n+1];
        for(int i=1;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        node = new int[n+1];
        for(int i = 1; i <= n; i++){
            node[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < m; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        stk = new StringTokenizer(br.readLine());
        s = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());
        node[s] = 0;
        sol();
    }
}
