class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int left = 0;
        int bottle = 0;
        while(n >= a){
            bottle += n / a * b;
            n = n / a * b + n % a;
        }
        answer = bottle;
        return answer;
    }
}