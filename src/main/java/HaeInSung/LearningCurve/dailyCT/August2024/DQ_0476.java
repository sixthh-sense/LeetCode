package HaeInSung.LearningCurve.dailyCT.August2024;


import java.util.ArrayList;
import java.util.List;

/* Number Complement(보수) */
public class DQ_0476 {

    /* 문제 제한조건: num은 1이상 2의 31승 미만 */
    public int findComplement(int num) {
        int cnt = 0;
        while (num >= Math.pow(2, cnt)) {
            cnt++;
        };

        return (int) (Math.pow(2, cnt) - 1 - num);
    }

    public static void main(String[] args) {
        List<Integer> testcases = new ArrayList<>(List.of(5, 1));

        // 보수 구하기: 5의 경우 2^2 < 5 < 2^3이고 2^3에서 5를 뺀 거에 1을 빼면 2
        // 1의 경우 2^0 <= 1 < 2^1

        DQ_0476 dailyQ = new DQ_0476();

        for (Integer testcase : testcases) {
            System.out.println(dailyQ.findComplement(testcase));
        }
    }
}
