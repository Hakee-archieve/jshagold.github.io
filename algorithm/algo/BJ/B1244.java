package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.xml.sax.InputSource;

public class B1244 {
/**
 * @since 2021. 2. 1.
 * @author itsmeyjc
 * @see https://www.acmicpc.net/problem/1244
 * @mem
 * @time
 * @caution
 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int swit[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			swit[i] = Integer.parseInt(st.nextToken());
		}
		
		int stn = Integer.parseInt(br.readLine());
		for(int i=0; i<stn; i++) {
			int gen, num;
			StringTokenizer sst = new StringTokenizer(br.readLine());
			gen = Integer.parseInt(sst.nextToken());
			num = Integer.parseInt(sst.nextToken());
			if(gen == 1) {
				// man
				for(int j=1; j<=N; j++) {
					if((j*num-1)<N && swit[j*num-1] == 0) {
						swit[j*num-1] = 1;
					}else if((j*num-1)<N && swit[j*num-1] == 1){
						swit[j*num-1] = 0;
					}
				}
			} else {
				// woman
				for(int j=0; j<N; j++) {
					// 범위안에 드는가?
					if((num-1-j)>=0 && (num-1+j)<N) {
						if(swit[num-1-j]==swit[num-1+j] && swit[num-1-j] == 0) {
							swit[num-1-j] = 1;
							swit[num-1+j] = 1;
						}
						else if(swit[num-1-j]==swit[num-1+j] && swit[num-1-j] == 1) {
							swit[num-1-j] = 0;
							swit[num-1+j] = 0;
						} else {
							break;
						}
					}
				}
			}
			
		}

		// 출력
		for(int i=1; i<=N; i++) {
			System.out.print(swit[i-1]+" ");
			if(i%20 == 0) {
				System.out.println();
			}
		}
				
	}
}
