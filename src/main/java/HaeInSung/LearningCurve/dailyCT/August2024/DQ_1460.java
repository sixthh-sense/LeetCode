package HaeInSung.LearningCurve.dailyCT.August2024;

/* Make Two Arrays Equal by Reversing Subarrays */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 순서가 문제의 핵심이 아니라 배열을 이루는 요소들이 동일한지 아닌지를 따져야 하는 듯
* 순서 바꿔서 동일해질 수 있으면 true, 그럴 수 없으면 false라는데 순서 바꾸는 방법과 횟수 등에 제한이 없음 */
public class DQ_1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
    public static void main(String[] args) {
        DQ_1460 makeEqual = new DQ_1460();


        List<int[]> targetList = new ArrayList<>();
        targetList.add(new int[]{1, 2, 3, 4});
        targetList.add(new int[]{7});
        targetList.add(new int[]{3, 7, 9});

        List<int[]> arrList = new ArrayList<>();
        arrList.add(new int[]{2, 4, 1, 3});
        arrList.add(new int[]{7});
        arrList.add(new int[]{3, 7, 11});

        for (int i = 0; i < targetList.size(); i++) {
            System.out.println(makeEqual.canBeEqual(targetList.get(i), arrList.get(i)));
        }
    }
}
