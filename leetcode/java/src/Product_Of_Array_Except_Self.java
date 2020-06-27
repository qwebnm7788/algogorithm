import java.io.*;
import java.util.Scanner;

/**
 * @author JaewonChoi
 */
public class Product_Of_Array_Except_Self {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) prefix[i] = nums[i];
            else prefix[i] = prefix[i - 1] * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) suffix[i] = nums[i];
            else suffix[i] = suffix[i + 1] * nums[i];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                answer[i] = suffix[i + 1];
            } else if (i == nums.length - 1) {
                answer[i] = prefix[i - 1];
            } else {
                answer[i] = prefix[i - 1] * suffix[i + 1];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        int[] tc = productExceptSelf(new int[]{1,2,3,4});
        for (int i = 0; i < tc.length; i++) {
            System.out.println(tc[i]);
        }

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
