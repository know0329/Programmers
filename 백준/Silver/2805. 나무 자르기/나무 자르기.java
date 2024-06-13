import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int [] tree = new int [N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(tree);
        int low = 0;
        int high = tree[N-1];
        while(low <= high ){
            int mid = (low + high)/2;
            long sum = 0;
            for(int i = 0; i < N; i++){
                sum += Math.max(tree[i] - mid, 0);

                if(sum >= M){
                    low = mid + 1;
                    break;
                }
            }
            if(sum < M){
                high = mid -1;
            }

        }
        System.out.println(high);


    }
}
