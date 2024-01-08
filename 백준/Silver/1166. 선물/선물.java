

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken()); // 박스 갯수
        int L = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());
        int H  = Integer.parseInt(stk.nextToken());

        double low = 0;
        double high = Math.min(L, Math.min(W, H));

        while(low < high){
            double mid = (low + high) / 2;
            
            if((long)(L/mid)*(long)(W/mid)*(long)(H/mid)<N){
                if(high==mid) break;
                high = mid;
            }else{
                if(low==mid) break;
                low = mid;
            }
        }
        System.out.println(low);


    }
}
