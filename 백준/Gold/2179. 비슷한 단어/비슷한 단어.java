import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int getPrefixLength(String word1, String word2) {
        int length = Math.min(word1.length(), word2.length());
        int prefixLength = 0;
        for (int i = 0; i < length; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                prefixLength++;
            } else {
                break;
            }
        }
        return prefixLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        String [] words = new String[N];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;  i< N; i++){
            stk = new StringTokenizer(br.readLine());
            words[i] = stk.nextToken();
            map.put(words[i], i);
        }
        String S = "";
        String T = "";
        int maxPrefixLength = 0;
        for (int i = 0; i < N; i++) {
            String currentWord = words[i];
            for (int j = i + 1; j < N; j++) {
                String nextWord = words[j];
                int prefixLength = getPrefixLength(currentWord, nextWord);
                if (prefixLength > maxPrefixLength) {
                    maxPrefixLength = prefixLength;
                    S = currentWord;
                    T = nextWord;
                }
            }
        }
        System.out.println(S);
        System.out.println(T);

    }
}
