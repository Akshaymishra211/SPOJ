import java.io.*;
import java.util.*;
 
class Main {
    //lexographically best moves...
    public static int dx[]= {1,0,0,-1};
    public static int dy[]= {0,-1,1,0};
    public static int m,n;
    public static int [][]maze;
    public static boolean [][]vis;
    public static boolean isValid(int x,int y){
        return x>=0 && x<m && y>=0 && y<n;
    }
    public static void dfs(int i,int j){
        vis[i][j]=true;
        if(isValid(i, j-1) && maze[i][j-1]==0 && !vis[i][j-1]){
            dfs(i, j-1);
        }
        if(isValid(i, j+1) && maze[i][j+1]==0 && !vis[i][j+1]){
            dfs(i, j+1);
        }
        if(isValid(i-1, j) && maze[i-1][j]==0 && !vis[i-1][j]){
            dfs(i-1, j);
        }
        if(isValid(i+1, j) && maze[i+1][j]==0 && !vis[i+1][j]){
            dfs(i+1, j);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        FastScanner fs = new FastScanner();
        FastOutput fo = new FastOutput(System.out);
        long initial_time = System.currentTimeMillis();
        int testcases = fs.nextInt();
        for (int tt = 0; tt < testcases; tt++) {
            //main code
            m=fs.nextInt();
            n=fs.nextInt();
            maze=new int[m][n];
            vis=new boolean[m][n];
            String s;
            int total_openings=0;
            for(int i=0;i<m;i++){
                s=fs.next();
                for(int j=0;j<n;j++){
                    if(s.charAt(j)=='#') {
                        maze[i][j]=1;
                    }
                    if(s.charAt(j)=='.') {
                        maze[i][j]=0;
                    }
                    if((i==0 || i==m-1 || j==0 || j==n-1) && maze[i][j]==0){
                        total_openings++;
                    }
                }
            }
            if(total_openings!=2){
                fo.println("invalid");
            }
            else{
                int entry_x=-1,entry_y=-1,exit_x=-1,exit_y=-1;
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        if((i==0 || i==m-1 || j==0 || j==n-1) && maze[i][j]==0){
                            if(entry_x==-1 && entry_y==-1){
                                entry_x=i;
                                entry_y=j;
                            }
                            else{
                                exit_x=i;
                                exit_y=j;
                            }
                        }
                    }
                }
                dfs(entry_x,entry_y);
                if(vis[exit_x][exit_y]){
                    fo.println("valid");
                }
                else{
                    fo.println("invalid");
                }
            }
        }
        //fo.time(initial_time);
        fo.close();
    }
 
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
 
    static class FastOutput extends PrintWriter {
        
        public FastOutput(PrintStream out) {
            super(out);
        }
 
        void time(long init) {
            if (System.getProperty("ONLINE_JUDGE") == null) {
                this.println(System.currentTimeMillis() - init + "ms");
            }
        }
    }
} 
