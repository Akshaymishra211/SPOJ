import java.io.*;
import java.util.*;

public class Main {
	public static int dp[][]=new int[5005][5005];
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
	public static int func(int []arr,int i,int j,int n) {
		if(i==n) {
			return 0;
		}
		else if(Main.dp[i][j+1]!=-1) {
			return Main.dp[i][j+1];
		}
		else {
			if(j==-1) {
				Main.dp[i][j+1]=Math.max(Main.func(arr, i+1, j, n),1+Main.func(arr, i+1, i, n));
				return Main.dp[i][j+1];
			}
			else {
				if((arr[j]>0 && arr[i]<0 && Math.abs(arr[i])>arr[j]) || (arr[j]<0 && arr[i]>0 && arr[i]>Math.abs(arr[j]))) {
					Main.dp[i][j+1]=Math.max(Main.func(arr, i+1, j, n),1+Main.func(arr, i+1, i, n));
					return dp[i][j+1];
				}
				else {
					Main.dp[i][j+1]=Main.func(arr, i+1, j, n);
					return Main.dp[i][j+1];
				}
			}
		}
	} 
	public static void solve(FastReader s) {
		for(int i=0;i<5005;i++) {
			for(int j=0;j<5005;j++) {
				Main.dp[i][j]=-1;
			}
		}
		int n=s.nextInt();
		int l[]=new int[n];
		for(int i=0;i<n;i++) {
			l[i]=s.nextInt();
		}
		System.out.println(Main.func(l,0,-1,n));
	}

	public static void main(String[] args) throws Exception {
		FastReader sc = new FastReader();
		//int testcases = sc.nextInt();
		//for (int t = 0; t < testcases; ++t) {
			//System.out.println("Case #"+(t+1)+": "+Main.solve(sc);)
		Main.solve(sc);
		//}
	}
}
