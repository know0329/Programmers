class Solution {
    
// 가로 세로 벽은 벡터 값으로 거리 계산해서 더 짧은 쪽에 맞추도록 한다, 단 이동 경로 상에 공이 있으면 그 벽은 무시하고 다른 벽
// 쳐야하는 공보다 왼쪽에 위치해 있다면 왼쪽 벽에 맞추고, 반대면 오른쪽 벽

    static int M, N;
    static int [][] flip(int [] p){
        int targetX = p[0];
        int targetY = p[1];
        
        int [][] flips = new int[4][2];
        // y축
        flips[0][0] = -targetX;
        flips[0][1] = targetY;
        // x 축
        flips[1][0] = targetX;
        flips[1][1] = -targetY;
        // 세로 축
        flips[2][0] = (M - targetX)*2 + targetX;
        flips[2][1] = targetY;
        // 가로 축
        flips[3][0] = targetX;
        flips[3][1] = (N - targetY)*2 + targetY;
        
        return flips;
        
        
    }
 
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int [balls.length];
        int index = 0;
        M = m;
        N = n;
        for(int [] ball : balls){
            int minDist = Integer.MAX_VALUE;
            int [][] flipedBalls = flip(ball);
            
            int disable = -1;
            
            if(ball[0] == startX) disable = 0; // 가로 축 대칭 불가
            if(ball[1] == startY) disable = 1; // 세로 축 대칭 불가
            
            for(int i = 0; i < flipedBalls.length; i++){
                if(disable == 1 && (ball[0] < startX) && i == 0 ) continue;
                if(disable == 1 && (ball[0] > startX) && i == 2 ) continue;
                if(disable == 0 &&  (ball[1] < startY) && i == 1 ) continue;
                if(disable == 0 &&  (ball[1] > startY) && i == 3 ) continue;
                int x = Math.abs(flipedBalls[i][0] - startX);
                int y = Math.abs(flipedBalls[i][1] - startY);
                int dist = x*x + y*y;
                minDist = Math.min(minDist, dist);
            }
            answer[index++] = minDist;
            
        }    
        
        return answer;
    }
}