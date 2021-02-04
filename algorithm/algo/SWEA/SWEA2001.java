package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
/**
 * @since 2021. 2. 3.
 * @author itsmeyjc
 * @see
 * @mem
 * @time
 * @caution
 */
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=T; test++) {
			StringBuilder sb = new StringBuilder();
			int ans=0;
			int N,M,max;
			max=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int board[][] = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer stt = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[j][i] = Integer.parseInt(stt.nextToken());
				}
			}
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					ans = findMax(M,j,i,ans,board);
				}
			}
			
			
			
			sb.append("#").append(test).append(" ").append(ans).append("\n");
			System.out.print(sb.toString());
		}
		
	}
	
	public static int findMax(int m, int w, int h, int max, int board[][]) {
		int sum = 0;
		for(int i=h; i<h+m; i++) {
			for(int j=w; j<w+m; j++) {
				sum += board[j][i];
			}
		}
		if(sum >= max) {
			return sum;
		}
		return max;
	}

}
