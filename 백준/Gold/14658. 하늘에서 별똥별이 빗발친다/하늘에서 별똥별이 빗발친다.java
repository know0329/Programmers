import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int x ;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, L, K , result;
    static List<Pair> list;

    static int check(int x, int y){
        int count = 0;
        for(Pair s: list){
            if(x <= s.x && s.x <= x+L && y <= s.y && s.y <= y+L ) count++;
        }
        return count;
    }
    static void sol(){

        int count = 0;
        for(Pair star1: list){
            for(Pair star2: list){
                count = Math.max(count, check(star1.x, star2.y));
            }
        }
        System.out.println(K - count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken()); // 가로
        M = Integer.parseInt(stk.nextToken()); // 세로
        L = Integer.parseInt(stk.nextToken()); // 트램펄린 길이
        K = Integer.parseInt(stk.nextToken()); // 별똥별 수
        list = new ArrayList<>();

        for(int i = 0; i < K; i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            list.add(new Pair(x, y));
        }
        sol();
    }
}
