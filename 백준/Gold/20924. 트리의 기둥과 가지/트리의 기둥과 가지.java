
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // 기가 노드는 루트 노드에서 순회를 시작했을 때, 처음으로 자식 노드가 2개 이상인 노드
    // 리프 노드가 단 1개인 경우 리프 노드가 동시에 기가 노드
    // 트리의 기둥과 가장 긴 가지의 길이를 측정

    static int N, R, G;
    static List<List<int []>> graph;
    static boolean []  visited;
    static int pillar = 0;
    static int largeTwig = 0;

    static void SearchGiga(int node, int size){

        if(graph.get(node).size() > 2 || (graph.get(node).size() == 1 && node != R) || (graph.get(node).size()  >=2 && node == R)){
            G = node;
            pillar = Math.max(size, pillar);
            return;
        }

        visited[node] = true;

        for(int i = 0; i < graph.get(node).size(); i++){
            if(visited[graph.get(node).get(i)[0]]) continue;

            SearchGiga(graph.get(node).get(i)[0], graph.get(node).get(i)[1] + size);
        }

    }

    static void SearchTwigs(int t, int size){

        if(graph.get(t).size() <= 1){
            largeTwig = Math.max(largeTwig, size);
            return;
        }

        for(int i = 0; i < graph.get(t).size(); i++){
            if(!visited[graph.get(t).get(i)[0]]){
                visited[t] = true;
                SearchTwigs(graph.get(t).get(i)[0], size + graph.get(t).get(i)[1]);
                visited[t] = false;
            }
        }
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();
        N = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken()) - 1;
        G = R;
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < N - 1; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());
            graph.get(a-1).add(new int [] {b-1, d});
            graph.get(b-1).add(new int[] {a-1, d});
        }
        visited = new boolean[N];
        SearchGiga(R, 0);
        SearchTwigs(G, 0);
        System.out.println(pillar);
        System.out.println(largeTwig);
    }
}
