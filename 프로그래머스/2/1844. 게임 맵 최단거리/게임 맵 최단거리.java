import java.util.*;
class Solution {
    
    static int [][] dir = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
    
    static boolean [][]  visited;
    
    static int result;
    
    static void sol(int [][] maps, int N, int M) {
        
        Queue<int [] > que = new LinkedList<>();
        que.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        while(!que.isEmpty()){
            int [] p = que.poll();
            int r = p[0];
            int c = p[1];
            int v = p[2];
            
            if(r == N-1 && c == M-1){
                result = Math.min(result, v);
                return;
            }
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr][nc] == 0) continue;
                
                que.add(new int[] {nr, nc, v+1});
                visited[nr][nc] = true;
            }
            
            
            
        }
    }
    
    public int solution(int[][] maps) {
        
        int N = maps.length;
        int M = maps[0].length;
        result = Integer.MAX_VALUE;
        visited = new boolean[N][M];
        sol(maps, N, M);
        if(result == Integer.MAX_VALUE) return -1;
        else return result;
        
    }
}