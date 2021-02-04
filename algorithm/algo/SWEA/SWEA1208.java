package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA1208 {
/**
 * @since 2021. 2. 2.
 * @author itsmeyjc
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV139KOaABgCFAYh&probBoxId=AXdgvuDKbeYDFAUO&type=PROBLEM&problemBoxTitle=0202&problemBoxCnt=1
 * @mem
 * @time
 * @caution
 */
	
	// 배열사용
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case=1; test_case<=T; test_case++) {
			int dump = sc.nextInt();
			int ans=0;
			int box[] = new int[100];
			for(int i=0; i<100; i++) {
				box[i] = sc.nextInt();
			}
			Arrays.sort(box);
			for(int i=0; i<dump; i++) {
				box[0] += 1;
				box[99] -= 1;
				Arrays.sort(box);
				ans = box[99] - box[0];
				if(ans <= 1) {
					break;
				}
			}
			
			
			System.out.println("#"+test_case+" "+ans);
		}

	}
	
	
	// ArrayList사용
//	public static void main(String args[]) throws Exception
//	{
//
//
//		Scanner sc = new Scanner(System.in);
//		int T = 10;
//
//
//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//			int ans=0;
//			int dump;
//			dump = sc.nextInt();
//			ArrayList<Integer> boxes = new ArrayList<>(100);
//			
//			for(int b=0; b<100; b++) {
//				boxes.add(sc.nextInt());
//			}
//			boxes.sort(null);
//			for(int i=0; i<dump; i++) {
//				boxes = mix(boxes);
//			}
//			
//			ans = boxes.get(99) - boxes.get(0);
//			
//			
//			System.out.println("#"+test_case +" "+ ans);
//		}
//	}
//	
//	public static ArrayList<Integer> mix(ArrayList<Integer> boxes) {
//		boxes.set(99, boxes.get(99)-1);
//		boxes.set(0, boxes.get(0)+1);
//		boxes.sort(null);
//		return boxes;
//	}

}
