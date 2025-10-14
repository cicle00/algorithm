class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zero = 0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i] == 0) zero++;
            for(int j=0;j<win_nums.length;j++){
                if(win_nums[j]==lottos[i]){
                    count++;
                    break;
                }
            }
        }
        
        answer = new int[] {rank(count+zero), rank(count)};

        return answer;
    }
    
    public int rank(int n){
        switch(n){
                case 6: return 1;
                case 5: return 2;
                case 4: return 3;
                case 3: return 4;
                case 2: return 5;
                default: return 6;
        }
    }
}