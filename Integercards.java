import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
    static class Operation implements Comparable<Operation> {
        int count;
        int value;
        Operation(int count, int value) {
            this.count = count;
            this.value = value;
        }
        @Override
        public int compareTo(Operation o) {
            return Integer.compare(o.value, this.value);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(a);
        PriorityQueue<Operation> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Operation(b, c));
        }
        int cardIdx = 0;
        while (!pq.isEmpty() && cardIdx < n) {
            Operation curr = pq.poll();
            while (curr.count > 0 && cardIdx < n && a[cardIdx] < curr.value) {
                a[cardIdx] = curr.value;
                cardIdx++;
                curr.count--;
            }
            if (cardIdx < n && a[cardIdx] >= curr.value) {
                break;
            }
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        System.out.println(sum);
    }
}
