package HaeInSung.LearningCurve.dailyCT.August2024;

/* 2 Keys Keyboard */

import java.util.ArrayList;
import java.util.List;

public class DQ_0650 {

    // n 을 소수 위주로 소인수분해를 해보자 -> 소인수분해를 해야 최소값이 나옴
    public int minSteps4(int n) {
        int result = 0;
        int prime = 2; // 최소 소수는 2
        while (n > 1) {
            while (n % prime == 0) {
                result += prime;
                n /= prime; // 더이상 못 나눌 때까지 계속 나누기
            }
            prime++; // n을 나누어떨어지게 하는 소인수가 될 때까지 계속 커질 것
        }

        return result; // 소인수들의 합(중복도 같이 더함)
    }

    public static void main(String[] args) {
        List<Integer> testcases = new ArrayList<>(List.of(3, 1));

        DQ_0650 dailyQ = new DQ_0650();
        for (int testcase : testcases) {
            System.out.println(dailyQ.minSteps4(testcase));
        }
    }
}
