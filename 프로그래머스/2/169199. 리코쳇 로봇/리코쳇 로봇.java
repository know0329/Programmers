import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Point {
        int r;
        int c;
    }
    
    static int [] sliding(char type, int a, int b){
        int r = a;
        int c = b;
        if(type == 'R'){
            while(true){
                   c += 1;
                   if(c >= N || map[r][c] == 1){
                       int [] np = {r, c - 1};
                       return np;
                   }
            }
        }
        else if(type == 'L'){
        
            while(true){
               c -= 1;
        
               if(c < 0 ||  map[r][c] == 1){
                   int [] np = {r, c + 1};
                   return np;
               }
            }
        }
        else if(type == 'U'){
             while(true){
                   r -= 1;
                   if(r < 0 || map[r][c] == 1){
                       int [] np = {r + 1, c};
                       return np;
                   }
            }
        }
        else{
           while(true){
               r += 1;
               if(r >= N || map[r][c] == 1){
                   int [] np = {r - 1, c};
                   return np;
               }
            }
        }

    }
    
    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    
    static void bfs(int a, int b){
        Queue<int []> que = new LinkedList<>();
        int [] p = {a, b, 0};
        que.add(p);
        visited[a][b] = true;
        while(!que.isEmpty()){
            int [] data = que.poll();
            
            int r = data[0];
            int c = data[1];
            int n = data[2];
            if(map[r][c] == 2){
                result = n;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = r;
                int ny = c;
                
                while (inRange(nx, ny) && map[nx][ny] != 1) {
                    nx += dx[i];
                    ny += dy[i];
                }

            
                nx -= dx[i];
                ny -= dy[i];

           
                if (visited[nx][ny] || (r == nx && c == ny)) continue;

                visited[nx][ny] = true;
                int [] np = {nx, ny, n + 1};
                que.add(np);
            }
        }
            
          
        
    }

    static Point robot;
    static Point goal;
    static int result;
    static int N, M;
    static int [][] map;
    static boolean [][] visited;
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        map = new int[N][M];
        visited = new boolean[N][M];
        robot = new Point();
        goal = new Point();
        result = -1;
        for(int i = 0; i < N; i++){
            String boardJ = board[i];
            for(int j = 0;  j< M; j++){
                if(boardJ.charAt(j) == 'R'){
                    robot.r = i;
                    robot.c = j;
                }
                else if(boardJ.charAt(j)  == 'G'){
                    goal.r = i;
                    goal.c = j;
                    map[i][j] = 2;
                }
                else if(boardJ.charAt(j) == 'D'){
                    map[i][j] = 1;
                }
                else{
                    
                }
                  
            }
        }
        bfs(robot.r, robot.c);
        answer = result;
        return answer;
    }
}