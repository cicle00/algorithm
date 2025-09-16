import java.util.*;

class Solution {
    public String solution(String s) {
        int length = s.length();
        //배열로 변환
        char[] str = new char[length];
        for(int i=0;i<length;i++){
            str[i] = s.charAt(i);
        }
        //정렬
        Arrays.sort(str);
        String answer = "";
        //거꾸로 더하기
        for(int i=length-1;i>=0;i--) answer += str[i];
        return answer;
    }
}