import java.util.*;
class Solution {
    
    static void sol(int n, int from, int to, List<int[]> process){
        if(n == 1){
            process.add(new int[] {from, to});
            return;
        }
        
        int empty = 6 - from - to;
        
        sol(n -1, from, empty, process);
        sol(1, from, to, process);
        sol(n -1, empty, to, process);
    }
    public int[][] solution(int n) {
        int[][] answer = {};
        List<int []> process = new ArrayList<>();
        sol(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }
}