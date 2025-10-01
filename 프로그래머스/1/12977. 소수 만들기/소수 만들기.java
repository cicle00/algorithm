class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        //3개 숫자 더하기
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int num = nums[i]+nums[j]+nums[k];
                    if(isPrime(num)) answer++;
                }
            }
        }

        System.out.print("[");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
            if(i!=nums.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]를 이용해서 "+answer+"을 만들 수 있습니다.");

        return answer;
    }
    
    public boolean isPrime(int num){
        int count = 0;
        for(int i=2;i<num;i++){
            if(num%i==0) count++;
        }
        
        if(count>0) return false;
        else return true;
    }
}