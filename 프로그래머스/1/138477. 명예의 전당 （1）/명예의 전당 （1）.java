import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int length = score.length;
        int[] answer = new int[length];
        PriorityQueue<Integer> record = new PriorityQueue<>();
        
        for(int i = 0;i < length;i++){
            record.add(score[i]);
            if (record.size() > k){
                record.poll();
            }
            answer[i] = record.peek();
        }
        
        return answer;
    }
}