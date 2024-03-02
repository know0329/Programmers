import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static String [] keywords;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            String s = stk.nextToken();
            set.add(s);
        }

        for(int j = 0;  j < M; j++){
            stk = new StringTokenizer(br.readLine());
            String str = stk.nextToken();
            String [] memo = str.split(",");
            for(String keyword : memo){
                if(set.contains(keyword)){
                    set.remove(keyword);
                }
            }

            sb.append(set.size() + "\n");
        }
        System.out.println(sb);
    }
}
