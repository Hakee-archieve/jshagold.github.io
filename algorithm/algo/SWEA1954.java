package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1954 {
/**
 * @since 2021. 2. 2.
 * @author itsmeyjc
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
 * @mem
 * @time
 * @caution
 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
		
		
		for(int test_case=1; test_case<=T; test_case++){
			int fore = 0; // 0=right, 1=left, 2=down, 3=up
			int count = 1;
			int size  = Integer.parseInt(br.readLine());
			int board[][] = new int[size][size];
			
			
			int curx, cury; // 달팽이 현재위치
			curx=0;
			cury=0;
			board[0][0] = count++;
			
			while(count <= size*size) {
				int nextx = curx+dir[fore%4][0];
				int nexty = cury+dir[fore%4][1];
				if(nextx<0 || nextx>=size || nexty<0 || nexty>=size || board[nextx][nexty]!=0) {
					fore++;
				}else {
					board[nextx][nexty] = count++;
					curx = nextx;
					cury = nexty;
				}
			}
			
			System.out.println("#"+test_case);
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					System.out.print(board[j][i]+" ");
				}
				System.out.println();
			}
		}
	}

}
