import java.util.*;
import java.io.*;
public class Main {

    static int N, M;
    static List<Integer>[] party;
    static int [] parent;

    static List<Integer> truthList;
    public static void union(int x, int y) {
        int nx = find(x); //x의 부모노드 찾기
        int ny = find(y); //y의 부모노드 찾기

        if(truthList.contains(ny)) {
            int tmp = nx;
            nx = ny;
            ny =tmp;
        }

        parent[ny] = nx;
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken()); // 사람 수
        M = Integer.parseInt(stk.nextToken()); // 파티 수
        parent = new int [N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        truthList = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        int recognizedN = Integer.parseInt(stk.nextToken()); // 진실을 아는 사람 수
        if(recognizedN == 0) {
            System.out.println(M);
            return;
        }

        for(int i = 0; i < recognizedN; i++){
            int person = Integer.parseInt(stk.nextToken());
            truthList.add(person);
        }

        party = new ArrayList[M];
        for(int i = 0; i < M; i++){
            party[i] = new ArrayList<>();
            stk = new StringTokenizer(br.readLine());
            int partyN = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());
            party[i].add(x);
            for(int j = 1; j < partyN; j++){
                int y = Integer.parseInt(stk.nextToken());
                union(x,y);
                party[i].add(y);
            }
        }
        int cnt = 0;
        for(int i = 0; i < M; i++) {
            boolean flag = true;
            for(int num : party[i]) {
                if(truthList.contains(find(parent[num]))) {
                    flag= false;
                    break;
                }
            }
            if(flag) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
