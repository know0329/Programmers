import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, C;
    static int [] house;

    static int sol(int dist){
        int count = 1;
        int current = 0;
        for(int i = 1; i < house.length; i++){
            if(house[i] - house[current] >= dist){
                current = i;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        house = new int[N];
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            house[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(house);
        int left = 1;
        int right = house[N-1] - house[0] + 1;
        while(left < right){
            int mid = (left + right) / 2; // 와이파이 간의 거리
            if(sol(mid) < C){
                right = mid; // 와이파이 간의 거리가 줄어들면 와이파이 설치 개수 증가
            }
            else{
                left = mid + 1; // 와이파이 간의 거리가 늘어나면 와이파이 설치 개수 감소
            }
        }
        System.out.println(left - 1);

    }
}
