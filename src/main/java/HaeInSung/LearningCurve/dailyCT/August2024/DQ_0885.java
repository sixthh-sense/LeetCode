package HaeInSung.LearningCurve.dailyCT.August2024;

/* Spiral Matrix 3 */
public class DQ_0885 {

    /* rStart, cStart는 index 개념인 듯. 맨 처음부터 시작하는 건 1이 아니라 0 */
    /* 5 * 6에서 1, 4에 시작할 때 시작점을 기준으로 4개 혹은 그 이하의 구역으로 나누어진다는 걸 고려? 1~4사분면? */
    /* 어쨌든 rows * cols 분만큼 int[][]에 저장이 되겠군 */
    /* 길이는 처음엔 1 * 2씩 증가하다가 2 * 2 ... n * 2씩 증가하게 됨 */
    /* 동쪽 (x+1, y+0)-> 남쪽(x+0, y-1) -> 서쪽 -> 북쪽 순 */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] traversed = new int[rows * cols][2];
        int idx = 0;

        for (int step = 1, direction = 0; idx < rows + cols;) {
            // direction = 0 :: East, direction = 1 :: South
            // direction = 2 :: West, direction = 3 :: North
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < step; ++j) {
                    // validate the current position
                    if (
                            rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols
                    ) {
                        traversed[idx][0] = rStart;
                        traversed[idx][1] = cStart;
                        ++idx;
                    }
                    // make changes to teh current position
                    rStart += directions[direction][0];
                    cStart += directions[direction][1];
                }
                direction = (direction + 1) % 4;
            }
            ++step;
        }
        return traversed;
    }

    public static void main(String[] args) {
        DQ_0885 dailyQ = new DQ_0885();

        int[] rows = {1, 5};
        int[] cols = {4, 6};
        int[] rStarts = {0, 1};
        int[] cStarts = {0, 4};

        for (int i = 0; i < rows.length; i++) {
            System.out.println(dailyQ.spiralMatrixIII(rows[i], cols[i], rStarts[i], cStarts[i]));
        }

    }
}
