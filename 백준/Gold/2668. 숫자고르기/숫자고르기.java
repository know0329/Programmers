import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int [] table;

    static boolean [] visited;

    static List<Integer> list;

    static StringBuilder sb;

    static boolean flag;

    static void sol(int start, int target){
        if(!visited[table[start]]) {
            visited[table[start]] = true;
            sol(table[start], target);
            visited[table[start]] = false;
        }
        if(table[start] == target) list.add(target);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        table = new int[N+1];
        flag = false;

        for(int i = 1; i  <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            table[i] = Integer.parseInt(stk.nextToken());
        }
        list = new ArrayList<>();
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            sol(i, i);
            visited[i] = false;
        }
        Collections.sort(list); 
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        

    }
}
