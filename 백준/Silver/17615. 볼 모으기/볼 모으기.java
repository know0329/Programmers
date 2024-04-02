import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        String [] ball = stk.nextToken().split("");
        int count = 0;
        boolean diff = false;
        int result = Integer.MAX_VALUE;
        // 왼쪽으로 빨강 공 모으기

        for(int i = 0; i < N; i++){
            if(diff && ball[i].equals("R")){
                count++;
                continue;
            }
            if(ball[i].equals("B")) diff = true;
        }
        result = Math.min(result, count);

        // 오른쪽으로 빨강 공 모으기
        count = 0;
        diff = false;
        for(int i = N-1; i >= 0; i--){
            if(diff && ball[i].equals("R")){
                count++;
                continue;
            }
            if(ball[i].equals("B")) diff = true;
        }
        result = Math.min(result, count);
        // 왼쪽으로 파란공 모으기
        count = 0;
        diff = false;
        for(int i = 0; i < N; i++){
            if(diff && ball[i].equals("B")){
                count++;
                continue;
            }
            if(ball[i].equals("R")) diff = true;
        }
        result = Math.min(result, count);
        // 으론쯕으로 파란공 모으기
        count = 0;
        diff = false;
        for(int i = N-1; i >= 0; i--){
            if(diff && ball[i].equals("B")){
                count++;
                continue;
            }
            if(ball[i].equals("R")) diff = true;
        }
        result = Math.min(result, count);
        System.out.println(result);

    }

}
