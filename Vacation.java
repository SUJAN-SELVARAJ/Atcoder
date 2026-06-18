import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int dpA = 0, dpB = 0, dpC = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int nextA = a + Math.max(dpB, dpC);
            int nextB = b + Math.max(dpA, dpC);
            int nextC = c + Math.max(dpA, dpB);
            dpA = nextA;
            dpB = nextB;
            dpC = nextC;
        }
        int maxHappiness = Math.max(dpA, Math.max(dpB, dpC));
        System.out.println(maxHappiness);
    }
}
