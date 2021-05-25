import java.io.*;
import java.util.*;
 
class Main {
 
	public static void main(String[] args) throws FileNotFoundException {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput();
		long initial_time = System.currentTimeMillis();
		int testcases = fs.nextInt();
		for (int tt = 0; tt < testcases; tt++) {
			//main code
			int n=fs.nextInt(),r=fs.nextInt(),m=fs.nextInt();
			ArrayList<Integer> graph[]=new ArrayList[n+1];
			for(int i=0;i<n+1;i++) {
				graph[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<r;i++) {
				int A=fs.nextInt(),B=fs.nextInt();
				graph[A].add(B);
				graph[B].add(A);
			}
			int arr[][]=new int[m][2];
			for(int i=0;i<m;i++) {
				arr[i][0]=fs.nextInt();arr[i][1]=fs.nextInt();
			}
			int []visited=new int[n+1];
			boolean is=false;
			outer:for(int i=0;i<m;i++) {
				int k=arr[i][0],s=arr[i][1];
				Queue<Pair> q=new LinkedList<Pair>();
				q.add(new Pair(k, s));
				while(!q.isEmpty()) {
					Pair obj=q.poll();
					if(visited[obj.curr_city]==0) {
						if(obj.curr_power==0) {
							visited[obj.curr_city]=k;
							continue;
						}
						visited[obj.curr_city]=k;
						for(int j=0;j<graph[obj.curr_city].size();j++) {
							q.add(new Pair(graph[obj.curr_city].get(j), obj.curr_power-1));
						}
					}
					else {
						if(visited[obj.curr_city]==k) {
							continue;
						}
						else {
							is=true;
							break outer;
						}
					}
				}
			}
			if(is) {
				fo.println("No");
			}
			else {
				boolean ans=false;
				for(int i=1;i<=n;i++) {
					if(visited[i]==0) {
						ans=true;
						break;
					}
				}
				if(ans) {
					fo.println("No");
				}
				else {
					fo.println("Yes");
				}
			}
		}
		//fo.time(initial_time);
	}
 
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
 
		public FastScanner() throws FileNotFoundException {
			//if (System.getProperty("ONLINE_JUDGE") == null) {
				//Read from the File...
			//	File file = new File("src\\input");
			//	br = new BufferedReader(new FileReader(file));
			//} else {
				//Read from the System...
				br = new BufferedReader(new InputStreamReader(System.in));
			//}
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
	int curr_city,curr_power;
	public Pair(int curr_city,int curr_power) {
		this.curr_city=curr_city;
		this.curr_power=curr_power;
	}
} 
