import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int  R, S;
    static char [][] picture;
    static int [][] groundAndStar;

    static void sol(){
        int count = 3001;
        for(int i = 0; i < S; i++){
            if(groundAndStar[i][0] < 0) continue;
            count = Math.min(groundAndStar[i][1]  - groundAndStar[i][0], count);

        }
        count--;
        for (int j = 0; j < S; j++) {
            for (int i = R - 1; i >= 0; i--) {
                if (picture[i][j] == 'X' && picture[i + count][j] == '.') {
                    char temp = picture[i][j];
                    picture[i][j] = picture[i + count][j];
                    picture[i + count][j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < S; j++){
               sb.append(picture[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken()); // 세로
        S = Integer.parseInt(stk.nextToken()); // 가로
        picture = new char[R][S];
        groundAndStar = new int [S][2];

        for(int i = 0; i < S; i++){
            groundAndStar[i][0] = -1;
            groundAndStar[i][1] = 3001;
        }
        for(int i = 0; i < R; i++){
            stk = new StringTokenizer(br.readLine());
            String str = stk.nextToken();
            for(int j = 0; j < S; j++){
                char c = str.charAt(j);
                picture[i][j] = c;
                if(c == 'X'){

                    groundAndStar[j][0] = Math.max(groundAndStar[j][0], i);

                }
                else if(c == '#'){
                    groundAndStar[j][1] = Math.min(groundAndStar[j][1], i);
                }
            }
        }
        sol();
    }
}
