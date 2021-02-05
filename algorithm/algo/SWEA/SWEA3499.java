package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3499 {
/**
 * @since 2021. 2. 5.
 * @author itsmeyjc
 * @see
 * @mem
 * @time
 * @caution
 */
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			String all[] = new String[N];
			String ans[] = new String[N];
			for(int i=0; i<N; i++) {
				all[i] = st.nextToken();
			}
			
			String first[],second[];
			// 배열생성
			if(N%2 == 1) {
				first = Arrays.copyOf(all, N/2+1);
				second = Arrays.copyOfRange(all, N/2+1, N);
			}else {
				first = Arrays.copyOf(all, N/2);
				second = Arrays.copyOfRange(all, N/2, N);
			}
			
			for(int i=0; i<N; i++) {
				if(i%2 == 0) {
					ans[i] = first[i/2];
				}else {
					ans[i] = second[i/2];
				}
			}
			
			
			
			
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<N; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
