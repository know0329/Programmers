import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        PriorityQueue<Integer> que = new PriorityQueue<>();

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            que.add(Integer.parseInt(stk.nextToken()));
        } // 처음 N개 넣기

        for(int i = 1; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++) {
               int num = Integer.parseInt(stk.nextToken());

               if(que.peek() < num){
                   que.poll();
                   que.add(num);
               }
            }
        } // N-1 개 작은 거 부터 순차적으로 빼기 => 다 빼면 peek는 N번쨰 큰 수가 남음

        System.out.println(que.peek());

    }
}
