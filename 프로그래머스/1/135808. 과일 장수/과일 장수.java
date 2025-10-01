import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int length = score.length;
        Arrays.sort(score);
        int idx = length;
        while(idx>=m){
            idx -= m;
            answer += score[idx] * m;
        }
        return answer;
    }
}