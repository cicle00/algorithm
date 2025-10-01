class Solution {
    public String solution(int a, int b) {
        String answer = "";
        //2월 29일 1-31 3-31 4-30 5-31 6-30 7-31 8-31 9-30 10-31 11-30 12-31
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int day = 0;
        for(int i = 0;i < a-1;i++){
            day += month[i];
        }
        day += b;
        
        answer = days[day % 7];
        return answer;
    }
}