import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 방이 없으면 방 생성, 방장 기준 -10 ~ 10까지 입장 가능
    // 방이 있으면, 입장 후 방이 다 찰 때까지 대기
    // 입장 가능한 방이 여러 개라면 먼저 생성된 방으로 입장
    // 방이 다 차면 게임 시작
    // 플레이어 수 p, 닉네임 n, 레벨 l, 방 정원 m
    // 최종적으로 만들어진 방의 상태와 입장 플레이어들을 출력

    static int p, l, m;

    static class Player implements Comparable <Player>{
        int level;
        String name;

        Player(int l , String n){
            level = l;
            name = n;
        }

        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }
    }

    static List<List<Player>> rooms;

    static int enterable(Player p){
        if(rooms.isEmpty()){
            return -1;
        }
        int count = 0;
        for(List<Player> room : rooms){
            Player p1 = room.get(0);
            if ((room.size() < m) && (p1.level - 10  <= p.level && p.level <= p1.level + 10)){
                return count;
            }
            count++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        p = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        rooms = new ArrayList<>();

        for(int i = 0; i < p; i++){
            stk = new StringTokenizer(br.readLine());
            l = Integer.parseInt(stk.nextToken());
            String n = stk.nextToken();
            Player p = new Player(l, n);
            int roomNum = enterable(p);
            if(roomNum >= 0){
                rooms.get(roomNum).add(p);
            }
            else{
                rooms.add(new ArrayList<>());
                rooms.get(rooms.size()-1).add(p);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(List<Player> room : rooms){
            Collections.sort(room);
            if(room.size() < m){
                sb.append("Waiting!\n");
            }
            else{
                sb.append("Started!\n");
            }

            for(Player p : room){
                sb.append(p.level).append(" ").append(p.name).append("\n");
            }

        }
        sb.replace(sb.toString().length()-1, sb.toString().length(), "");
        System.out.print(sb);

    }
}
