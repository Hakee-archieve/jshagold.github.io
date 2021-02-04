package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
	int first;
	int second;
	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
	public int first() {
		return this.first;
	}
	public int second() {
		return this.second;
	}
}

public class B2493 {
/**
 * @since 2021. 2. 4.
 * @author itsmeyjc
 * @see
 * @mem
 * @time
 * @caution
 */
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans[] = new int[N];
		int towers[] = new int[N];
		Stack<Pair> stack = new Stack<>(); 

		// 처음시작
		int num = Integer.parseInt(st.nextToken());
		ans[0] = 0;
		towers[0]=num;
		stack.push(new Pair(num,1));
		
		for(int i=1; i<N; i++){
			// 탑의높이
			num = Integer.parseInt(st.nextToken());
			
			// 탑의 높이와 위치 pair(value,index)
			Pair pair = new Pair(num,i+1);
			towers[i] = num;
			
			// 자기보다 높은 탑을 만날때까지 탐색
			while( !(stack.isEmpty()) ) {
				// 자기보다 높은탑 만났을때
				if(stack.peek().first() > num) {
					ans[i] = stack.peek().second();
					stack.push(pair);
					break;
				}
				// 자기보다 높은탑이 아닐때
				else {
					stack.pop();
				}
			}
			// 자기가 제일 높은 탑일경우
			if(stack.isEmpty()) {
				stack.push(pair);
				ans[i] = 0;
			}
		}
		
		for(int i=0; i<ans.length; i++) {
			sb.append(ans[i]).append(" ");	
		}
		
		System.out.println(sb.toString());
		
		
	}

}
