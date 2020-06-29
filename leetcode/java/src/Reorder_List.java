import java.io.*;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author JaewonChoi
 */
public class Reorder_List {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void reorderList(ListNode head) {
        ListNode left = null;
        ListNode right = null;

        ListNode currentNode = head;
        int count = 0;
        while (currentNode != null) {
            if (count % 2 == 0) {
                if (left == null) left = currentNode;
                else {
                    left.next = currentNode;
                    left = currentNode;
                }
            } else {
                if (right == null) right = currentNode;
                else {
                    right.next = currentNode;
                    right = currentNode;
                }
            }
            count++;
            currentNode = currentNode.next;
        }

        head = left;
        left = left.next;

        currentNode = head;
        while (left == null && right == null) {
            if (right != null) {
                currentNode.next = right;
                right = right.next;
            }
            currentNode = currentNode.next;
            if (left != null) {
                currentNode.next = left;
                left = left.next;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = null;
    }

    public static void main(String[] args) throws IOException {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

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
