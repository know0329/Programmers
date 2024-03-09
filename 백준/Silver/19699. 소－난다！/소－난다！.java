import java.util.*;
import java.io.*;

public class Main {

    static boolean [] visited;
    static Set<Integer> prime = new HashSet<>();

    static boolean isPrime(int n){
        if(n<2){
            return false;
        }else{
            for(int i = 2; i < n; i++){
                if(n % i == 0) return false;
            }
            return true;
        }
    }
    static void sol(int index, int count, int M, int sum, int [] cows){
        if(count == M){
            if(isPrime(sum)){
                prime.add(sum);
            }
            return;
        }
        for(int i = index; i < cows.length; i++){
            if(!visited[i]){
                visited[i] = true;
                sol(i+1, count+1, M, sum+cows[i], cows);
                visited[i] = false;
            }
        }
    }

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int [] cows = new int[N];
        visited = new boolean[N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cows[i] = Integer.parseInt(stk.nextToken());
        }
        sol(0,0, M, 0, cows);
        if(prime.isEmpty()){
            System.out.println(-1);
        }
        else{
            ArrayList<Integer> list = new ArrayList<>();
            for(int n : prime){
                list.add(n);
            }
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for(int n : list){
                sb.append(n + "\n");
            }
            System.out.println(sb);
        }

    }
}
