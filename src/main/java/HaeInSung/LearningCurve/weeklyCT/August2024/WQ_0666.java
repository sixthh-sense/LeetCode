package HaeInSung.LearningCurve.weeklyCT.August2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Path Sum 4 */
public class WQ_0666 {

    // 위치정보(key) : value 저장해둘 맵
    Map<Integer, Integer> nodeMap = new HashMap<>();

    public int pathSum(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;

        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            nodeMap.put(key, value);
        }
         return dfs(nums[0] / 10, 0);
    }

    private int dfs(int root, int preSum) {
        int level = root / 10; // nums[0]을 10로 나눈 거에 다시 10을 나눴으니 사실 100의 자리
        int pos = root % 10; // 10의 자리
        // 자식노드가 있을 경우의 위치 정보
        int left = (level + 1) * 10 + pos * 2 - 1; // -1 한 이유는 '왼쪽'이니까
        int right = (level + 1) * 10 + pos * 2; // -1가 없는 이유는 오른쪽이니까
        int currSum = preSum + nodeMap.get(root); // preSum은 0부터 시작, preSum에 차근차근 nodeMap root로 얻을 수 있는 정보부터 더하기

        if (!nodeMap.containsKey(left) && !nodeMap.containsKey(right)) return currSum;

        int leftSum = nodeMap.containsKey(left) ? dfs(left, currSum) : 0;
        int rightSum = nodeMap.containsKey(right) ? dfs(right, currSum) : 0;

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        WQ_0666 wq = new WQ_0666();

        List<int[]> testcases = new ArrayList<>();
        testcases.add(new int[]{113, 215, 221});
        testcases.add(new int[]{113, 221});

        for (int[] testcase : testcases) {
            System.out.println(wq.pathSum(testcase));
        }
    }
}
