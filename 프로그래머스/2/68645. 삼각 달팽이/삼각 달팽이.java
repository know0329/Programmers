class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        int [][] arr = new int [n][n];
        
        int [] dx = {0, 1, -1};
        int [] dy = {1, 0, -1};
        int x = 0;
        int y = 0;
        int num = 1;
        int d = 0;
        while(true){
            arr[y][x] = num++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0){
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }
        int [] result = new int[num - 1];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <=i; j++){
                result[index++] = arr[i][j];
            }
        }
        answer = result;
        return answer;
    }
}