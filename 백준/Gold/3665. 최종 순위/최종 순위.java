import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(stk.nextToken());
        for(int c = 0; c < testCase; c++) {
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());

            int[] inDegree = new int[N+1];
            int[] array = new int[N+1];
            stk = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++) {
                array[i] = Integer.parseInt(stk.nextToken());
            }
            List<Integer>[] list = new ArrayList[N+1];
            for(int i=1;i<=N;i++)
                list[i] = new ArrayList<>();

            for(int i=1;i<=N;i++) {
                int from = array[i];
                for(int j=i+1;j<=N;j++) {
                    list[from].add(array[j]);
                    inDegree[array[j]]++;
                }
            }
            stk = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(stk.nextToken());
            for(int i=0;i<M;i++) {
                stk = new StringTokenizer(br.readLine());
                int front = Integer.parseInt(stk.nextToken());
                int back = Integer.parseInt(stk.nextToken());

                if(list[front].contains(back)) {
                    list[front].remove((Integer)back);
                    list[back].add(front);
                    inDegree[front]++;
                    inDegree[back]--;
                } else {
                    list[back].remove((Integer)front);
                    list[front].add(back);
                    inDegree[back]++;
                    inDegree[front]--;
                }
            }
            StringBuilder sb = new StringBuilder();

            Queue<Integer> queue = new LinkedList<>();

            int cnt=0;
            for(int i=1;i<=N;i++) {
                if(inDegree[i]==0) {
                    cnt++;
                    queue.add(i);
                }
            }

            if(cnt>1) {
                System.out.println("?");
                continue;
            }

            int result=0;

            boolean isFinished = false;
            for(int i=1;i<=N;i++) {
                if(queue.isEmpty()) {
                    System.out.println("IMPOSSIBLE");
                    isFinished=true;
                    break;
                }

                int from = queue.poll();
                result++;
                sb.append(from).append(" ");
                for(int to : list[from]) {
                    inDegree[to]--;
                    if(inDegree[to]==0) queue.add(to);
                }
            }
            if(isFinished==true) continue;

            System.out.println(sb.toString());
        }

    }
}
