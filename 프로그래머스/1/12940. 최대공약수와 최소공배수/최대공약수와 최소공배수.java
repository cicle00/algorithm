class Solution {
    public int[] solution(int n, int m) {
        int num = 0;
        if(n<m) num = n;
        else num = m;
        //최대공약수 조건
        int max = 1;
        for(int i=2;i<=num;i++){
            if(n%i == 0 && m%i ==0) max = i;
        }
        
        //최소공배수 조건
        int min = 0;
        min = (n * m) / max;
            
        int[] answer = {max, min};
        
        return answer;
    }
}