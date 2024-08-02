package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.ArrayList;
import java.util.List;

/* 이건 sliding window 개념만 봤을 땐 몰랐는데 editorial approach 상세 설명을 보니까 이해가 좀 됨(완벽히는 아니지만) */
/* sliding window approach도 2개가 있는데 2가지 모두 적어는 보겠음... */
public class DQ_2134_slidingWindow {

    /* 1st approach
    * 1. 1이랑 0이랑 죄다 모으는 걸 고려했을 때, 1이랑 0이 각각 몇 개씩 있는지 구하기
    * 2. 1이랑 0이랑 각각 집산시키기 위해 필요한 최소값이 얼마인지 함수로 구하기
    * 3. 2 중에서 최소값 구하기
    * 여기까지만 보면 suffix sum이랑 비슷해보이지만 그 '함수' 부분이 다름
    * 0 개수가 4이고 9개의 배열 중에서 얘네들을 다 모을 수 있는 경우의 수를 찾는다 치면
    * 0 ~ 3, 1 ~ 4 ... 5 ~ 8 식으로 6개 경우의 수를 구하고 그 경우의 수에서 나온 '최소 change 개수'를 구하면 됨
    * distinct 한 애들을 그냥 위치를 바꿔주기만 하면 되는 규칙
    * 4 - (4개의 창 안에서 보이는 0의 개수 :: 0의 개수가 최대일 때 최소 변환값이 나오겠지) = (최소) 변환값
    *  */
    public int minSwaps_1(int[] nums) {
        // 0과 1 각각 최소값 구하기
        int op0 = minSwapsHelper_1(nums, 0);
        int op1 = minSwapsHelper_1(nums, 1);
        return Math.min(op0, op1);
    }

    public int minSwapsHelper_1(int[] data, int val) {
        int length = data.length;
        int totalValCount = 0;

        // 여기서 data에 val이 몇 개 들어가있는지 구함
        for (int num : data) {
            if (num == val) {
                totalValCount++; // 최종 개수 나왔고요
            }
        }

        // 예외 상황 제거 (swap이 필요 없을 때: data에 val이 전혀 없을 때 혹은 전부 다일 때)
        if (totalValCount == 0 || totalValCount == length) {
            return 0;
        }

        int start = 0, end = 0;
        int maxValInWindow = 0, currentValInWindow = 0;

        // 얘는 초기값일 뿐? -> 여기까지는 이해가 되는데
        while (end < totalValCount) { // 9개 중에서 4개 window를 찾을 때 index 5 뒤로는 못 가는 원리
            if (data[end++] == val) { // 계산한 뒤에 end를 1개 올려주는 센스. 여기서 end++를 안 하면 if문 안에서 end++ 해야 될 듯.
                currentValInWindow++; // 현재 window안에 몇 개가 있는지 세어야지
            }
        }
//        System.out.println("end: " + end);
        maxValInWindow = Math.max(maxValInWindow, currentValInWindow); // 얘는 최고기록 기록용이고

        // 이동형 sliding ... 이라는데 start++하면서 currentValInWindow를 빼는 게 잘 이해가 안 되네
        // 다시 보니까 뭔 말인지 알 것 같음.
        // 초기값에서 한칸씩 옆으로 옮기는데, 먼저 빠지는 값이 val에 해당하는 값이라면
        // 새로운 window에선 val이 한 개가 빠졌다는 뜻이니까 그걸 빼고 계산하겠다는 거군.
        // 1칸씩 이동하니까 저런 식으로 계산하는 거
        while (end < length) {
            if (data[start++] == val) {
                currentValInWindow--;
            }
            if (data[end++] == val) {
                currentValInWindow++;
            }
            maxValInWindow = Math.max(maxValInWindow, currentValInWindow); // 최고기록 기록에 충실
        }
        return totalValCount - maxValInWindow; // maxValInWindow가 클수록 최소값이 최소가 된다
    }

    /* 2번째 sliding window approach는 같은 sliding window approach를 사용하기 때문에 본질적인 원리는 같지만
    * 훨씬 더 세련된 방법으로 계산하고 있음 */

    public int minSwaps_2(int[] nums) {
        int minimumSwaps = Integer.MAX_VALUE; // 임의의 '아주 큰 수'

        int totalOnes = 0;
        for (int num : nums) {
            totalOnes += num; // 어차피 0 아니면 1이니까 1개수를 구하기 위해서 num 더해도 ok. 나라면 if문 걸고 +1을 했을 것 같지만 이게 더 빠른가?
        }

        int onesCount = nums[0];
        int end = 0;

        for (int start = 0; start < nums.length; ++start) { // 더하고 나서 계산 시작?
            if (start != 0) {
                onesCount -= nums[start - 1]; // 얘는 좀 이해하기 힘든데 window에서 빠져나온 값을 제거함으로써 onesCount를 조정하라는데??
            }

            // 원하는 크기가 될 때까지 오른쪽으로 window 확장하기
            while (end - start + 1 < totalOnes) {
                end++;
                onesCount += nums[end % nums.length];
            }

            minimumSwaps = Math.min(minimumSwaps, totalOnes - onesCount);
        }

        return minimumSwaps;
    }

    public static void main(String[] args) {
        DQ_2134_slidingWindow slidingWindow = new DQ_2134_slidingWindow();

        List<int[]> numList = new ArrayList<>();
        numList.add(new int[]{0, 1, 0, 1, 1, 0, 0});
        numList.add(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0});
        numList.add(new int[]{1, 1, 0, 0, 1});

        for (int[] nums : numList) {
            System.out.println("minSwaps_1 answer: " + slidingWindow.minSwaps_1(nums));
            System.out.println("minSwaps_2 answer: " + slidingWindow.minSwaps_2(nums));
        }
    }
}
