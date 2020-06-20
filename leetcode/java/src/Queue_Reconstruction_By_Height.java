import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author JaewonChoi
 */
public class Queue_Reconstruction_By_Height {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int[][] answer = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            answer[i][0] = -1;
        }
        for (int i = 0; i < people.length; i++) {
            int count = 0;
            int idx = 0;
            while (count < people[i][1]) {
                if (answer[idx][0] >= people[i][0] || answer[idx][0] == -1) {
                    count++;
                }
                idx++;
            }
            while (answer[idx][0] != -1) {
                idx++;
            }
            answer[idx] = people[i];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        int[][] tc = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        int[][] answer = reconstructQueue(tc);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i][0] + " " + answer[i][1]);
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
