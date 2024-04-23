import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        boolean stop = false;
        int [] num = new int[N];
        int [] sum = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(stk.nextToken());
            if(num[i] >=S){
                stop = true;
            }
        }
        if(!stop){
            sum[0] = num[0];
            for(int i = 1; i < N; i++){
                sum[i] = sum[i-1] + num[i];
            }
            int result = Integer.MAX_VALUE;
            int i = 0;
            int j = 1;
            while(true){
                if(j >= N){
                    break;
                }
                if(j - i == result) i++;
                if(sum[j] - sum[i] + num[i]>= S){
                    result = Math.min(result, j - i + 1);
                    i++;
                    j = i+1;
                }
                else{
                    j++;
                }
            }
            if(result == Integer.MAX_VALUE){
                System.out.println(0);
            }
            else{
                System.out.println(result);
            } 
        }
        else{
            System.out.println(1);
        }

    }
}
