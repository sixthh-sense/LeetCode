package HaeInSung.LearningCurve.Explore.Recursion.Memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FibonacciNumber { // n(0이상 30미만의 정수)을 줬을 때 그 단계에 해당하는 피보나치 수열값 return 하기

    /* Memoization Intro 에 나온 문제랑 똑같아서 거의 복사&붙여넣기 */

    HashMap<Integer, Integer> fibInfo = new HashMap<>(); // n번째의 피보나치 수열 값 -> n번째가 key, 피보나치 수열값이 value

    public int fib(int n) {
        if (fibInfo.containsKey(n)) {
            return fibInfo.get(n);
        }

        int result;
        if (n == 0 || n == 1 ) {
            result = n;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }
        fibInfo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> testcases = new ArrayList<>(List.of(2, 3, 4));
        FibonacciNumber memoization = new FibonacciNumber();

        for (Integer testcase : testcases) {
            System.out.println(memoization.fib(testcase));
        }
    }
}
