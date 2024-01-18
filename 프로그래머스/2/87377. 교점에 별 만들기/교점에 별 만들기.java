import java.util.*;

class Solution {
    
    static class Point{
        long x;
        long y;
        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString(){
            return "x : " + this.x + " y : " + this.y;
        }
    }
    
    static List<Point> points;
    
    static String[] result;
    
    static void SeachPoint(int [] line1, int [] line2){
       
        long a1 = line1[0];
        long a2 = line2[0];
        long b1 = line1[1];
        long b2 = line2[1];
        long c1 = line1[2];
        long c2 = line2[2];
        
        
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
        
        // 정수 판별
        if(x % 1 == 0 && y % 1 == 0){
            points.add(new Point((long)x, (long)y));
        }
        
        return;
    }
    static void DrawStar(){
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
       
        
        for(Point p : points){
            long x = p.x;
            long y = p.y;
            
            maxX = Math.max(x, maxX);
            minX = Math.min(x, minX);
            minY = Math.min(y, minY);
            maxY = Math.max(y, maxY);
            
        }
        char[][] arr = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
        
        for(char[] row : arr){
            Arrays.fill(row, '.');
        }
        
        for(Point p : points) {
            int x = (int) (p.x - minX);
            int y = (int) (maxY - p.y);
            arr[y][x] = '*';
        }
        
        
        result = new String[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = new String(arr[i]);
        }
      
            
        
        
    }
    
    public String[] solution(int[][] line) {
        
        
        
        points = new ArrayList<>();
        
        for(int i = 0; i < line.length - 1; i++){
            for(int j = i+1; j < line.length; j++){
                SeachPoint(line[i], line[j]);
            }
        }
        
        DrawStar();
        return result;
    }
}