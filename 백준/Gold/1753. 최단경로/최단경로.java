import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int next;
        int weight;

        Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }
    }
    static int [] dist;
    static List<List<Node>> graph;

    static int V, E, K;

    static void search(int start){
        dist = new int[V+1];
        for(int i = 1; i <= V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        q.offer(new Node(start, 0));
        dist[start] = 0;
        while(!q.isEmpty()){
            Node curNode = q.poll();
            if (dist[curNode.next] < curNode.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.next).size(); i++) {
                Node nxtNode = graph.get(curNode.next).get(i);
               
                if (dist[nxtNode.next] > curNode.weight + nxtNode.weight) {
                    dist[nxtNode.next] = curNode.weight + nxtNode.weight;
             
                    q.offer(new Node(nxtNode.next, dist[nxtNode.next]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        K = Integer.parseInt(stk.nextToken());
        graph = new ArrayList<>();

        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < E; i++){
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            graph.get(u).add(new Node(v, w));
        }
        StringBuilder sb = new StringBuilder();

        search(K);

        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);

    }
}
