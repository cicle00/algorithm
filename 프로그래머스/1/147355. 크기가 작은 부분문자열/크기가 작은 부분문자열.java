class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        
        int start = 0;
        int end = length;
        Long ip = Long.parseLong(p);

        while(end <= t.length()){
            Long temp = Long.parseLong(t.substring(start, end));
            if(temp<=ip) answer++;
            start++;
            end++;
            
        }
        
        return answer;
    }
}

class Solution2 {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        
        int start = 0;
        int end = length;

        while(end <= t.length()){
            String temp = t.substring(start, end);
            if(temp.compareTo(p)<=0) answer++;
            start++;
            end++;
        }
        
        return answer;
    }
}
