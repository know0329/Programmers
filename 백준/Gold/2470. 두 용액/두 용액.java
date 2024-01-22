import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static int [] solutions ;
    static StringBuilder sb;
    static void sol() {
        int left = 0;
        int right = N - 1;
        int result1 = left;
        int result2 = right;
        int min = Integer.MAX_VALUE;
        while(left < right){

            int sum = solutions[left] + solutions[right];

            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                result1 = solutions[left];
                result2 = solutions[right];
            }
            if(sum < 0) left ++;
            else right --;

        }
        System.out.println(result1 + " " + result2);
    }


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        sb = new StringBuilder();
        solutions = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            solutions[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(solutions);
//        for(int i = 0; i < N ; i++){
//            System.out.println( solutions[i] );
//        }
        sol();

    }
}
