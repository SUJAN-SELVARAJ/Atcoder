import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long ans = getXorSum(B) ^ getXorSum(A - 1);
        System.out.println(ans);
    }
    private static long getXorSum(long X) {
        if (X < 0) {
            return 0;
        }
        long remainder = X % 4;
        if (remainder == 0) {
            return X;
        } else if (remainder == 1) {
            return 1;
        } else if (remainder == 2) {
            return X + 1;
        } else {
            return 0;
        }
    }
}
