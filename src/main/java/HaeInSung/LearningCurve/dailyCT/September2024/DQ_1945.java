package HaeInSung.LearningCurve.dailyCT.September2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 9/3 Sum of Digits of String After Convert
 * 문자열 s는 영소문자로 구성되어있음
 * 정수 k
 * s에 소속된 각 알파벳을 대상으로 대응하는 숫자로 바꾼다 a는 1 b는 2... z는 26
 * 그 다음에 그 정수를 각 자리의 수끼리 더한다. -> 이 변환 작업을 총 k번 반복할 것
 * (예) s = "zbax"이고 k = 2라면 최종 정수값은 8이 나온다
 * zbax -> 26 2 1 24 -> 262124
 * #1 2 + 6 + 2 + 1 + 2 + 4 = 17
 * #2 17 -> 1 + 7 = 8
 *
 * char가 사실은 unicode값이라 자동 정수변환?이 되는 아이인데 이걸 이용해야 할 듯
 * */
public class DQ_1945 {

    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            String alt = String.valueOf((Character.getNumericValue(c) - 9));
            sb.append(alt);
        }

        String build = sb.toString();

        while (k-- > 0) { // 연산한 후에 k 빼기
            int digitSum = 0;
            for (char digit : build.toCharArray()) {
                digitSum += Character.getNumericValue(digit);
            }
            build = Integer.toString(digitSum);
        }

        return Integer.parseInt(build);
    }

    public static void main(String[] args) {
        DQ_1945 dq = new DQ_1945();

        List<String> testcases = new ArrayList<>(Arrays.asList("iiii", "leetcode", "zbax"));
        List<Integer> kList = new ArrayList<>(List.of(36, 6, 8));

        for (String testcase : testcases) {
            int index = testcases.indexOf(testcase);
            System.out.println(dq.getLucky(testcase, kList.get(index)));
        }
    }
}
