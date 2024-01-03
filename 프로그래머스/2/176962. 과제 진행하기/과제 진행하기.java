import java.util.*;
class Solution {
    static class Work implements Comparable<Work> {
        String name;
        int hour;
        int minute;
        int time;
        
        Work(String name, String start, String time){
            this.name = name;
            this.time = Integer.parseInt(time);
            String [] splitTime = start.split(":");
            this.hour = Integer.parseInt(splitTime[0]);
            this.minute = Integer.parseInt(splitTime[1]);
          
        }
        
        @Override
        public int compareTo(Work o) {
            if(this.hour == o.hour){
                return this.minute - o.minute;
            }
            else{
                return this.hour - o.hour;
            }
        }
      
    }
    
    static int[] plus(int curHour, int curMinute, int p){
        int hour = curHour;
        int minute = curMinute;
        if(minute + p >= 60){
            hour += (minute + p) / 60;
            minute = (minute + p) % 60;
        }
        else{
            minute += p;
        }
        int [] result = {hour, minute};
        return result;
    }
    public String[] solution(String[][] plans) {
        String[] answer = {};
        List<Work> workList = new ArrayList<>();
        Stack<Work> workStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(String [] plan : plans){
            workList.add(new Work(plan[0], plan[1], plan[2]));
        }
        Collections.sort(workList);
        int index = 0;
        while(index < workList.size() - 1){
            Work cur = workList.get(index);
            Work next = workList.get(index + 1);
            int workable = (next.hour - cur.hour) * 60 + (next.minute - cur.minute);
            if(workable < cur.time){
                cur.time = cur.time - workable;
                workStack.push(cur);
            }
            else{
                sb.append(cur.name + " ");
                if(!workStack.isEmpty()){
                    int restTime = workable - cur.time;
                    do {
                        Work leftover = workStack.pop();
                        if(leftover.time > restTime){
                            leftover.time -= restTime;
                            restTime = 0;
                            workStack.push(leftover);
                        }
                        else{
                            sb.append(leftover.name + " ");
                            restTime -= leftover.time;
                        }
                    }
                    while(restTime > 0 && !workStack.isEmpty());
                    
                }
                
            }
            index++;
        }
        sb.append(workList.get(workList.size() - 1).name + " ");
        while(!workStack.isEmpty()) {
            Work rest = workStack.pop();
            sb.append(rest.name + " ");
        }
        System.out.println(sb);
        String [] result = sb.toString().split(" ");
        answer = result;
        return answer;
    }
}