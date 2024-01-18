import java.util.*;
class Solution {
    
    static int N;
    
    static int [] result;
    
    
    static class Point{
        int x;
        int y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static void sol(String [] place, int index){
        char [][] arr = new char[N][N];
        List<Point> list = new ArrayList<>();
        for(int i = 0; i < N ; i++){
            for(int j = 0; j < N; j++){
                if(place[i].charAt(j) == 'P') {
                    arr[i][j] = 'P';
                    list.add(new Point(i, j));
                }
                else if(place[i].charAt(j) == 'X'){
                    arr[i][j] = 'X';
                }
                else{
                    arr[i][j] = 'O';
                }
            }
        }
         for(int i = 0; i < list.size()-1 ; i++){
            for(int j = i+1; j < list.size(); j++){
                Point p1 = list.get(i);
                Point p2 = list.get(j);
                if(!CanSit(p1, p2, arr)){
                    result[index] = 0;
                    return;
                }   
            }
         }
        result[index] = 1;
    }
    
    static boolean CanSit(Point p1, Point p2, char [][] arr){
        if(Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y ) > 2) return true;
        else{
            // 같은 x축인가
            if(p1.x == p2.x){
                // p1이 p2보다 앞에 있고 사이에 칸막이가 잇는가?
                if(p1.y < p2.y && arr[p1.x][p1.y +1] == 'X'){
                    return true;
                }
                else if(p1.y > p2.y && arr[p1.x][p2.y +1] == 'X'){
                    return true;
                }
                else{
                    return false;
                }
            }
            //같은 y축인가?
            else if(p1.y == p2.y){
                // p1이 p2보다 위에 있고 사이에 칸막이가 잇는가?
                if(p1.x < p2.x && arr[p1.x + 1][p1.y] == 'X'){
                    return true;
                }
                else if(p1.x > p2.x && arr[p2.x+1][p1.y] == 'X'){
                    return true;
                }
                else{
                    return false;
                }
            }
            
            else{
                // p1이 p2 왼쪽 위 대각선에 위치하는가?
                if(p1.x < p2.x && p1.y < p2.y){
                    if(arr[p1.x][p1.y+1] =='X' && arr[p1.x+1][p1.y] == 'X') return true;
                    else return false;
                }
                //  p1이 p2 왼쪽 아래 대각선에 위치하는가?
                else if(p1.x > p2.x && p1.y < p2.y){
                    if(arr[p1.x][p1.y+1] =='X' && arr[p1.x-1][p1.y] == 'X') return true;
                    else return false;
                }
                 //  p1이 p2 오른쪽 아래 대각선에 위치하는가?
                else if(p1.x > p2.x && p1.y > p2.y){
                    if(arr[p2.x][p2.y+1] =='X' && arr[p2.x+1][p2.y] == 'X') return true;
                    else return false;
                }
                 //  p1이 p2 오른쪽 위 대각선에 위치하는가?
                else{
                    if(arr[p2.x][p2.y+1] =='X' && arr[p2.x-1][p2.y] == 'X') return true;
                    else return false;
                }
            }
            
        }
        
    }
    
    public int[] solution(String[][] places) {
        int[] answer = {};
        
        N = places.length;    
        
        result = new int[N];
        for(int i = 0; i < N ; i++){
            sol(places[i], i);
        }
        answer = result;
        
        return answer;
    }
}