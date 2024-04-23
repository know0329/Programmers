import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int [] num = new int[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(num);
        HashSet<Integer> indexSet = new HashSet<>();

        for(int i = 0 ; i < N ; i++){
            int left = 0;
            int right = N-1;  
            while(true){
                if(left == i) left++;
                else if(right == i) right--;
                
                if(left >= right) break;
                
                if(num[left] + num[right] > num[i]) right--;
                else if(num[left] + num[right] < num[i]) left++;
                else{     
                    indexSet.add(i);
                    break;
                }
            }
        }

        System.out.println(indexSet.size());
    }
}
