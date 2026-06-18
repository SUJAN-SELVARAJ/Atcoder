import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        double[] p = new double[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p[i] = Double.parseDouble(st.nextToken());
        }
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 0; j--) {
                double headProb = (j > 0) ? dp[j - 1] * p[i] : 0;
                double tailProb = dp[j] * (1 - p[i]);
                dp[j] = headProb + tailProb;
            }
        }
        double totalProbability = 0;
        int minHeadsRequired = (n / 2) + 1;
        for (int j = minHeadsRequired; j <= n; j++) {
            totalProbability += dp[j];
        }
        System.out.printf("%.10f\n", totalProbability);
    }
}
