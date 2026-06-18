import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        String[] words = {"dream", "dreamer", "erase", "eraser"};
        String reversedS = new StringBuilder(s).reverse().toString();
        String[] reversedWords = new String[4];
        for (int i = 0; i < 4; i++) {
            reversedWords[i] = new StringBuilder(words[i]).reverse().toString();
        }
        int index = 0;
        boolean possible = true;
        while (index < reversedS.length()) {
            boolean matchFound = false;
            for (String word : reversedWords) {
                if (reversedS.startsWith(word, index)) {
                    index += word.length();
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) {
                possible = false;
                break;
            }
        }
        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
