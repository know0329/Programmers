import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int maxArea;
    static int [][] picture;
    static boolean [][] visited;
    static int [][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static void sol(int r, int c){
        Queue<int []> que = new LinkedList<>();
        que.add(new int[] {r, c});
        visited[r][c] = true;
        int count = 0;
        while(!que.isEmpty()){
            int [] p = que.poll();
            count++;
            for(int i = 0; i < 4; i++){
                int nr = p[0] + dir[i][0];
                int nc = p[1] + dir[i][1];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(picture[nr][nc] == 0) continue;

                que.add(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
        maxArea = Math.max(count, maxArea);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        picture = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                picture[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int countOfPicture  = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M ; j++){
                if(picture[i][j] == 1 && !visited[i][j]){
                    countOfPicture++;
                    sol(i, j);
                }
            }
        }
        System.out.println(countOfPicture);
        System.out.println(maxArea);
    }
}
