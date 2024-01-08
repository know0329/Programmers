
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();
    static int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    static int N;
    static void isDeclineNum(long num, int index){
        if (!list.contains(num)) {
            list.add(num);
        }

        if (index >= 10) {
            return;
        }

        isDeclineNum((num * 10 + arr[index]), index + 1);
        isDeclineNum(num, index + 1);
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());

        // 모든 수 만들어서 리스트 넣기
        isDeclineNum(0, 0) ;

        Collections.sort(list);

        if (N > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N - 1));
        }



    }
}
