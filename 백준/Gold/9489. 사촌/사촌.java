import java.io.*;
import java.util.*;
public class Main {


    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        while(N != 0 && K != 0){
            stk = new StringTokenizer(br.readLine());
            int [] parent = new int[N+1];
            int [] data = new int[N+1];
            parent[0] = -1;
            int parentIndex = 0;
            int target = -1;
            for(int i = 1; i <= N; i++){
                data[i] = Integer.parseInt(stk.nextToken());
                if(data[i] == K) target = i;
                if(i > 1 && data[i] - data[i-1] != 1) parentIndex++;
                parent[i] = parentIndex;
            }
            int count = 0;
            for(int i = 1; i <= N; i++){
                if(parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]]){
                    count++;
                }
            }
            System.out.println(count);


            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            K = Integer.parseInt(stk.nextToken());
        }
    }
}
