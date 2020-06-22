import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JaewonChoi
 */
public class Search_Insert_Position {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);

        if (index >= 0) {
            return index;
        } else {
            return -(index + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        int[] tc = {1, 3, 5, 6};

        System.out.println(searchInsert(tc, 5));
        System.out.println(searchInsert(tc, 2));
        System.out.println(searchInsert(tc, 7));
        System.out.println(searchInsert(tc, 0));

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
