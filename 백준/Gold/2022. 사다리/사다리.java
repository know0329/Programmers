import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(stk.nextToken());
        double y = Double.parseDouble(stk.nextToken());
        double c = Double.parseDouble(stk.nextToken());
        
        double left = 0, right = Math.min(x, y);

        while (right - left >= 0.001) {
            double width = (left + right) / 2;
            double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(width, 2));
            double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(width, 2));
            double res = (h1 * h2) / (h1 + h2);

            if (res >= c) left = width;
            else right = width;
        }
        System.out.println(String.format("%.3f", right));
    }
}
