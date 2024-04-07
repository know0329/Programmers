import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        public Node(){}


        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        HashMap<Integer, List<Node>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            Node n1 = new Node();
            n1.end = b;
            n1.cost = c;


            if (map.containsKey(a)) {
                List<Node> list = map.get(a);
                list.add(n1);
                map.put(a, list);
            } else {
                List<Node> list = new ArrayList<>();
                list.add(n1);
                map.put(a, list);
            }

            Node n2 = new Node();
            n2.end = a;
            n2.cost = c;

            if (map.containsKey(b)) {
                List<Node> list = map.get(b);
                list.add(n2);
                map.put(b, list);
            } else {
                List<Node> list = new ArrayList<>();
                list.add(n2);
                map.put(b, list);
            }
        }
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

       
        for (int i = 0; i < N + 1; i++) {
         
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[1] = 0; 
        q.offer(new Node(1, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (!visited[current.end]) visited[current.end] = true;
            else continue;

            for (int i = 0; i < map.get(current.end).size(); i++) {
                Node next = map.get(current.end).get(i);
                if (dist[next.end] > dist[current.end] + next.cost) {
                    dist[next.end] = dist[current.end] + next.cost;
                    q.offer(new Node(next.end, dist[next.end]));
                }
            }

        }
        System.out.println(dist[N]);
    }
}
