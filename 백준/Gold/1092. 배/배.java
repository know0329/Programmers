
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, result;

    static List<Integer> cranes, boxs;

    static void sol(){

        int second = 0;


        while(!boxs.isEmpty()){
            int index = 0;
            for(int i = 0; i < N;){
                if(index == boxs.size()) break;
                else if(cranes.get(i) >= boxs.get(index)){
                    boxs.remove(index);
                    i++;
                }
                else{
                    index++;
                }
            }
            second++;
        }

        result = second;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
      
        N = Integer.parseInt(stk.nextToken()); // 최대 50

        cranes = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cranes.add(Integer.parseInt(stk.nextToken())); // 1,000,000 이하
        }

        stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken()); // 10,000이하

        boxs = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            boxs.add(Integer.parseInt(stk.nextToken())); // 1,000,000 이하
        }
        cranes.sort(Collections.reverseOrder());
        boxs.sort(Collections.reverseOrder());
        if(cranes.get(0) < boxs.get(0)){
            System.out.println(-1);
        }
        else{
            result = 0;
            sol();
            System.out.println(result);
        }
       
    }
}
