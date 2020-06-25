import java.awt.print.Pageable;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JaewonChoi
 */
public class Construct_Binary_Search_Tree_From_Preorder_Traversal {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        TreeNode root = new TreeNode(preorder[0]);
        root.left = root.right = null;

        int biggerIdx = -1;
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] > preorder[0]) {
                biggerIdx = i;
                break;
            }
        }

        if (biggerIdx == 1) {
            root.right = bstFromPreorder(Arrays.copyOfRange(preorder, biggerIdx, preorder.length));
        } else if (biggerIdx == -1) {
            root.left = bstFromPreorder(Arrays.copyOfRange(preorder, biggerIdx, preorder.length));
        } else {
            root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, biggerIdx));
            root.right = bstFromPreorder(Arrays.copyOfRange(preorder, biggerIdx, preorder.length));
        }

        return root;
    }

    public static void main(String[] args) throws IOException {

        TreeNode root = bstFromPreorder(new int[]{4,2});
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
