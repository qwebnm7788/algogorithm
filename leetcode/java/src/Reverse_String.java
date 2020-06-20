import java.io.*;
import java.util.Scanner;

/**
 * @author JaewonChoi
 */
public class Reverse_String {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void reverseString(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        char[] tc = {'h','e','l','l','o'};
        char[] tc2 = {'H','a','n','n','a','h'};

        reverseString(tc);
        System.out.println(tc);

        reverseString(tc2);
        System.out.println(tc2);

        scanner.close();
        in.close();
        out.close();
    }

    static class Pair<T, R> {
        T first;
        R second;

        public Pair(T first, R second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return this.first;
        }

        public R getSecond() {
            return this.second;
        }

    }
}
