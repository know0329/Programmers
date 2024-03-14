import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean [][][] visited;
    static int result;
    static int [][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static void sol(int [][] map, int N, int M, int K){
        int startI = 0;
        int startJ = 0;
        Queue<int []> que = new LinkedList<>();

        que.add(new int[] {startI, startJ, 1, K});

        while(!que.isEmpty()){
            int [] location = que.poll();

            if(location[0] == N-1 && location[1] == M-1){
                result = Math.min(result, location[2]);
                return;
            }

            for(int i = 0; i < 4 ; i++){
                int nI = location[0] + dir[i][0];
                int nJ = location[1] + dir[i][1];

                if(nI < 0 || nJ  < 0 || nI >= N || nJ >= M) continue;
                if(visited[nI][nJ][location[3]]) continue;
                if(map[nI][nJ] == 1 && location[3] == 0) continue;

                if(map[nI][nJ] == 1){
                    visited[nI][nJ][location[3]] = true;

                    que.add(new int[] {nI, nJ, location[2] + 1, location[3] - 1} );
                }
                else{
                    visited[nI][nJ][location[3]] = true;
                    que.add(new int[] {nI, nJ, location[2] + 1, location[3]} );
                }

            }
        }


    }

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());


        int [][] map = new int [N][M];
        visited = new boolean[N][M][K+1];
        result = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            String str = stk.nextToken();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        sol(map, N, M, K);
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }
}
