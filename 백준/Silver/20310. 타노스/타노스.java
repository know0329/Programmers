import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static String S ;
    static List<String> list = new ArrayList<>();
    static void sol(String [] str, int oneCount, int zeroCount){
        if(oneCount == 1 || zeroCount == 1){
            return;
        }

        List<Integer> one = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();


        for(int i = 0; i < oneCount+zeroCount; i++){
            int zeroIndex = oneCount + zeroCount - 1 - i;

            if(zero.size() == zeroCount/2){
                break;
            }

            if(str[zeroIndex].equals("0")){
                zero.add(zeroIndex);
            }



        }
        for(int i = 0; i < oneCount+zeroCount; i++){
            int oneIndex = i;

            if(one.size() == oneCount/2){
                break;
            }


            if(str[oneIndex].equals("1")){
                one.add(oneIndex);
            }
        }
        if(zero.size() == zeroCount/2 && one.size() == oneCount/2){
            String newS = "";
            for(int j = 0; j < S.length(); j++){
                if(!one.contains(j) && !zero.contains(j)){
                    newS += S.charAt(j);
                }
            }
            S = newS;
            list.add(S);
            sol(S.split(""), oneCount/2, zeroCount/2);

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        S = stk.nextToken();
        int oneCount = 0;
        int zeroCount = 0;

        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '1'){
                oneCount ++;
            }
            else{
                zeroCount ++;
            }
        }
        sol(S.split(""), oneCount, zeroCount);
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
