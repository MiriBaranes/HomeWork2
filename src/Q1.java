import java.util.Locale;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string");
        String str1 = scanner.nextLine();
        System.out.println("Enter the second string");
        String str2 = scanner.nextLine();
        System.out.println(contain(str1, str2));
    }
    public static boolean contain(String str1, String str2) {
        boolean isContain = false;
        int count = 0;
        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);
        if (str2.length() < str1.length()) {
            for (int i = 0; i < str1.length(); i++) {
                if (count == str2.length()) {
                    break;
                }
                if (str2.charAt(count) != str1.charAt(i)) {
                    count = 0;
                }
                if (str1.charAt(i) == str2.charAt(count)) {
                    count++;
                }
            }
        }

        if (count == str2.length()) {
            isContain = true;
        }
        return isContain;
    }
}

