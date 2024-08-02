package HaeInSung.LearningCurve.SlidingWindow.Easy;

import java.util.ArrayList;
import java.util.List;

/* sliding window approach와 연관있다고 검색 결과에 나온 easy 문제라서 한번 봤는데 sliding window approach에 꼭 들어맞지는 않음 */
/* sliding window가 좀 확실히 이해가 됐다고 느껴질 때까지 거기에 관련된 문제를 계속 풀어보자... 8/2 오늘부터 1개씩 */
public class SW_219 {

    // 사실 얘는 그냥 기본적으로 for문 돌리는 거고 Set Tree 이용하는 방식이  window 방식이라고 나와있는데 걔는 8/2 정리x 나중에 정리할 것!
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        SW_219 slidingWindow = new SW_219();

        List<int[]> numList = new ArrayList<>();
        numList.add(new int[]{1, 2, 3, 1});
        numList.add(new int[]{1, 0, 1, 1});
        numList.add(new int[]{1, 2, 3, 1, 2, 3});

        int[] intArr = new int[]{3, 1, 2};

        for (int i = 0; i < numList.size(); i++) {
            System.out.println(slidingWindow.containsNearbyDuplicate(numList.get(i), intArr[i]));;
        }

    }
}

