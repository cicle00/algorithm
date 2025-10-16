import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n+1];
        Arrays.fill(students, 1);
        
        for(int i=0;i<reserve.length;i++){
            students[reserve[i]] = 2;
        }
        
        for(int i=0;i<lost.length;i++){
            if(students[lost[i]] == 2){
                students[lost[i]] = 1;
            }else{
                students[lost[i]] = 0;
            }
        }
        
        for(int i=1;i<=n;i++){
            if(students[i] == 0){
                if(students[i-1] == 2){
                    students[i-1] = 1;
                    answer++;
                }else if(i < n && students[i+1] == 2){
                students[i+1] = 1;
                answer++;
                }
            }else{
                answer++;
            }
        }
        return answer;
    }
}