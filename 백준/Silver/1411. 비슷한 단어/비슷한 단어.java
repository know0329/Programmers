import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 // 숌스럽게 : 단어 A에 등장하는 모든 알파벳을 다른 알파벳으로 바꾼다는 소리
 // 단어 abca와 zbxz는 비슷하다. 그 이유는 a를 z로 바꾸고, b는 그대로 b, c를 x로 바꾸면, abca가 zbxz가된다.
 // 단어의 길이는 최대 50이고, N은 100보다 작거나 같은 자연수
public class Main {

    static class Showm{
        String s1;
        String s2;

        Showm(String s1, String s2){
            this.s1 = s1;
            this.s2 = s2;
        }
        @Override
        public boolean equals(Object o){
            if(this.getClass() != o.getClass()) return false;
            else{
                if(this.s1.equals(((Showm) o).s1) && (this.s2.equals(((Showm) o).s2)) )return true;
                else return false;
            }
        }

    }
    static Set<Showm> set;

    static boolean isShowm(String s1, String s2){
        char [] alphabets = new char[26];
        for(int i = 0 ; i < 26; i++){
            alphabets[i] = '.';
        }
        StringBuilder newS = new StringBuilder();
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)) {
                if(alphabets[s1.charAt(i) - 'a'] == '.'){
                    for(int j = 0; j < 26; j++ ){
                        if(alphabets[j] == s2.charAt(i) ) return false;
                    }
                    alphabets[s1.charAt(i) - 'a'] = s2.charAt(i);
                }
                else{
                    if(s1.charAt(i) != alphabets[s2.charAt(i) - 'a']) return false;
                }
                newS.append(s2.charAt(i));
            }
            else{
                if(alphabets[s1.charAt(i) - 'a'] == '.'){
                    for(int j = 0; j < 26; j++ ){
                        if(alphabets[j] == s2.charAt(i) ) return false;
                    }
                    alphabets[s1.charAt(i) - 'a'] = s2.charAt(i);
                    newS.append(s2.charAt(i));
                }
                else{
                    newS.append(alphabets[s1.charAt(i) - 'a']);
                }
            }
        }
        if(newS.toString().equals(s2)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        String [] words = new String[N];
        set = new HashSet<>();
        for(int i = 0; i < N; i++){
            stk = new StringTokenizer(br.readLine());
            words[i] = stk.nextToken();
        }
        for(int i = 0;  i< N; i++){
            for(int j = i+1; j < N; j++){
                if(words[i].equals(words[j])) continue;
                if(isShowm(words[i], words[j])){
                    set.add(new Showm(words[i], words[j]));
                }
            }
        }
        System.out.println(set.size());
    }
}
