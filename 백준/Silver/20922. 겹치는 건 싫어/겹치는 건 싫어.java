import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int [] num = new int [N];
        int [] count = new int [100001];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i  < N; i++){
            num[i] = Integer.parseInt(stk.nextToken());
        }
        int i = 0;
        int j = i+1;
        count[num[i]]++;
        count[num[j]]++;
        int result = 1;
        while(j < N){
            j++;
            if(j == N) break;
            count[num[j]]++;
            if(count[num[j]] > K){
             result = Math.max(result, j - i);


                for(int a = i; a < N; a++){
                    if(num[a] == num[j]) {
                        i = a + 1;
                        count[num[a]]--;
                        break;
                    }
                    else{
                        count[num[a]] --;
                    }
                }

            }

        }
        result = Math.max(result, j - i );
        System.out.println(result);

    }
}
