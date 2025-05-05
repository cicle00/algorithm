import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int caseNum = 1; 
        
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int result = 0;
			
			if (L == 0 && P == 0 && V == 0) break;
			
			int last = V%P;
			
			result = (V/P)*L + Math.min(last, L); //나머지가 L보다 크면 L 출력
			System.out.println("Case " + caseNum++ + ": " + result);
		}
    }
}