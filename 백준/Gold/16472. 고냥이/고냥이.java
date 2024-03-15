import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()); // 인식할 수 있는 알파벳 종류 수
        String str = br.readLine();
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        set.add(str.charAt(i));
        int result = 0;
        int len = str.length();

        if(len == 1) System.out.println(1);
        else{
            while(i <= j){
                result = Math.max(result, j - i);
                j++;
                if(j == len) break;
                set.add(str.charAt(j));

                if(set.size() > N){
                    set = new HashSet<>();
                    i++;
                    j = i;
                    set.add(str.charAt(i));
                }
            }

            System.out.println(result+1);
        }

    }
}
