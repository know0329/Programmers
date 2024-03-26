import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c;
    static int[] sushi;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken())-1;
        sushi = new int[N];
        int[] eat = new int[d];	// 해당 종류의 초밥을 몇개 먹었는지 저장
        for(int i =0 ; i < N ; i++){
            sushi[i] = Integer.parseInt(br.readLine())-1;
        }
        int result = 0;
        int cnt = 0;
        for(int i =0 ; i < k ; i++){
            if(eat[sushi[i]]++ == 0) cnt++;
        }
        for(int i =0 ; i < N ; i++){
            if(result <= cnt){    
                if(eat[c] == 0) result = cnt+1; // 쿠폰에 있는 초밥을 안 먹은 경우
                else result = cnt; // 쿠폰에 있는 초밥을 먹은 경우
            }
            int j = (i+k)%N;  // 순환
            if(eat[sushi[j]] ++ == 0) cnt++;
            if(-- eat[sushi[i]] == 0) cnt--; // 접시에 해당 초밥이 없으면 cnt --
        }
        System.out.println(result);
    }
}