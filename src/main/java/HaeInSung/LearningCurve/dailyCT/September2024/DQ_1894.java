package HaeInSung.LearningCurve.dailyCT.September2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 9/2
 * Find the Student that Will Replace the Chalk
 * 0번 ~ (n - 1)번 학생들이 n명 있는 반이 있다
 * 선생님은 학번 0번부터 시작해서 +1씩 (n - 1)번까지 문제를 주고 이걸 반복한다(반복할 때도 0번부터 시작)
 *  chalk는 0-indexed integer array (정수 평면 배열)
 *  k는 처음에 있는 chalk의 개수
 *  i번 학번인 학생은 chalk array i 번째에 있는 개수만큼의 chalk를 소비한다
 *  현재 분필 개수가 chalk[i]보다 적을 때(이하가 아니라 미만) i학번 학생은 분필 교체
 *  -> 이 상황에서 분필을 교체할 학생의 index(그러니까 학번?) 구하기
 * */

public class DQ_1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long total = 0;
        for (int oneChalk : chalk) {
            total += oneChalk;
        }
        long residue = k % total;
        for (int i = 0; i < chalk.length; i++) {
            residue -= chalk[i];
            if (residue < 0) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        DQ_1894 dq = new DQ_1894();

        List<int[]> testcases = new ArrayList<>(Arrays.asList(new int[]{5, 1, 5}, new int[]{3, 4, 1, 2}));
        List<Integer> kList = new ArrayList<>(List.of(22, 25));

        // Example 1
        /* 1. 0학번 5개 소모 -> k = 17
        * 2. 1학번 1개 소모 -> k = 16
        * 3. 2학번 5개 소모 -> k = 11
        * 4. 0학번 5개 소모 -> k = 6
        * 5. 1학번 1개 소모 -> k = 5
        * 6. 2학변 5개 소모 -> k = 0 // 이때 개수가 딱 0으로 되는 경우 분필 교체 담당 X
        * 7. 0학번 분필 교체 담당
        * */
        for (int[] testcase : testcases) {
            int index = testcases.indexOf(testcase);
            System.out.println(dq.chalkReplacer(testcase, kList.get(index)));
        }
    }
}
