import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author JaewonChoi
 */
public class Two_City_Scheduling {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[][] dp = new int[101][101];

    private static int findMinimumCost(int A, int B, int[][] costs) {
        int N = costs.length / 2;
        if (A > N || B > N) {
            return (int) 1e6;
        }
        if (A + B == 2 * N) {
            return 0;
        }
        if (dp[A][B] != -1) {
            return dp[A][B];
        }

        dp[A][B] = findMinimumCost(A + 1, B, costs) + costs[A + B][0];
        dp[A][B] = Math.min(dp[A][B], findMinimumCost(A, B + 1, costs) + costs[A + B][1]);
        return dp[A][B];
    }

    public static int twoCitySchedCost(int[][] costs) {
        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs.length; j++) {
                dp[i][j] = -1;
            }
        }
        return findMinimumCost(0, 0, costs);
    }

    public static void main(String[] args) throws IOException {
        int[][] tc = {{10,20}, {30,200}, {400,50}, {30,20}};
        int[][] tc2 = {{259,770}, {448,54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};

//        System.out.println(twoCitySchedCost(tc));
        System.out.println(twoCitySchedCost(tc2));

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
