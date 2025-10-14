class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<number+1;i++){
            if(countDivisors(i)>limit){
                answer+=power;
            }else{
                answer+=countDivisors(i);
            }
        }
        return answer;
    }
    
    public int countDivisors(int n){
        int count = 0;
        for(int i=1;i*i<n+1;i++){
            if(n%i == 0) {
                if(i*i==n) count++;
                else count+=2;
            }     
        }
        return count;
    }
}