import java.io.*;
import java.util.*;
 
class Main {
    //lexographically best moves...
    public static int dx[]= {1,0,0,-1};
    public static int dy[]= {0,-1,1,0};
    public static long max=1000000000000L;
    public static void main(String[] args) throws FileNotFoundException {
        FastScanner fs = new FastScanner();
        FastOutput fo = new FastOutput(System.out);
        long initial_time = System.currentTimeMillis();
        long phi[]=new long[1000001];
        boolean isprime[]=new boolean[1000001];
        for(int i=0;i<1000001;i++){
            phi[i]=i*1L;
            isprime[i]=true;
        }
        phi[1]=1;
        for(int i=2;i*1L*i<max;i++){
            if(isprime[i]){
                for(int j=i;j<1000001;j+=i){
                    phi[j]*=(1L*(i-1));
                    phi[j]/=i;
                    isprime[j]=false;
                }
            }
        }
        int testcases = fs.nextInt();
        for (int tt = 0; tt < testcases; tt++) {
            //main code
            int n=fs.nextInt();
            fo.println(phi[n]);
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
