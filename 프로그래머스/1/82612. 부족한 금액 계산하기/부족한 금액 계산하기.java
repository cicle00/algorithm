class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        //총 금액 구하기: price*count 반복
        long total = 0;
        for(int i=1;i<=count;i++){
            total += price * i;
        }
        //총금액-money
        answer = total - money;
        
        //금액이 부족하지 않은 경우
        if(answer<0) return 0;

        return answer;
    }
}