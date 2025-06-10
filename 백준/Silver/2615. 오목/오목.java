import java.io.*;
import java.util.*;

public class Main {
	static int N = 19;
	static int[][] board = new int[N][N];
	static int winner = 0;
	static int[][] dir = {{0,1}, {1,0}, {1,1}, {-1,1}};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0;i<19;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<19;j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int x = 0;
        int y = 0;
        
        for(int i=0;i<19;i++) {
        	for(int j=0;j<19;j++) {
        		if(board[i][j]!=0) {
        			if(checkFive(i,j)) {
        				x=i+1;
        				y=j+1;
        				break;
        			}
        		}
        	}
        }
        
        System.out.println(winner);
        if(winner!=0) System.out.println(x+" "+y);
    }


    private static boolean checkFive(int x, int y) {
        int color = board[x][y];
        for(int d = 0; d < 4; d++) {
            int cnt = 1;
            int dx = dir[d][0];
            int dy = dir[d][1];

            int nx = x + dx;
            int ny = y + dy;

            while (inRange(nx, ny) && board[nx][ny] == color) {
                cnt++;
                if(cnt > 5) break; // 6목 방지
                nx += dx;
                ny += dy;
            }

            // 반대 방향 확인
            nx = x - dx;
            ny = y - dy;
            while (inRange(nx, ny) && board[nx][ny] == color) {
                cnt++;
                if(cnt > 5) break;
                nx -= dx;
                ny -= dy;
            }

            if (cnt == 5) {
                int prevX = x - dx;
                int prevY = y - dy;
                int nextX = x + dx * 5;
                int nextY = y + dy * 5;
                if ((inRange(prevX, prevY) && board[prevX][prevY] == color) ||
                    (inRange(nextX, nextY) && board[nextX][nextY] == color)) {
                    continue;
                }

                winner = color;
                return true;
            }
        }
        return false;
    }
    
    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}
