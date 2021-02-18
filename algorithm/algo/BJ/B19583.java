package algoBack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B19583 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String start = st.nextToken();
		StringTokenizer startst = new StringTokenizer(start,":");
		int startH = Integer.parseInt(startst.nextToken());
		int startM = Integer.parseInt(startst.nextToken());
		String end = st.nextToken();
		StringTokenizer endst = new StringTokenizer(end,":");
		int endH = Integer.parseInt(endst.nextToken());
		int endM = Integer.parseInt(endst.nextToken());
		String finish = st.nextToken();
		StringTokenizer finishst = new StringTokenizer(finish,":");
		int finishH = Integer.parseInt(finishst.nextToken());
		int finishM = Integer.parseInt(finishst.nextToken());
		ArrayList<String> attend = new ArrayList<>();
		int count = 0;
		
		String inp;
		while((inp = br.readLine()) != null) {
			if(inp.equals("")) {
				break;
			}
			StringTokenizer stt = new StringTokenizer(inp);
			String sTime = stt.nextToken();
			String sName = stt.nextToken();
			StringTokenizer student = new StringTokenizer(sTime,":");
			int studentH = Integer.parseInt(student.nextToken());
			int studentM = Integer.parseInt(student.nextToken());
			
			if(studentH < startH && !(attend.contains(sName))) {
				attend.add(sName);
			} else if(studentH == startH && studentM <= startM && !(attend.contains(sName))) {
				attend.add(sName);
			}
//			System.out.println(attend.toString());
			if(studentH >= endH && studentH < finishH && attend.contains(sName)) {
				if(studentH == endH) {
					if(studentM >= endM) {
						count++;
						attend.remove(sName);
					}
				}else {
					count++;
					attend.remove(sName);
				}
			} else if(studentH == finishH && studentM <= finishM && attend.contains(sName)) {
				count++;
				attend.remove(sName);
			}
			
			if(studentH > finishH) {
				break;
			} else if(studentH == finishH) {
				if(studentM > finishM) {
					break;
				}
			}
		}
		
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
