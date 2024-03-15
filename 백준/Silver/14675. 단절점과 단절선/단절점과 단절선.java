import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> adj ;
    static StringBuilder sb;

    static boolean checkNode(int node) {
        int count = 0;
        for(int i = 0;  i < adj.get(node).size(); i++){
            count++;

        }
        if(count >= 2){
            return false;
        }
        else{
            return true;
        }

    }


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a-1).add(b-1);
            adj.get(b-1).add(a-1);

        }


        st = new StringTokenizer(br.readLine());

        int Q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(t == 1){
                if(!checkNode(k-1)){
                    sb.append("yes\n");
                }
                else{
                    sb.append("no\n");
                }
            }
            else {
                sb.append("yes\n");

            }
        }
        System.out.println(sb);
    }
}
