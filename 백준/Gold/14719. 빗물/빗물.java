import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        int [] height = new int[W];

        for(int i = 0; i < W; i++){
            int high = Integer.parseInt(stk.nextToken());
            height[i] = high;
        }
        int rain = 0;

        for(int i=1; i<W-1; i++) {
            int left = 0;
            int right = 0;

            for(int j=0; j<i; j++) {
                left = Math.max(height[j], left); 
            }

            for(int j=(i+1); j<W; j++) {
                right = Math.max(height[j], right);

            }
            if(height[i] < left && height[i] < right) rain += Math.min(left, right) - height[i];
        }
        System.out.println(rain);

    }
}
