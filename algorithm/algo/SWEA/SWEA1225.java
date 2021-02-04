package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
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
		
		for( int T=0; T<10;T++ ) {
			int test_case = Integer.parseInt(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			boolean check = true;
			while(check) {
				for(int i=1; i<=5; i++) {
					int num = queue.poll();
					if(num-i <= 0) {
						queue.offer(0);
						check = false;
						break;
					}else {
						queue.offer(num-i);
					}
				}
			}
			
			
			
			sb.append("#").append(test_case).append(" ");
			for(int i=0; i<8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}

}
