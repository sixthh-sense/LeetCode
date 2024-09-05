package HaeInSung.LearningCurve.dailyCT.September2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 9/5 Find Missing Observations
 * 정육면체 주사위 주사위 눈은 1~6
 * n + m번 관측을 했는데 n번은 missing 상태고 실제로 제대로 본 건 m번
 * 하지만 어떻게든 n + m번의 평균값은 아는 상태
 * 길이가 m인 관측 배열 rolls -> rolls의 i번째 요소는 i번째로 관측한 값
 * mean과 n도 주어지는데 mean은 평균 n은 놓친 관측 개수(위에서 말한 대로)
 * 평균값 mean을 충족할 수 있는 못 본 배열 을 반환할 것 - 여러 개가 가능하면 return any of them(그 중 아무거나 반환해도 ok?)
 * 참고로, mean은 **정수**이다. integer.
 * */
public class DQ_2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
//        int[] result = new int[n];
//
//        int rollTotal = 0;
//
//        for (int roll : rolls) {
//            rollTotal += roll;
//        }
//
//        int m = rolls.length;
//        int total = mean * (m + n);
//        System.out.println("m: " + m + System.lineSeparator() + "total: " + total + System.lineSeparator() + "rollTotal: " + rollTotal);
//
//        if ((total - rollTotal) % n != 0) {
//            return new int[]{};
//        } else {
//
//        }

//        return result;

        int sum = 0;
        for (int roll : rolls) {
            sum = sum + roll;
        }
        // Find the remaining sum.
        int remainingSum = mean * (n + rolls.length) - sum;
        // Check if sum is valid or not.
        if (remainingSum > 6 * n || remainingSum < n) {
            return new int[0];
        }
        int distributeMean = remainingSum / n;
        int mod = remainingSum % n;
        // Distribute the remaining mod elements in nElements array.
        int[] nElements = new int[n];
        Arrays.fill(nElements, distributeMean);
        for (int i = 0; i < mod; i++) {
            nElements[i]++;
        }
        return nElements;
    }

    public static void main(String[] args) {
        DQ_2028 dq = new DQ_2028();
        List<int[]> rollList = new ArrayList<>(Arrays.asList(new int[]{3, 2, 4, 3}, new int[]{1, 5, 6}, new int[]{1, 2, 3, 4}));;
        List<Integer> meanList = new ArrayList<>(List.of(4, 3, 6));
        List<Integer> nList = new ArrayList<>(List.of(2, 4, 4));

        for (int[] rolls : rollList) {
            int index = rollList.indexOf(rolls);
            System.out.println(Arrays.toString(dq.missingRolls(rolls, meanList.get(index), nList.get(index))));
        }
    }
}
