import java.awt.print.PrinterGraphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static void isZero(String str){
        String newStr = str.replace(" ", "");
        String [] numArr = newStr.split("[\\+\\-]");
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        for(int i = 0; i < newStr.length(); i++){
            char c = newStr.charAt(i);
            if(c == '+'){
                operators.add('+');
            }
            else if(c == '-'){
                operators.add('-');
            }
        }

        for(String num : numArr){
            numbers.add(Integer.parseInt(num));
        }

        int sum = numbers.get(0);
        for(int i = 0; i < operators.size(); i++){
            if(operators.get(i) == '+') sum += numbers.get(i+1);
            else sum -= numbers.get(i+1);
        }

        if(sum == 0){
            sb.append(str).append("\n");
        }


    }
    static void makeModification(int N, int count, String s){
        if(count == N){
            isZero(s+N);
            return;
        }
        makeModification(N, count+1, s+count+" ");
        makeModification(N, count+1, s+count+"+");
        makeModification(N, count+1, s+count+"-");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(stk.nextToken());
        sb = new StringBuilder();
        for(int t = 0; t < T ; t++){

            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            makeModification(N, 1, "");
            sb.append("\n");

        }
        System.out.print(sb);
    }
}
