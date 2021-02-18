package algoBack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1068 {

	static StringBuilder sb = new StringBuilder();
	static boolean visit[];
	static ArrayList<Integer> tree[];
	static int deleteN,count=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int beforeT[] = new int[N];
		tree = new ArrayList[N];
		visit = new boolean[N];
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			beforeT[i] = Integer.parseInt(st.nextToken());
		}
		deleteN = Integer.parseInt(br.readLine());
		int root=0;
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList();
		}
		for(int i=0; i<N; i++) {
			if(beforeT[i] == -1) {
				root = i;
			}else {
				tree[beforeT[i]].add(i);
			}
		}
//		for(int i=0; i<N; i++) {
//			System.out.println(tree[i].toString());
//		}
		
		if(deleteN == root) {
			count = 0;
		}else {
			dfs(root);
		}
		
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int node) {
		visit[node] = true;
		int childN = 0;
		for(int i=0; i<tree[node].size(); i++) {
			int now = tree[node].get(i);
			if(!(visit[now]) && now!=deleteN) {
				childN++;
				dfs(now);
			}
		}
		if(childN==0) {
			count++;
		}
	}
}
