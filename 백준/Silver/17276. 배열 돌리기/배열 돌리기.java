import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, angle;
    static int [][] matrix;
    static int [][] deepCopy(){
        int [][] copyM = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                copyM[i][j] = matrix[i][j];
            }
        }
        return copyM;
    }
    static void sol(){
        int count = Math.abs(angle) / 45;
        while(count-- > 0){
            rotation(angle > 0, deepCopy());
        }

        output();
    }
    static void output(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void rotation(boolean flag, int [][] original){

        rotateMainDiagonal(flag, original);
        rotateCenterRow(flag, original);
        rotateSubDiagonal(flag, original);
        rotateCenterColumn(flag, original);
    }
    static void rotateMainDiagonal(boolean flag, int [][] original){
        if(flag){
            for(int i = 0; i < N; i++){
                matrix[i][N/2] = original[i][i];
            }
        }
        else{
            for(int i = 0; i < N; i++){
                matrix[N/2][i] = original[i][i];
            }
        }
    }
    static void rotateCenterRow(boolean flag, int [][] original){
        if(flag){
            for(int i = 0; i < N; i++){
                matrix[i][N-i-1] = original[i][N/2];
            }
        }
        else{
            for(int i = 0; i < N; i++){
                matrix[i][i] = original[i][N/2];
            }
        }
    }
    static void rotateSubDiagonal(boolean flag, int [][] original){
        if(flag){
            for(int i = 0; i < N; i++){
                matrix[N/2][N-i-1] = original[i][N-i-1];
            }
        }
        else{
            for(int i = 0; i < N; i++){
                matrix[i][N/2] = original[i][N-i-1];
            }
        }
    }
    static void rotateCenterColumn(boolean flag, int [][] original){
        if(flag){
            for(int i = 0; i < N; i++){
                matrix[i][i] = original[N/2][i];
            }
        }
        else{
            for(int i = 0; i < N; i++){
                matrix[N-i-1][i] = original[N/2][i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        T = Integer.parseInt(stk.nextToken());
        for(int t = 0;  t < T; t++){
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            angle = Integer.parseInt(stk.nextToken());
            matrix = new int [N][N];
            for(int i = 0; i < N; i++){
                stk = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    matrix[i][j] = Integer.parseInt(stk.nextToken());
                }
            }
            sol();
        }

    }
}
