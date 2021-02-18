package algoBack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1080 {
/**
 * @since 2021. 2. 18.
 * @author jshagold
 * @see
 * @mem
 * @time
 * @caution
 */
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Aboard[][] = new int[M][N];
		int Bboard[][] = new int[M][N];
		boolean check[][] = new boolean[M][N];
		int count=0;
		
		for(int i=0; i<N; i++) {
			String a = br.readLine();
			for(int j=0; j<M; j++) {
				Aboard[j][i] = Character.getNumericValue(a.charAt(j));
			}
		}
		for(int i=0; i<N; i++) {
			String b = br.readLine();
			for(int j=0; j<M; j++) {
				Bboard[j][i] = Character.getNumericValue(b.charAt(j));
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(Aboard[j][i] == Bboard[j][i]) {
					check[j][i] = true;
				}
			}
		}
		
		
		if(N>=3 && M>=3) {
			for(int i=0; i<N-2; i++) {
				for(int j=0; j<M-2; j++) {
					// 탐색시 다른경우일때
					if(!check[j][i]) {
						count++;
						for(int col=i; col<i+3; col++) {
							for(int row=j; row<j+3; row++) {
								check[row][col] = !check[row][col];
							}
						}
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!check[j][i]) {
					count = -1;
					break;
				}
			}
		}
		
		
		
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
