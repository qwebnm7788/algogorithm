import java.io.*;
import java.util.Scanner;

/**
 * @author JaewonChoi
 */
public class Maximum_Score_After_Splitting_A_String {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public int maxScore(String s) {
        int left, right;
        int answer = 0;

        left = right = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') right++;
        }

        if (s.charAt(0) == '0') left++;

        answer = left + right;

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') left++;
            else right--;
            answer = Math.max(answer, left + right);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {


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
