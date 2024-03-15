import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {




        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] heights = new int[1001]; 

            for (int i = 0; i < n; i++) {
                int l = scanner.nextInt();
                int h = scanner.nextInt();
                heights[l] = h;
            }

            System.out.println(calculateArea(heights));
            scanner.close();
        }

        public static int calculateArea(int[] heights) {
            int max_height = 0;
            int max_index = 0;
            int left_max = 0;
            int right_max = 0;
            int area = 0;

            // 가장 높은 기둥 찾기
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] > max_height) {
                    max_height = heights[i];
                    max_index = i;
                }
            }

            // 왼쪽에서 가장 높은 기둥까지의 사각형 계산
            for (int i = 0; i <= max_index; i++) {
                if (heights[i] > left_max) {
                    left_max = heights[i];
                }
                area += left_max;
            }

            // 오른쪽에서 가장 높은 기둥까지의 사각형 계산
            for (int i = heights.length - 1; i >= max_index; i--) {
                if (heights[i] > right_max) {
                    right_max = heights[i];
                }
                area += right_max;
            }

            // 가장 높은 기둥의 넓이 제외
            area -= max_height;

            return area;
        }


}
