class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int countX = 0;
        int countOther = 0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == x) countX++;
            else countOther++;
            
            if(countX == countOther){
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1);
                }
                answer++;
                countX = 0;
                countOther = 0;
            }
        }
        if(countX != countOther) answer++;
        return answer;
    }
}