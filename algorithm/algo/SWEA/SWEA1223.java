package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SWEA1223 {
/**
 * @since 2021. 2. 6.
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
		
		for(int tc=1; tc<=10; tc++) {
			int ans=0;
			int N = Integer.parseInt(br.readLine());
			String in = br.readLine();
			// 후위표기식
			List<Character> backCal = new ArrayList<>();
			// 후위표기식 만드는 스택,큐와 후위표기식으로 계산하는 스택
			Stack<Character> signStack = new Stack<>();
			Stack<Integer> calculator = new Stack<>();
			
			// 후위표기식 생성
			for(int i=0; i<N; i++) {
				// + 들어왔을때
				if(in.charAt(i)=='+') {
					if(!signStack.isEmpty()) {
						if(signStack.peek()=='*') {
							while( !(signStack.isEmpty()) ) {
								backCal.add(signStack.pop());
							}
							signStack.push(in.charAt(i));
						}else {
							signStack.push(in.charAt(i));
						}
					}else {
						signStack.push(in.charAt(i));
					}
					
				}
				// * 들어왔을때
				else if(in.charAt(i)=='*') {
					signStack.push(in.charAt(i));
				}
				// 숫자들어왔을때
				else {
					backCal.add(in.charAt(i));
				}
			}
			while( !(signStack.isEmpty()) ) {
				backCal.add(signStack.pop());
			}
			
			// 후위표기식으로 계산
			for(int i=0; i<backCal.size(); i++) {
				
				if(backCal.get(i)!='+' && backCal.get(i)!='*') {
					int num = Character.getNumericValue(backCal.get(i));
					calculator.push(num);
				}else if(backCal.get(i)=='+') {
					int sum = calculator.pop() + calculator.pop();
					calculator.push(sum);
				}else if(backCal.get(i)=='*') {
					int mul = calculator.pop() * calculator.pop();
					calculator.push(mul);
				}
			}
			ans = calculator.pop();
			
			
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

}
