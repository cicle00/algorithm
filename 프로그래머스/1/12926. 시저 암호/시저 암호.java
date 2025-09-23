class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(char a:s.toCharArray()){
            if(Character.isUpperCase(a)) a = (char)('A'+(a-'A'+n)%26);
            else if(Character.isLowerCase(a)) a = (char)('a'+(a-'a'+n)%26);
            answer = answer + a;
        }
        return answer;
    }
}