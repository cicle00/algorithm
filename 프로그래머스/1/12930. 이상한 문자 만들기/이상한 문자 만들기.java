class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ", -1); //공백 기준으로 단어 자르기
        for(int i = 0; i < words.length; i++){ 
            String nWord = "";
            String word = words[i];
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if(j % 2 == 0) {
                    c = Character.toUpperCase(c);
                } else {
                    c = Character.toLowerCase(c);
                }
                nWord += c;
            }
            answer += nWord;
            if (i != words.length - 1) {   // 마지막 단어가 아니면 공백 추가
                answer += " ";
            }
        }
        
        return answer;
    }
}