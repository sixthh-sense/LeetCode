package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.ArrayList;
import java.util.List;

/* 최소한의 숫자로 1끼리 연속되게 만드는 횟수를 구하자는 건데(끝과 끝은 연결된다는 규칙 아래에서) 이거 어렵네;; */
/* !!2024.08.02 첫 만남: 감이 안 잡히는 문제!! -> 힌트를 2개까지 보니까 dfs 등 재귀와 관련된 문제일 거라는 생각이 들었지만 여전히 구체적인 방안 생각x
 *  3번은 좀 결정적인 힌트인 듯?
 *  The sliding window technique >> 최종 힌트 :: 일단 답지 바로 보기 전에 이거에 대해 검색을 좀 해보자 */

/* Editorial #1 suffix sums */
/* Editorial #2, #3 Sliding Window >> 얘를 염두에 두고 만든 문제지만, 내가 봐도 지금 이해가 안 돼서(...) 일단 따라 쳐보면서 이해를 시도 */

public class DQ_2134_suffixSum {

    public static int minSwaps(int[] nums) {
        int result = 0;
        return result;
    }
    public static void main(String[] args) {
        List<int[]> numList = new ArrayList<>();
        numList.add(new int[]{0, 1, 0, 1, 1, 0, 0});
        numList.add(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0});
        numList.add(new int[]{1, 1, 0, 0, 1});

        for (int[] nums : numList) {
            minSwaps(nums);
        }
    }
}
