
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static String S;

    static int result;

    static int [] alpha;

    public static void sol(int index, char pre){
        
        if (index==S.length()){
            result++;
            return;
        }

        for (int i = 0; i < 27; i++){
         
            if (alpha[i]==0)continue;

            if (pre != (char) (i+'a')){
                alpha[i]--;
                sol(index+1, (char)(i+'a'));
                alpha[i]++;
            }

        }
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        S = stk.nextToken(); // 최대 10
        result = 0;
        alpha = new int[27];
        for (int i = 0; i < S.length(); i++){
            alpha[S.charAt(i)-'a']++;
        }
            
        sol( 0, '\n');
        System.out.println(result);
    }
}
