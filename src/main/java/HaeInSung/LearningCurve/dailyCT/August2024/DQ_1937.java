package HaeInSung.LearningCurve.dailyCT.August2024;

/* Maximum Number of Points with Cost */

import java.util.ArrayList;
import java.util.List;

public class DQ_1937 {

    /* memoization? */

    public long maxPoints(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;

        long[] prevRow = new long[rows];

        // initialize 1st row
        for (int col = 0; col < cols; col++) {
            prevRow[col] = points[0][col];
        }

        // process each row
        for (int row = 0; row < rows - 1; row++) {
            long[] leftMax = new long[cols];
            long[] rightMax = new long[cols];
            long[] currRow = new long[cols];

            // calculate left - to - right maximum
            leftMax[0] = prevRow[0];
            for (int col = 1; col < cols; col++) {
                leftMax[col] = Math.max(leftMax[col - 1] - 1, prevRow[col]);
            }

            // calculate right - to - right maximum
            rightMax[cols - 1] = prevRow[cols - 1];
            for (int col = cols - 2; col >= 0; col--) {
                rightMax[col] = Math.max(rightMax[col + 1] - 1, prevRow[col]);
            }

            // calculate the current row's maximum points
            for (int col = 0; col < cols; col++) {
                currRow[col] = points[row + 1][col] + Math.max(leftMax[col], rightMax[col]);
            }

            // update previous row for the next iteration
            prevRow = currRow;
        }

        // find the maximum value in the last processed row
        long maxPoints = 0;
        for (int col = 0; col < cols; col++) {
            maxPoints = Math.max(maxPoints, prevRow[col]);
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        List<int[][]> testcases = new ArrayList<>();
        testcases.add(new int[][]{{1, 2, 3}, {1, 5, 1}, {3, 1, 1}});
        testcases.add(new int[][]{{1, 5}, {2, 3}, {4, 2}});

        DQ_1937 dailyQ = new DQ_1937();
        for (int[][] testcase : testcases) {
            System.out.println(dailyQ.maxPoints(testcase));
        }
    }
}
