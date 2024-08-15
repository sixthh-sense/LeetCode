package HaeInSung.LearningCurve.dailyCT.August2024;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Lemonade Change */

/* 레모네이드 판매대에서 레모네이드를 파는데 레모네이드 한 잔에 5달러
* 손님들은 레모네이드를 사기 위해 줄을 섰는데 bills에 제시된 순서대로 한 명씩 삼
* 각 손님은 한 번에 한 레모네이드만 사고 5달러/10달러/20달러 지폐를 지불함
* 그래서 판매자는 각 손님에게 올바른 거스름돈을 건네줘야 함(순이익 손님당 5달러가 되게끔)
* 주의할 점: 처음엔 거스름돈이 없는 상태
* bills는 손님들이 지불하는 지폐 순서
* 그래서 bills 조건이 있을 때 거스름돈을 제대로 지불하는 게 가능하면 true, 아니면 false */
public class DQ_0860 {

    public boolean lemonadeChange(int[] bills) {
        boolean result = true;

        int[] stack = new int[3]; // 5달러, 10달러, 20달러 개수 저장용

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 10) { // 5달러 거스름돈 -> 5달러 지불
                if (stack[0] < 1) {
                    return false;
                } else {
                    stack[1]++;
                    stack[0]--;
                }
            } else if (bills[i] == 20) { // 15달러 거스름돈
                if (stack[1] < 1) { // 10달러가 없으면 5달러 3개
                    if (stack[0] >= 3) {
                        stack[0] -= 3;
                        stack[2]++;
                    } else {
                        return false;
                    }
                } else { // 10달러 있으면 10달러 하나, 5달러 하나
                    if (stack[0] < 1) {
                        return false;
                    } else {
                        stack[0]--;
                        stack[1]--;
                        stack[2]++;
                    }
                }
            } else { // 5달러 내서 거스름돈 없는 경우
                stack[0]++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<int[]> testcases = new ArrayList<>();
        testcases.add(new int[] {5, 5, 5, 10, 20});
        testcases.add(new int[] {5, 5, 10, 10, 20});
        testcases.add(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 5, 5});

        DQ_0860 dailyQ = new DQ_0860();

        for (int[] testcase : testcases) {
            System.out.println(dailyQ.lemonadeChange(testcase));
        }
    }
}
