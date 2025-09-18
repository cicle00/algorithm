class Solution {
    public int solution(int n) {
        int answer = 0;
        //삼진법 거꾸로 저장하기
        String res = "";
        
        while(n>0){
            int d = n % 3;
            res = res + d;
            n = n / 3;
        }
        //십진법 변환
        int p = 1;

        for (int i = res.length() - 1; i >=0 ; i--) {
            int digit = res.charAt(i) - '0'; 
            answer += digit * p;
            p *= 3;
        }

        return answer;
    }
}