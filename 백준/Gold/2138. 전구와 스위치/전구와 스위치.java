import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, result;
    static void changeBulb(int index, int count, int [] bulb, int [] answer){
        if (index == N){
            if(bulb[index -1] == answer[index - 1]){
                result = Math.min(result, count);
            }
            return;
        }

        if(bulb[index-1] != answer[index - 1]){
            int [] changedBulb = change(bulb, index);

            changeBulb(index+1, count+1, changedBulb, answer);
        }
        else{
            changeBulb(index+1, count, bulb, answer);
        }
    }

    static int [] change (int [] bulb, int index){
        for(int i = index - 1;  i <= index+1; i++){
            if(i >= 0 && i < N){
                if(bulb[i] == 1){
                    bulb[i] = 0;
                }
                else bulb[i] = 1;
            }
        }
        return bulb;
    }

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        result = Integer.MAX_VALUE;
        int [] bulb = new int[N];
        int [] answer = new int[N];
        stk = new StringTokenizer(br.readLine());
        String s = stk.nextToken();
        for(int i = 0; i < N; i++){
            bulb[i] = s.charAt(i) - '0';
        }
        stk = new StringTokenizer(br.readLine());
        s = stk.nextToken();
        for(int i = 0; i < N; i++){
            answer[i] = s.charAt(i) - '0';
        }
        int [] c = Arrays.copyOf(bulb, N);
        changeBulb(1, 0, bulb, answer);
        changeBulb(1, 1, change(c, 0), answer);
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);

    }
}
