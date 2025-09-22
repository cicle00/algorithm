class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max0 = 0;
        int max1 = 0;
        
        for(int i =0; i<sizes.length;i++){
            if(sizes[i][0]<sizes[i][1]){ //세로가 더 길면 가로 세로 바꾸기
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }           
            if(max0<sizes[i][0]) max0 = sizes[i][0];
            if(max1<sizes[i][1]) max1 = sizes[i][1];
        }
        answer = max0 * max1;
        return answer;
    }
}