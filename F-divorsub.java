import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;
        long N = sc.nextLong();
        
        if (N == 2) {
            System.out.println(1);
            return;
        }

        HashSet<Long> validK = new HashSet<>();

        long nMinusOne = N - 1;
        for (long i = 1; i * i <= nMinusOne; i++) {
            if (nMinusOne % i == 0) {
                if (i >= 2) {
                    validK.add(i);
                }
                if (nMinusOne / i >= 2) {
                    validK.add(nMinusOne / i);
                }
            }
        }

        for (long i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i >= 2) {
                    checkAndAdd(N, i, validK);
                }
                if (N / i >= 2 && N / i != i) {
                    checkAndAdd(N, N / i, validK);
                }
            }
        }

        System.out.println(validK.size());
    }

    private static void checkAndAdd(long N, long K, HashSet<Long> validK) {
        long temp = N;
        while (temp % K == 0) {
            temp /= K;
        }
        if (temp % K == 1) {
            validK.add(K);
        }
    }
}
