import java.io.*;
import java.util.*;
 
class Main {
	public static boolean isValid(int x,int y,int n,int m) {
		return x>=0 && x<n && y>=0 && y<m;
	}
	public static void main(String[] args) throws FileNotFoundException {
		//FastScanner fs = new FastScanner();
		//FastOutput fo = new FastOutput();
		Scanner fs=new Scanner(System.in);
		//long initial_time = System.currentTimeMillis();
		//int testcases = fs.nextInt();
		//for (int tt = 0; tt < testcases; tt++) {
			//main code
			int n=fs.nextInt(),m=fs.nextInt(),k=fs.nextInt();
			char arr[][]=new char[n][m];
			for(int i=0;i<n;i++) {
				String x=fs.next();
				for(int j=0;j<m;j++) {
					arr[i][j]=x.charAt(j);
				}
			}
			boolean visited[][]=new boolean[n][m];
			boolean got_ans=false;
			outer:for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					Queue<Pair> q=new LinkedList<>();
					if(arr[i][j]=='x') {
						int target=k/2;
						q.add(new Pair(i, j, target));
						visited[i][j]=true;
						while(!q.isEmpty()) {
							Pair p=q.poll();
							if(isValid(p.x-1,p.y,n,m) && !visited[p.x-1][p.y]) {
								if(arr[p.x-1][p.y]=='s' && p.z>0) {
									q.add(new Pair(p.x-1, p.y, p.z-1));
									visited[p.x-1][p.y]=true;
								}
								if(arr[p.x-1][p.y]=='@') {
									got_ans=true;
									break outer;
								}
								if(arr[p.x-1][p.y]=='.') {
									q.add(new Pair(p.x-1, p.y, p.z));
									visited[p.x-1][p.y]=true;
								}
							}
							if(isValid(p.x+1,p.y,n,m) && !visited[p.x+1][p.y]) {
								if(arr[p.x+1][p.y]=='s' && p.z>0) {
									q.add(new Pair(p.x+1, p.y, p.z-1));
									visited[p.x+1][p.y]=true;
								}
								if(arr[p.x+1][p.y]=='@') {
									got_ans=true;
									break outer;
								}
								if(arr[p.x+1][p.y]=='.') {
									q.add(new Pair(p.x+1, p.y, p.z));
									visited[p.x+1][p.y]=true;
								}
							}
							if(isValid(p.x,p.y-1,n,m) && !visited[p.x][p.y-1]) {
								if(arr[p.x][p.y-1]=='s' && p.z>0) {
									q.add(new Pair(p.x, p.y-1, p.z-1));
									visited[p.x][p.y-1]=true;
								}
								if(arr[p.x][p.y-1]=='@') {
									got_ans=true;
									break outer;
								}
								if(arr[p.x][p.y-1]=='.') {
									q.add(new Pair(p.x, p.y-1, p.z));
									visited[p.x][p.y-1]=true;
								}
							}
							if(isValid(p.x,p.y+1,n,m) && !visited[p.x][p.y+1]) {
								if(arr[p.x][p.y+1]=='s' && p.z>0) {
									q.add(new Pair(p.x, p.y+1, p.z-1));
									visited[p.x][p.y+1]=true;
								}
								if(arr[p.x][p.y+1]=='@') {
									got_ans=true;
									break outer;
								}
								if(arr[p.x][p.y+1]=='.') {
									q.add(new Pair(p.x, p.y+1, p.z));
									visited[p.x][p.y+1]=true;
								}
							}
						}
					}
				}
			}
			if(got_ans) {
				System.out.println("SUCCESS");
			}
			else {
				System.out.println("IMPOSSIBLE");
			}
		//}
		//fo.time(initial_time);
	}
 
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
 
		public FastScanner() throws FileNotFoundException {
			if (System.getProperty("ONLINE_JUDGE") == null) {
				//Read from the File...
				File file = new File("src\\input");
				br = new BufferedReader(new FileReader(file));
			} else {
				//Read from the System...
				br = new BufferedReader(new InputStreamReader(System.in));
			}
			st = new StringTokenizer("");
		}
 
		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
	}
 
	static class FastOutput {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
		void print(String str) {
			try {
				bw.write(str);
				bw.flush();
			} catch (IOException e) {
			}
		}
 
		void print(int num) {
			try {
				bw.write((num + ""));
				bw.flush();
			} catch (IOException e) {
			}
		}
 
		void println(String str) {
			try {
				bw.write(str + '\n');
				bw.flush();
			} catch (IOException e) {
			}
		}
 
		void println(int num) {
			try {
				bw.write(num + "" + '\n');
				bw.flush();
			} catch (IOException e) {
			}
		}
 
		void time(long init) {
			if (System.getProperty("ONLINE_JUDGE") == null) {
				System.out.println(System.currentTimeMillis() - init + "ms");
			}
		}
	}
}
class Pair{
	int x,y,z;
	public Pair(int x,int y,int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
} 
