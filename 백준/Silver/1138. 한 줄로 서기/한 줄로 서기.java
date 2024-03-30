import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());

        int [] p = new int[N+1];
        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            p[i] = Integer.parseInt(stk.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = N; i >= 1; i--){
            list.add(p[i], i);
        }
        for(int h : list){
            System.out.print(h + " ");
        }
 
    }
}
