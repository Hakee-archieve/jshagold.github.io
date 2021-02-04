package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1218 {
/**
 * @since 2021. 2. 4.
 * @author itsmeyjc
 * @see
 * @mem
 * @time
 * @caution
 */
	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int T=1; T<=10; T++) {
			boolean check=true;
			int ans=0;
			int stringL = Integer.parseInt(br.readLine());
			char gual[] = new char[stringL]; // stack
			int small=0,middle=0,big=0,other=0,size=0;
			String gualS = br.readLine();
			
			for(int i=0; i<stringL; i++) {
				char now = gualS.charAt(i);
				if(now==')' || now=='}' || now==']' || now=='>') {
					if(now==')' && gual[size-1]=='(') {
						gual[size-1] = ' ';
						size--;
					}else if(now=='}' && gual[size-1]=='{') {
						gual[size-1] = ' ';
						size--;
					}else if(now==']' && gual[size-1]=='[') {
						gual[size-1] = ' ';
						size--;
					}else if(now=='>' && gual[size-1]=='<') {
						gual[size-1] = ' ';
						size--;
					}else {
						check=false;
						break;
					}
				}else {
					gual[size++] = now;
				}
			}
			if(check) {
				ans = 1;
			}else {
				ans = 0;
			}
			
			sb.append("#").append(T).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

}
