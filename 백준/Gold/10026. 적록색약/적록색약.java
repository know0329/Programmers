import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static char [][] map;
    static boolean [][] visited;
    static int [] result;
    static int [][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static void sol(int r , int c, boolean flag, int count){
        if(flag){
            Queue<int []> que = new LinkedList<>();
            que.add(new int[]{r, c});
            visited[r][c] = true;
            while(!que.isEmpty()){
                int [] p = que.poll();
                for(int i = 0; i < 4; i++){
                    int nr = p[0] + dir[i][0];
                    int nc = p[1] + dir[i][1];
                    if((nr >= 0 && nc >= 0 && nr < N && nc < N)
                            && (!visited[nr][nc])
                            && ((map[nr][nc] == map[r][c]) || (map[nr][nc] == 'R' && map[r][c] == 'G') || (map[nr][nc] == 'G' && map[r][c] == 'R'))){
                        que.add(new int [] {nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            result[1] = count;
        }
        else{
            Queue<int []> que = new LinkedList<>();
            que.add(new int[]{r, c});
            visited[r][c] = true;
            while(!que.isEmpty()){
                int [] p = que.poll();
                for(int i = 0; i < 4; i++){
                    int nr = p[0] + dir[i][0];
                    int nc = p[1] + dir[i][1];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if(map[r][c] != map[nr][nc]) continue;
                    if(visited[nr][nc]) continue;

                    que.add(new int [] {nr, nc});
                    visited[nr][nc] = true;

                }
            }
            result[0] = count;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        map = new char [N][N];

        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            String s = stk.nextToken();
            for(int j = 0; j < s.length(); j++){
                map[i][j] = s.charAt(j);
            }
        }

        result = new int[2];
        visited = new boolean[N][N];
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]) {
                    count++;
                    sol(i, j, false, count);
                }
            }
        }
        visited = new boolean[N][N];
        count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]) {
                    count++;
                    sol(i, j, true, count);
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
