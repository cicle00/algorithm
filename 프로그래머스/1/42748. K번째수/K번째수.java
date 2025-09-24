import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];
        
        for(int i=0;i<length;i++){
            int[] temp = new int[commands[i][1]-commands[i][0]+1];
            for(int j=commands[i][0]-1;j<commands[i][1];j++){
                temp[j-commands[i][0]+1] = array[j];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        
        return answer;
    }
}