import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, result;
    static char [][] map;

    static boolean [] alpha;

    static int [][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    static void sol(int r, int c, int count){
        if(alpha[map[r][c] - 'A']){
            result = Math.max(count, result);
            return;
        }
        else{
            alpha[map[r][c] - 'A'] = true;
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                sol(nr, nc, count+1);

            }
            alpha[map[r][c] - 'A'] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        map = new char[R][C];
        result = 1;
        for(int i = 0; i < R; i++){
            stk = new StringTokenizer(br.readLine());
            String str = stk.nextToken();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
            }
        }
        alpha = new boolean[26];
        sol(0, 0, 0);
        System.out.println(result);
    }
}
