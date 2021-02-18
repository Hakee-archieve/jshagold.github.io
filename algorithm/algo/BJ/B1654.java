package algoBack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1654 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int klan[] = new int[K];
		for(int i=0; i<K; i++) {
			klan[i] = Integer.parseInt(br.readLine());
		}
		
		
		Arrays.sort(klan);
		long ans = divide(klan,N);
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static long divide(int klan[], int N) {
		long start = 1;
		long end = klan[klan.length-1];
		long max=0;
		
		while(start <= end) {
			long mid = (start+end)/2;
			long sum = 0;
			for(int i=0; i<klan.length; i++) {
				sum = sum + klan[i]/mid;
			}
			if(sum < N) {
				end = mid-1;
			}else{
				max = mid;
				start = mid+1;
			}
		}
		return max;
	}

}
