import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int [] solutions = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            solutions[i] =  Integer.parseInt(stk.nextToken());
        }
        long result = Long.MAX_VALUE ;
        int minI = -1;
        int minJ = -1;
        int i = 0;
        int j = N-1;
        while(i < j ){
            long sum = solutions[i] + solutions[j];
            if(sum == 0){
                minI = i;
                minJ = j;
                break;
            }
            if(Math.abs(sum) < result ){
                minI = i;
                minJ = j;
                result = Math.abs(sum);
               if(sum < 0){
                   i++;
               }
               else{
                   j--;
               }
            }
            else{
                if(sum > 0){
                    j--;
                }
                else{
                    i++;
                }
            }




        }
        System.out.println(solutions[minI]+ " "+ solutions[minJ]);

    }
}
