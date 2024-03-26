import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int [][] dist;
    static boolean [][] visited;

    static int [][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static void sol(int [][] map, int goalI, int goalJ){
        Queue<int []> que = new LinkedList<>();
        que.add(new int [] {goalI, goalJ, 0});
        while(!que.isEmpty()){
            int [] data = que.poll();
            int i = data[0];
            int j = data[1];
            int count = data[2];
            dist[i][j] = count;
            visited[i][j] = true;
            for(int a = 0; a < 4; a++){
                int ni = i + dir[a][0];
                int nj = j + dir[a][1];

                if(ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                if(map[ni][nj] == 0) continue;

                if(visited[ni][nj]) continue;

                visited[ni][nj] = true;
                que.add(new int [] {ni, nj, count+1});
            }
        }
    }

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        int [][] map = new int [N][M];
        dist = new int [N][M];

        visited = new boolean[N][M];
        int goalI = 0;
        int goalJ = 0;
        for(int i = 0; i < N ; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j ++){
                int num = Integer.parseInt(stk.nextToken());
                map[i][j] = num;
                if(num == 2){
                    goalI = i;
                    goalJ = j;
                }
            }
        }
        sol(map, goalI, goalJ);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    dist[i][j] = -1;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(dist[i][j]);
                if(j != M-1) sb.append(" ");
            }
            if(i != N-1) sb.append("\n");
        }
        System.out.println(sb);
    }
}
