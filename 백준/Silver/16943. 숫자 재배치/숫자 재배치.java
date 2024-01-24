
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, result;

    static String strA;

    static int [] numCount;

    static void sol(String C){
        if(C.length() == strA.length()){
            int intC = Integer.parseInt(C);
            if(intC < B){
                result = Math.max(intC, result);
            }
            return;
        }
        for (int i = 0; i < 10; i++){

            if (numCount[i]==0)continue;
            if (C.length() == 0 && i == 0) continue;

            numCount[i]--;
            sol(C + Integer.toString(i));
            numCount[i]++;


        }
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        strA = stk.nextToken();
        A = Integer.parseInt(strA);
        B = Integer.parseInt(stk.nextToken());

        if(strA.length() > Integer.toString(B).length()){
            System.out.println(-1);
        }
        else{
            result = -1;
            numCount = new int[10];
            for(int i = 0; i < strA.length(); i++){
                numCount[strA.charAt(i) - '0']++;
            }
            sol("");
            System.out.println(result);
        }
    }
}
