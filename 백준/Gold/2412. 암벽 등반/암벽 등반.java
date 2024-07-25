import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair {
        int x;
        int y;


        Pair(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
    static ArrayList<Integer>[] rock;

    static int sol(int T){
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, 0));
        int move = 0;
        while (!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                Pair p = que.poll();
                if(p.y == T) return move;
                for(int y = p.y -2; y <= p.y + 2; y++){
                    if (y < 0 || y >= 200001) continue;
                    for (int j = 0; j < rock[y].size(); j++) {
                        int x = rock[y].get(j);
                        if (p.x + 2 < x) break;
                        else if (p.x - 2 > x) continue;

                        rock[y].remove(j);
                        que.add(new Pair(x, y));
                        j--;
                    }
                }
            }
            move++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        rock = new ArrayList[200001];
        for (int i = 0; i < 200001; i++) {
            rock[i] = new ArrayList<>();
        }
        int N = Integer.parseInt(stk.nextToken());
        int T = Integer.parseInt(stk.nextToken());
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            rock[y].add(x);
        }
        for (int i = 0; i < 200001; i++) {
            Collections.sort(rock[i]);
        }
        System.out.println(sol(T));
    }
}
