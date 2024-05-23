import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()); // 건물 수
        int a = Integer.parseInt(stk.nextToken()); // 가희가 볼 수 있는 건물 수
        int b = Integer.parseInt(stk.nextToken()); // 단비가 볼 수 있는 건물 수
        List<Integer> tower = new ArrayList<>();


        int count = 0;

        for(int i = 1; i <= a-1; i++){
            tower.add(i);
            count++;
        }

        tower.add(Math.max(a, b));
        for(int i = b-1; i >= 1 ; i--){
            tower.add(i);
            count++;
        }

        if (a == 1) {
            while (tower.size() < N) {
                tower.add(1, 1);
            }
        } else {
            while (tower.size() < N) {
                tower.add(0, 1);
            }
        }
        if(tower.size() > N) System.out.println(-1);
        else{
            for (int i : tower) {
                System.out.print(i + " ");
            }
        }

    }
}
