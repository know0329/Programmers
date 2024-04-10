import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean isValid(char [][] tictakto){
        int oCount = 0;
        int xCount = 0;
        boolean oTicTakto = false;
        boolean xTicTakto = false;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(tictakto[i][j] == 'O') oCount++;
                else if(tictakto[i][j] == 'X') xCount++;

            }
        }

        String r0 = tictakto[0][0] + Character.toString(tictakto[0][1]) + tictakto[0][2];
        String r1 = tictakto[1][0] + Character.toString(tictakto[1][1]) + tictakto[1][2];
        String r2 = tictakto[2][0] + Character.toString(tictakto[2][1]) + tictakto[2][2];

        String c0 = tictakto[0][0] + Character.toString(tictakto[1][0]) + tictakto[2][0];
        String c1 = tictakto[0][1] + Character.toString(tictakto[1][1]) + tictakto[2][1];
        String c2 = tictakto[0][2] + Character.toString(tictakto[1][2]) + tictakto[2][2];

        String d0 = tictakto[0][0] + Character.toString(tictakto[1][1]) + tictakto[2][2];
        String d1 = tictakto[0][2] + Character.toString(tictakto[1][1]) + tictakto[2][0];

        if(r0.equals("OOO") || r1.equals("OOO") || r2.equals("OOO") ||
                c0.equals("OOO") || c1.equals("OOO") || c2.equals("OOO") ||
        d0.equals("OOO") || d1.equals("OOO")) oTicTakto = true;

        if(r0.equals("XXX") || r1.equals("XXX") || r2.equals("XXX") ||
                c0.equals("XXX") || c1.equals("XXX") || c2.equals("XXX") ||
                d0.equals("XXX") || d1.equals("XXX")) xTicTakto = true;


        if(!xTicTakto && oTicTakto && oCount == xCount && xCount >= 3) return true;
        if(!oTicTakto && xTicTakto && xCount - oCount == 1 && xCount >= 3) return true;
        if(xCount == 5 && oCount == 4 && !xTicTakto && !oTicTakto) return true;

        return false;
    }

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        while(!s.equals("end")){
           char [][] tictakto = new char[3][3];
           for(int a = 0; a < 9; a++){
               int i =  a / 3;
               int j = a % 3;
               tictakto[i][j] = s.charAt(a);
           }
           if(isValid(tictakto)) sb.append("valid");
           else sb.append("invalid");

           sb.append("\n");



            s = br.readLine();
        }
        System.out.println(sb);
    }

}
