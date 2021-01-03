package Jan_2021;

public class Beautiful_Arrangement {

    private int answer;

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void permute(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            boolean possible = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % (i + 1) != 0 && (i + 1) % arr[i] != 0) {
                    possible = false;
                    break;
                }
            }
            if (possible) answer++;
        } else {
            if (idx >= 1) {
                if (arr[idx - 1] % (idx) != 0 && idx % arr[idx - 1] != 0) {
                    return;
                }
            }
            for (int i = idx; i < arr.length; i++) {
                swap(arr, idx, i);
                permute(arr, idx + 1);
                swap(arr, idx, i);
            }
        }
    }

    public int countArrangement(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        answer = 0;
        permute(arr, 0);
        return answer;
    }
}
