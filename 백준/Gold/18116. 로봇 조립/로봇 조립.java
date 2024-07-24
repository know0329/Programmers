import java.util.*;
import java.io.*;
public class Main {

    static int [] parent;
    static int [] counting;
    public static  int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            counting[x] += counting[y];
            parent[parent[y]] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        StringBuilder sb = new StringBuilder();
        parent = new int[1000001];
        counting = new int[1000001];
        for(int i = 0; i < 1000001; i++){
            parent[i] = i;
            counting[i] = 1;
        }
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            String s = stk.nextToken();
            if(s.equals("I")){
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                union(a, b);
            }
            else if(s.equals("Q")){
                int c =  Integer.parseInt(stk.nextToken());
                sb.append(counting[find(c)]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
