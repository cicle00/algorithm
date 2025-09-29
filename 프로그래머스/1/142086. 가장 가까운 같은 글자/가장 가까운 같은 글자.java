import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        
        for(int i=1;i<s.length();i++){
            for(int j=i-1;j>=0;j--){ //뒤에서부터 확인
                char x = s.charAt(i);
                char k = s.charAt(j);
                
                if(x==k) {
                    answer[i] = i-j;
                    break;
                }
            }
        }
        
        return answer;
    }
}