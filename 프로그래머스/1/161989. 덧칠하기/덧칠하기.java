class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] walls = new boolean[n+1];
        
        for(int i=0;i<section.length;i++){
            walls[section[i]] = true;
        }
        for(int i=1;i<n+1;i++){
            if(walls[i]){
                i+=m-1;
                answer++;
            }
        }
        return answer;
    }
}