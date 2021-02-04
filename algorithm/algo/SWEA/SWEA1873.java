package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {
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
			int H,W,O,tankx,tanky;
			tankx=0;
			tanky=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			char board[][] = new char[W][H];
			// 맵 받아오기
			for(int i=0; i<H; i++) {
				String input_b = br.readLine();
				for(int j=0; j<W; j++) {
					board[j][i] = input_b.charAt(j);
					// 탱크 초기위치 저장
					if(input_b.charAt(j)=='<'||input_b.charAt(j)=='>'||input_b.charAt(j)=='^'||input_b.charAt(j)=='v') {
						tankx = j;
						tanky = i;
					}
				}
			}
			// 명령받아오기
			O = Integer.parseInt(br.readLine());
			String orderString = br.readLine();
			char order;
			for(int i=0; i<O; i++) {
				order = orderString.charAt(i);
				if(order == 'S') {
					shoot(board,tankx,tanky,H,W);
				}else if(order == 'U') {
					board[tankx][tanky] = '^';
					if(tanky-1 >= 0 && board[tankx][tanky-1]=='.') {
						board[tankx][tanky] = '.';
						board[tankx][tanky-1] = '^';
						tanky = tanky-1;
					}
				}else if(order == 'D') {
					board[tankx][tanky] = 'v';
					if(tanky+1 < H && board[tankx][tanky+1]=='.') {
						board[tankx][tanky] = '.';
						board[tankx][tanky+1] = 'v';
						tanky = tanky+1;
					}
				}else if(order == 'L') {
					board[tankx][tanky] = '<';
					if(tankx-1 >= 0 && board[tankx-1][tanky]=='.') {
						board[tankx][tanky] = '.';
						board[tankx-1][tanky] = '<';
						tankx = tankx-1;
					}
				}else if(order == 'R') {
					board[tankx][tanky] = '>';
					if(tankx+1 < W && board[tankx+1][tanky]=='.') {
						board[tankx][tanky] = '.';
						board[tankx+1][tanky] = '>';
						tankx = tankx+1;
					}
				}
			}
			
			
			//출력
			sb.append("#").append(test_case).append(" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					sb.append(board[j][i]);
				}
				sb.append("\n");
			}
			
			System.out.print(sb.toString());
		}
	
	}

	// 포탄발사
	public static void shoot(char board[][], int tankx, int tanky, int H, int W) {		
		if(board[tankx][tanky]=='^') {
			for(int i=tanky-1; i>=0; i--) {
				if(board[tankx][i] == '*') {
					board[tankx][i] = '.';
					break;
				}else if(board[tankx][i] == '#') {
					break;
				}
			}
		}else if(board[tankx][tanky]=='v') {
			for(int i=tanky+1; i<H; i++) {
				if(board[tankx][i] == '*') {
					board[tankx][i] = '.';
					break;
				}else if(board[tankx][i] == '#') {
					break;
				}
			}
		}else if(board[tankx][tanky]=='>') {
			for(int i=tankx+1; i<W; i++) {
				if(board[i][tanky] == '*') {
					board[i][tanky] = '.';
					break;
				}else if(board[i][tanky] == '#') {
					break;
				}
			}
		}else if(board[tankx][tanky]=='<') {
			for(int i=tankx-1; i>=0; i--) {
				if(board[i][tanky] == '*') {
					board[i][tanky] = '.';
					break;
				}else if(board[i][tanky] == '#') {
					break;
				}
			}
		}
	}

	
}
