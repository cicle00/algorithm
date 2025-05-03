import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] triNum = new int[44]; //1000 이하의 삼각수 44*45/2 44개
		
		for(int i=0;i<44;i++) {
			triNum[i] = (i+1)*(i+2)/2;
		}
		
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			boolean pos = false;
			
			for(int i=0;i<44;i++) {
				for(int j=0;j<44;j++) {
					for(int k=0;k<44;k++) {
						int num;
						num = triNum[i]+triNum[j]+triNum[k];
						
						if(num == N) pos = true;
						if(pos) break;
					}
					if(pos) break;
				}
				if(pos) break;
			}
			if(pos) System.out.println(1);
			else System.out.println(0);
		}
		
		
	}
}

