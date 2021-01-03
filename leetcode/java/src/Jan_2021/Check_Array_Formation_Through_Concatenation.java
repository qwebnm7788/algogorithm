package Jan_2021;

public class Check_Array_Formation_Through_Concatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int i = 0; i < arr.length; ) {
            int foundAt = -1;
            for (int j = 0; j < pieces.length; j++) {
                if (pieces[j][0] == arr[i]) {
                    foundAt = j;
                    break;
                }
            }
            if (foundAt == -1 || i + pieces[foundAt].length > arr.length) return false;
            for (int j = 0; j < pieces[foundAt].length; j++) {
                if (arr[i + j] != pieces[foundAt][j]) return false;
            }
            i += pieces[foundAt].length;
        }
        return true;
    }
}
