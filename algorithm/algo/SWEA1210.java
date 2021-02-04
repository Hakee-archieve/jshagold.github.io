package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA1210 {
/**
 * @since 2021. 2. 2.
 * @author itsmeyjc
 * @see
 * @mem
 * @time
 * @caution
 */
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int dr[] = {1,-1};
		int board[][] = new int[100][100];
		for(int test_case=1; test_case<=10; test_case++) {
			
			int curx, cury;
			int dir = 0; // -1=left, 1=right, 0=up
			curx = 0;
			cury = 99;
			int ans = 0;
			br.readLine();
			
			
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					board[j][i] = Integer.parseInt(st.nextToken());

					if(board[j][i] == 2) curx = j;
				}
			}
			
			
			
			while(cury != 0) {
				if(board[curx][cury-1] == 1) {
					cury = cury - 1;
					
					int nextx;
					for(int i=0; i<2; i++) {
						nextx = curx+dr[i];
						if(nextx >=0 && nextx < 100 && board[nextx][cury] == 1) {
							curx = nextx;
							dir = dr[i];
							break;
						}
					}
				}else {
					curx = curx + dir;
				}
			}
			ans = curx;
			
			
			System.out.println("#"+test_case+" "+ans);
		}
	}

}
