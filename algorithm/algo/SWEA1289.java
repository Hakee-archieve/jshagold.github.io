package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA1289 {

	
/**
 * @since 2021. 2. 1.
 * @author itsmeyjc
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV19AcoKI9sCFAZN&solveclubId=AXdbYpT6xskDFAUO&problemBoxTitle=0201&problemBoxCnt=1&probBoxId=AXdbYpUKxsoDFAUO
 * @mem
 * @time
 * @caution
 */
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int ans = 0;
            String bit = br.readLine();
			char check = bit.charAt(0);
			
			if(check == '1') {
				ans++;
			}
			
			
			for(int i=1; i<bit.length(); i++) {
				if(check != bit.charAt(i)) {
					check = bit.charAt(i);
					ans++;
				}
			}
			
			sb.append("#"+test_case+" "+ans+"\n");
		}

		System.out.println(sb.toString());
	}

}
