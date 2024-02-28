import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static class Team implements Comparable<Team>{
        int id;
        int last;
        int count;
        int score;

        Team(int id, int last, int score){
            this.id = id;
            this.last = last;
            this.score = score;
            count = 1;
        }

        @Override
        public String toString(){
            return Integer.toString(this.id) + " " + Integer.toString(this.score) + " " + Integer.toString(this.count);
        }

        @Override
        public int compareTo(Team o) {
            if(this.score == o.score){
                if(this.count == o.count){
                    return this.last - o.last;
                }
                else{
                    return this.count - o.count;
                }
            }
            return  o.score -this.score ;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(stk.nextToken());

        for (int testcase = 0; testcase < T; testcase++) {
            stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken()); // 팀 수
            int k = Integer.parseInt(stk.nextToken()); // 문제 수
            int t = Integer.parseInt(stk.nextToken()); // 팀 ID
            int m = Integer.parseInt(stk.nextToken()); // 로그 엔트리 수

            int [][] problems = new int [n+1][k+1];
            HashMap<Integer, Team> map = new HashMap<>();
            List<Team> teams = new ArrayList<>();
            for (int log = 0; log < m; log++) {
                stk = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(stk.nextToken());
                int problem = Integer.parseInt(stk.nextToken());
                int score = Integer.parseInt(stk.nextToken());
                if(problems[id][problem] < score){
                    problems[id][problem] = score;
                }
                problems[id][0] ++;
                map.put(id, new Team(id, log, 0));
            }
            for(int id = 1; id < n+1; id++){
                int sumOfScore = 0;
                for(int s = 1; s < k+1; s++){

                    sumOfScore += problems[id][s];

                }
                Team team = map.get(id);
                team.score = sumOfScore;
                team.count = problems[id][0];
                teams.add(team);
            }

            Collections.sort(teams);
            for(int i = 0; i < teams.size(); i++){
                if(teams.get(i).id == t){
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
