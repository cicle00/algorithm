class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length() == 4 || s.length() == 6){ //문자열 길이 확인
            try{ //숫자 확인
                Integer.parseInt(s);
                answer = true;
            } catch(NumberFormatException ex){
                //숫자가 아니면 false
            }
            
            
        }
        return answer;
    }
}