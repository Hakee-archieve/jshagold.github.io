package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2805 {
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
		
		for(int test_case=1; test_case<=T; test_case++) {
			StringBuilder sb = new StringBuilder();
			int ans=0;
			int size = Integer.parseInt(br.readLine());
			int board[][] = new int[size][size];
			
			
			// 처음부터 중간열 직전까지
			for(int i=0; i<size/2; i++) {
				String inputS = br.readLine();
				for(int j=0; j<size; j++) {
					if(j >= size/2-i && j < size/2+1+i) {
						ans = ans+Character.getNumericValue(inputS.charAt(j));	
					}
				}
			}
			// 중간열부터 끝까지
			for(int i=size/2; i<size; i++) {
				String inputS = br.readLine();
				for(int j=0; j<size; j++) {
					if(j >= i-size/2 && j < size-(i-size/2)) {
						ans = ans+Character.getNumericValue(inputS.charAt(j));
					}
				}
			}
			
			
			// 출력
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
			System.out.print(sb.toString());
		}
	}

}
