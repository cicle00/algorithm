import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(trees[i]>max) max = trees[i];
		}
		
		/*Arrays.sort(trees);*/
        //정렬 계산 비용 불필요
		
		boolean success = false;
		
		int start = 0;
		/*int end = trees[N-1];*/
		int end = max;
		int result = 0;
		
		 while (start <= end) {
	            int mid = (start + end) / 2;
	            long total = cutWoods(trees, mid);

	            if (total >= M) {
	                result = mid;
	                start = mid + 1;
	            } else {
	                end = mid - 1;
	            }
	        }
		 System.out.println(result);
		
	}
	
	public static long cutWoods(int[] trees, int height) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > height) {
                sum += tree - height;
            }
        }
        return sum;
    }
}
