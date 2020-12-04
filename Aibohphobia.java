import java.io.*;
import java.util.*;

public class Main {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws Exception {
			/*InputStream inputStream = new FileInputStream(
					"C:\\Users\\Dell\\eclipse-workspace\\Java CP\\src\\input.txt");
			br = new BufferedReader(new InputStreamReader(inputStream));*/
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	
	public static int func(String string,int s,int e,int [][]dp) {
		if(s==e) {
			return 1;
		}
		else if(s>e) {
			return 0;
		}
		else if(dp[s][e]!=-1) {
			return dp[s][e];
		}
		else {
			if(string.charAt(s)==string.charAt(e)) {
				dp[s][e]=2+Main.func(string, s+1, e-1, dp);
				return dp[s][e];
			}
			else {
				dp[s][e]=Math.max(Main.func(string, s, e-1, dp),Main.func(string, s+1, e, dp));
				return dp[s][e];
			}
		}
	}

	public static void solve(FastReader s) {
		String str=s.nextLine();
		int size=str.length();
		int dp[][]=new int[size+1][size+1];
		for(int i=0;i<size+1;i++) {
			for(int j=0;j<size+1;j++) {
				dp[i][j]=-1;
			}
		}
		int temp=Main.func(str,0,size-1,dp);
		System.out.println(size-temp);
	}

	public static void main(String[] args) throws Exception {
		FastReader sc = new FastReader();
		int testcases = sc.nextInt();
		for (int t = 0; t < testcases; ++t) {
			//System.out.println("Case #"+(t+1)+": "+Main.solve(sc);)
			Main.solve(sc);
		}
	}
}
