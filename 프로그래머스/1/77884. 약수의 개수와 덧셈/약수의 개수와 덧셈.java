class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<right+1;i++){
            //약수 짝/홀 구분
            if(count(i) % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
    
    //약수 개수 구하기
    public int count(int n){
        int num = 0; 
        for(int i=1;i<=n;i++){
            if(n % i == 0) num++; //약수이면 개수 증가
        }
        return num;
    }
}