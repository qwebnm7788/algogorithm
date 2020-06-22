import java.io.*;
import java.util.Scanner;

/**
 * @author JaewonChoi
 */
public class Sort_Colors {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] insertionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i + 1];
            int minIdx = i + 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIdx = j;
                }
            }

            if (nums[i] > min) {
                nums[minIdx] = nums[i];
                nums[i] = min;
            }
        }

        return nums;
    }

    public static void sortColors(int[] nums) {
        nums = insertionSort(nums);
    }

    public static void main(String[] args) throws IOException {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + ",");
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
