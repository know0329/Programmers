import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class B{
        int high;
        int index;
    }

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int [] building = new int [N];
        int [] result = new int [N];
        stk = new StringTokenizer(br.readLine());

        for(int i = 0; i < N ; i++){
            building[i] = Integer.parseInt(stk.nextToken());
        }
        Stack<B> stack1 = new Stack<>();
        Stack<B> stack2 = new Stack<>();

        int count = 0;
        for(int build : building){
            B b = new B();
            b.high = build;
            b.index = count;
            stack1.push(b);
            count++;
        }

        while(!stack1.isEmpty()){
            B b = stack1.pop();
            if(stack1.isEmpty()){
                stack2.push(b);
                break;
            }
            B p = stack1.peek();
            if(p.high >= b.high){
                result[b.index] = p.index+1;
                while(!stack2.isEmpty()){
                    if(stack2.peek().high > p.high) break;
                    else{
                        B b2 = stack2.pop();
                        result[b2.index] = p.index+1;
                    }
                }
            }
            else{
                stack2.push(b);
            }
        }
        while(!stack2.isEmpty()){
            B b = stack2.pop();
            result[b.index] = 0;
        }

        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
