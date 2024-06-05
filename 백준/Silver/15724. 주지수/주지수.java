import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] picture = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=M;j++) {
                picture[i][j] = Integer.parseInt(st.nextToken())+picture[i][j-1]+picture[i-1][j]-picture[i-1][j-1];
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X1 = Integer.parseInt(st.nextToken());
            int Y1 = Integer.parseInt(st.nextToken());
            int X2 = Integer.parseInt(st.nextToken());
            int Y2 = Integer.parseInt(st.nextToken());

            int sum = picture[X2][Y2]-picture[X1-1][Y2]-picture[X2][Y1-1]+picture[X1-1][Y1-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
}