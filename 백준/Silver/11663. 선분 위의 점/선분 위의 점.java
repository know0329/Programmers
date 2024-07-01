import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int searchStart(int num, int [] V){
        int low = 0;
        int high = V.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(V[mid] < num){
                low = mid + 1;
            }
            else{
                high = mid-1;

            }
        }
        return low;
    }
    static int searchEnd(int num, int [] V){
        int low = 0;
        int high = V.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(V[mid] > num){
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        return high+1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()); //점
        int M = Integer.parseInt(stk.nextToken()); // 선분

        int [] V = new int [N];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            V[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(V);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){

            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int start = searchStart(s, V);
            int end = searchEnd(e, V);
            System.out.println(end - start);
        }


    }
}
