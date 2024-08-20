package HaeInSung.LearningCurve.Explore.Recursion.Memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 계단을 오르는 중인데 정상에 가려면 n 걸음이 필요한 상태
* 한 번에 1계단 혹은 2계단씩 오를 때, 정상까지 가는 방법에 얼마나 다양한 경우의 수가 존재하는가? */

/* 제한조건: n은 1이상 45이하의 정수 */
public class ClimbingStairs {

    Map<Integer, Integer> stairMap = new HashMap<>();

    public int climbStairs(int n) {

        if (stairMap.containsKey(n)) {
            return stairMap.get(n);
        }

        if (n <= 2) {
            stairMap.put(n, n);
            return n;
        }

        // 경우의 수 계산: 1칸 남았을 땐 1칸을 갈 경우의 수밖에 없고 2칸 남았을 땐 2칸을 한꺼번에 가거나 1칸을 1걸음씩 가는 2가지 경우의 수가 있음 - 중복
        int result = climbStairs(n - 1) + climbStairs(n - 2);

        stairMap.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> testcases = new ArrayList<>(List.of(2, 3));

        ClimbingStairs recursion = new ClimbingStairs();

        for (int testcase : testcases) {
            System.out.println(recursion.climbStairs(testcase));
        }

    }
}
