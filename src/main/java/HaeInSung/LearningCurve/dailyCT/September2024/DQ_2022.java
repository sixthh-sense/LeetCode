package HaeInSung.LearningCurve.dailyCT.September2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 9/1
* Convert 1D Array into 2D Array
* */
public class DQ_2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }


        System.out.println("result: ");
        for (int k = 0; k < result.length; k++) {
            System.out.println(Arrays.toString(result[k]));
        }

        return result;
    }

    public static void main(String[] args) {
        DQ_2022 dq = new DQ_2022();
        List<int[]> testcases = new ArrayList<>();
        testcases.add(new int[]{1, 2, 3, 4});
        testcases.add(new int[]{1, 2, 3});
        testcases.add(new int[]{1, 2});

        List<Integer> mList = new ArrayList<>(List.of(2, 1, 1)); // m: row no.
        List<Integer> nList = new ArrayList<>(List.of(2, 3, 1)); // n: column no.

        for (int[] testcase : testcases) {
            int index = testcases.indexOf(testcase);
            dq.construct2DArray(testcase, mList.get(index), nList.get(index));
        }
    }
}
