import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    // 3가지 패턴 : 주식 구매, 주식 팔기, 아무것도 안하기
    // 주식 가격을 날 별로 알려 주었을 때 최대 이익이 얼마나 되는지 계산해라

   static void getMaxIndex(int start, int [] stocks){
       int maxValue = 0;
       int maxIndex = -1;
       for(int i = start; i < stocks.length; i++){
          if(maxValue < stocks[i]){
              maxValue = stocks[i];
              maxIndex = i;
          }
       }
       if(maxIndex != -1){
           maxIndexs.add(maxIndex);
       }

       if(maxIndex < stocks.length -1){
           getMaxIndex(maxIndex +1, stocks);
       }
   }

    static long  result;
    static List<Integer> maxIndexs;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(stk.nextToken());
        for(int t = 0; t < T ; t++){
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            maxIndexs = new ArrayList<>();
            int [] stocks  = new int [N];
            long result = 0;
            stk = new StringTokenizer(br.readLine());


            for(int i = 0; i < stocks.length; i++){
                int stock = Integer.parseInt(stk.nextToken());
                stocks[i] = stock;
            }
            int max = stocks[N-1];
            for(int j=N-2;j>=0;j--) {
                if(stocks[j] <= max)	//가장 큰 시세보다 작은 시세일 때 판매!
                    result += max - stocks[j];
                else		//가장 큰 시세보다 큰 시세 탐색시 바꾸기
                    max = stocks[j];
            }
            System.out.println(result);

        }

    }
}
