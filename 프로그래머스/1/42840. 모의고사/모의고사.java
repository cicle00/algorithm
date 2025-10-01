import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int length = answers.length;
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};
        
        for(int i=0;i<length;i++){
            if(answers[i] == student1[i%5]){
                score[0]++;
            }
            if(answers[i] == student2[i%8]){
                score[1]++;
            }
            if(answers[i] == student3[i%10]){
                score[2]++;
            }
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        for(int i=0;i<3;i++){
            if(max == score[i]){
                answer.add(i+1);
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}