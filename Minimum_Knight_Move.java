import java.io.*;
import java.util.*;
 
class Main {
	public static boolean isvalid(int x,int y) {
		if(x>=1 && y>=1 && x<=8 && y<=8) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws FileNotFoundException {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput();
		long initial_time = System.currentTimeMillis();
		int testcases = fs.nextInt();
		Map<Character,Integer> mp=new TreeMap<>();
		mp.put('a', 1);
		mp.put('b', 2);
		mp.put('c', 3);
		mp.put('d', 4);
		mp.put('e', 5);
		mp.put('f', 6);
		mp.put('g', 7);
		mp.put('h', 8);
		for (int tt = 0; tt < testcases; tt++) {
			//main code
			String start_pos=fs.next(),end_pos=fs.next();
			int x1=mp.get(start_pos.charAt(0)),y1=Character.getNumericValue(start_pos.charAt(1));
			int x2=mp.get(end_pos.charAt(0)),y2=Character.getNumericValue(end_pos.charAt(1));
			Queue<Pair> q=new LinkedList<>();
			int ans=1000000000; //1e9
			q.add(new Pair(x1, y1, 0));
			boolean visited[][]=new boolean[9][9];
			visited[x1][y1]=true;
			while(!q.isEmpty()) {
				Pair p=q.poll();
				if(p.x==x2 && p.y==y2) {
					ans=Math.min(ans, p.cnt);
				}
				else {
					if(isvalid(p.x+1, p.y+2) && !visited[p.x+1][p.y+2]) {
						visited[p.x+1][p.y+2]=true;
						q.add(new Pair(p.x+1, p.y+2, p.cnt+1));
					}
					if(isvalid(p.x-1, p.y+2) && !visited[p.x-1][p.y+2]) {
						visited[p.x-1][p.y+2]=true;
						q.add(new Pair(p.x-1, p.y+2, p.cnt+1));
					}
					if(isvalid(p.x+1, p.y-2) && !visited[p.x+1][p.y-2]) {
						visited[p.x+1][p.y-2]=true;
						q.add(new Pair(p.x+1, p.y-2, p.cnt+1));
					}
					if(isvalid(p.x-1, p.y-2) && !visited[p.x-1][p.y-2]) {
						visited[p.x-1][p.y-2]=true;
						q.add(new Pair(p.x-1, p.y-2, p.cnt+1));
					}
					if(isvalid(p.x-2, p.y+1) && !visited[p.x-2][p.y+1]) {
						visited[p.x-2][p.y+1]=true;
						q.add(new Pair(p.x-2, p.y+1, p.cnt+1));
					}
					if(isvalid(p.x+2, p.y+1) && !visited[p.x+2][p.y+1]) {
						visited[p.x+2][p.y+1]=true;
						q.add(new Pair(p.x+2, p.y+1, p.cnt+1));
					}
					if(isvalid(p.x-2, p.y-1) && !visited[p.x-2][p.y-1]) {
						visited[p.x-2][p.y-1]=true;
						q.add(new Pair(p.x-2, p.y-1, p.cnt+1));
					}
					if(isvalid(p.x+2, p.y-1) && !visited[p.x+2][p.y-1]) {
						visited[p.x+2][p.y-1]=true;
						q.add(new Pair(p.x+2, p.y-1, p.cnt+1));
					}
				}
			}
			fo.println(ans);
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
	int x,y,cnt;
	public Pair(int x,int y,int cnt) {
		this.x=x;
		this.y=y;
		this.cnt=cnt;
	}
}
