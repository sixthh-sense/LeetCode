package HaeInSung.LearningCurve.dailyCT.August2024;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Combination Sum 2 */
/* 막연하게 candidateList를 순차 정렬하면 좋을 것 같다는 발상까진 했으나 구체적으로 backtracking 하는 방법까지는 생각해내지 못함 */
/* 2024.08.13 기준 LeetCode Editorial 참조 */
public class DQ_0040 {

    List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resultList = new LinkedList<>();
        Arrays.sort(candidates); // 순차 정렬
        backtrack(resultList, new ArrayList<Integer>(), candidates, target, 0);
        return resultList;
    }

    /* backtracking 기법을 통해 풀기 */
    private void backtrack(List<List<Integer>> answer, List<Integer> tempList, int[] candidates, int totalLeft, int index) {
        // totalLeft는 총합에서 현재까지 answerList에 넣은 값들을 다 뺀 것 -> 음수라면 과하게 넣었다는 소리니 return
        if (totalLeft < 0) {
            return;
        } else if (totalLeft == 0) { // 0이라면 딱 알맞게 넣었다는 소리니 답에 해당. distinct 조심
            answer.add(new ArrayList<>(tempList));
        } else { // totalLeft > 0 -> 수많은(?) 가능성이 남아있는 시기?
            for (int i = index; i < candidates.length && totalLeft >= candidates[i]; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tempList.add(candidates[i]);
                // check for all possible scenarios
                backtrack(answer, tempList, candidates, totalLeft - candidates[i], i + 1);
                // backtrack the tempList
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        DQ_0040 dailyQ = new DQ_0040();

        List<int[]> candidateList = new ArrayList<>();
        candidateList.add(new int[]{10, 1, 2, 7, 6, 1, 5});
        candidateList.add(new int[]{2, 5, 2, 1, 2});

        int[] targetList = new int[]{8, 5};

        for (int[] candidate : candidateList) {
            int index = candidateList.indexOf(candidate);
            System.out.println(dailyQ.combinationSum2(candidate, targetList[index]));
        }

    }
}
