import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, totalSheep, totalWolf;
    static char [][] map;
    static boolean [][] visited;
    static int [][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    static void sol(int r, int c){
        Queue<int []> que = new LinkedList<>();
        que.add(new int [] {r, c});
        visited[r][c] = true;
        int sheep = 0;
        int wolf = 0;
        while(!que.isEmpty()){
            int [] p = que.poll();
            if(map[p[0]][p[1]] == 'o') sheep ++;
            else if(map[p[0]][p[1]] == 'v') wolf++;
            for(int i = 0; i < 4; i++){
                int nr = p[0] + dir[i][0];
                int nc = p[1] + dir[i][1];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == '#') continue;
                que.add(new int [] {nr, nc});
                visited[nr][nc] = true;
            }
        }
        if(wolf >= sheep){
            totalWolf += wolf;
        }
        else{
            totalSheep += sheep;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            stk = new StringTokenizer(br.readLine());
            String s = stk.nextToken();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visited[i][j] && map[i][j] != '#'){
                    sol(i, j);
                }
            }
        }
        System.out.println(totalSheep + " " + totalWolf);

    }
}
