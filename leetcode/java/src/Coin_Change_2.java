import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JaewonChoi
 */
public class Coin_Change_2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final int MAX_AMOUNT = 5001;
    private static final int MAX_COIN_CNT = 500;

    private static int[][] dp = new int[MAX_AMOUNT][MAX_COIN_CNT];

    private static int solve(int amount, int index, int[] coins) {
        if (index >= coins.length) {
            return amount == 0 ? 1 : 0;
        }

        if (dp[amount][index] != -1) {
            return dp[amount][index];
        }

        dp[amount][index] = 0;
        for (int i = 0; coins[index] * i <= amount; i++) {
            dp[amount][index] += solve(amount - coins[index] * i, index + 1, coins);
        }

        return dp[amount][index];
    }

    public static int change(int amount, int[] coins) {
        for (int i = 0; i < MAX_AMOUNT; i++) {
            for (int j = 0; j < MAX_COIN_CNT; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(amount, 0, coins);
    }

    public static void main(String[] args) throws IOException {
        int[] tc1 = {1, 2, 5};
        int[] tc2 = {2};
        int[] tc3 = {10};

        System.out.println(change(5, tc1));
        System.out.println(change(3, tc2));
        System.out.println(change(10, tc3));

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
