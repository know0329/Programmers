
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 전화번호 목록이 일관성을 유지하려면, 한 번호가 다른 번호의 접두어인 경우가 없어야 한다
    static List<String> phoneNumList;

    static Map<String, Integer> map;


    static  boolean sol(){
        
        for (int i = 0; i < phoneNumList.size(); i++)
            map.put(phoneNumList.get(i), i);

        
        for (int i = 0; i < phoneNumList.size(); i++)
            for (int j = 0; j < phoneNumList.get(i).length(); j++)
                if (map.containsKey(phoneNumList.get(i).substring(0, j)))
                    return false;
        return true;

    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(stk.nextToken());


        for(int t = 0; t < T; t++){
            stk = new StringTokenizer(br.readLine());
            phoneNumList = new ArrayList<>();
            map = new HashMap<>();
            int N = Integer.parseInt(stk.nextToken());
            for(int i = 0; i < N; i++){
                stk = new StringTokenizer(br.readLine());
                String phoneNum = stk.nextToken();
                phoneNumList.add(phoneNum);

            }
            if(sol()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }


    }
}
