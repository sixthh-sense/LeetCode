package HaeInSung.LearningCurve.dailyCT.August2024;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Stone Game 2 */

/* 양수 개의 돌들로 구성되어있는 돌더미들로 앨리스와 밥이 게임을 계속함
* 게임의 목적은 가장 많은 돌을 가진 채 끝나는 것
* 앨리스가 M=1 로 먼저 시작함
* 각 플레이어의 차례에, 그 플레이어는 처음 X remaining piles에서 모든 돌들을 다 가져갈 수 있음.
* X는 1이상 2M 이하. 그런 다음에 M은 M과 X를 비교해 더 큰 값이 됨
* 양쪽 플레이어 모두 최대한 효율적인 플레이를 보여준다고 가정할 때,
* 앨리스가 획득할 수 있는 가장 많은 돌의 수를 반환 */

/* 힌트: dynamic programming */
public class DQ_1140 {

    public int stoneGameII(int[] piles) {
        // Store the suffix sum of all array elements.
        int[] suffixSum = Arrays.copyOf(piles, piles.length);

        for (int i = suffixSum.length - 2; i >= 0; i--) {
            suffixSum[i] += suffixSum[i + 1];
        }
        return maxStones(suffixSum, 1, 0, new int[piles.length][piles.length]);
    }

    private int maxStones(
            int[] suffixSum,
            int maxTillNow,
            int currIndex,
            int[][] memo
    ) {
        // If currIndex + 2*maxTillNow lies outside the array, pick all remaining stones.
        if (currIndex + 2 * maxTillNow >= suffixSum.length) {
            return suffixSum[currIndex];
        }
        if (memo[currIndex][maxTillNow] > 0) return memo[currIndex][maxTillNow];
        int res = Integer.MAX_VALUE;
        // Find the minimum value res for the next move possible.
        for (int i = 1; i <= 2 * maxTillNow; i++) {
            res = Math.min(
                    res,
                    maxStones(
                            suffixSum,
                            Math.max(i, maxTillNow),
                            currIndex + i,
                            memo
                    )
            );
        }
        // Memoize the difference of suffixSum[p] and res. This denotes the maximum
        // stones that can be picked.
        memo[currIndex][maxTillNow] = suffixSum[currIndex] - res;
        return memo[currIndex][maxTillNow];
    }

    public static void main(String[] args) {
        List<int[]> testcases = new ArrayList<>();
        testcases.add(new int[]{2, 7, 9, 4, 4}); // 10이 나와야 함
        /* 앨리스가 처음에 1 가져가면 (2, 7, 9, 4, 4에서 2를 가져감)
        * 밥은 2 가져감(7, 9)
        * 그러면 앨리스는 돌'더미'를 2개 가져가는 게 가능하고(4, 4)
        * 앨리스는 총 2 + 4 + 4 = 10 개의 돌들을 가져갈 수 있음
        * */
        testcases.add(new int[]{1, 2, 3, 4, 5, 100}); // 104가 나와야 함

        for (int[] testcase : testcases) {
            DQ_1140 dailyQ = new DQ_1140();
            System.out.println(dailyQ.stoneGameII(testcase));
        }
    }
}
