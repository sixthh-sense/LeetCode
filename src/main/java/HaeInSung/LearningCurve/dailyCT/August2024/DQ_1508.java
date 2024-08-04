package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.*;


/* Range Sum of Sorted Subarray Sums */
/* 문제 제한조건을 읽어봐도 잘 모르겠는 점: nums는 sorted된 상태로 등장하는 건가?? */
public class DQ_1508 {

    private static final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {

        /* 첫 시도 -> 잘못된 풀이 :: 거의 모든 testcase를 통과했지만 nums가 100으로만 구성된 n = 1000 테스트 케이스에서
        * 양수가 나와야 하는데 음수가 나와버림 */
        /*
        int[] resultArr = new int[n * (n + 1) / 2];

        int index = 0;

        for (int i = 0; i < nums.length; i++) { // i는 첫번째로 더하는 값
            int sum = 0;
            resultArr[index] = nums[i]; // 합과 별개로 i는 한번 넣어줘야
            sum = nums[i];
            index++;
            for (int j = i + 1; j < nums.length; j++) { // j는 2번째로 더하는 값
                sum += nums[j];
                resultArr[index] = sum;
                index++;
            }
        }

        int result = 0;

        Arrays.sort(resultArr);

        for (int i = left - 1; i <= right - 1; i++) {
            result += resultArr[i];
        }

        return result;

         */

        /* LeetCode에서 추천한 유형의 풀이: Sliding Window approach */

        long result = (sumOfFirstK(nums, n, right) - sumOfFirstK(nums, n, left - 1)) % MOD;
        // Ensure non-negative result
        return (int) ((result + MOD) % MOD);
    }

    // Helper function to count subarrays with sum <= target and their total sum.
    private Map.Entry<Integer, Long> countAndSum(
            int[] nums,
            int n,
            int target
    ) {
        int count = 0;
        long currentSum = 0, totalSum = 0, windowSum = 0;
        for (int j = 0, i = 0; j < n; ++j) {
            currentSum += nums[j];
            windowSum += nums[j] * (j - i + 1);
            while (currentSum > target) {
                windowSum -= currentSum;
                currentSum -= nums[i++];
            }
            count += j - i + 1;
            totalSum += windowSum;
        }
        return new AbstractMap.SimpleEntry<>(count, totalSum);
    }

    // Helper function to find the sum of the first k smallest subarray sums.
    private long sumOfFirstK(int[] nums, int n, int k) {
        int minSum = Arrays.stream(nums).min().getAsInt();
        int maxSum = Arrays.stream(nums).sum();
        int left = minSum, right = maxSum;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countAndSum(nums, n, mid).getKey() >= k) right = mid - 1;
            else left = mid + 1;
        }
        Map.Entry<Integer, Long> result = countAndSum(nums, n, left);
        // There can be more subarrays with the same sum of left.
        return result.getValue() - left * (result.getKey() - k);
    }

    public static void main(String[] args) {
        DQ_1508 rangeSum = new DQ_1508();
        List<int[]> numsList = new ArrayList<>();
        numsList.add(new int[]{1, 2, 3, 4});
        numsList.add(new int[]{1, 2, 3, 4});
        numsList.add(new int[]{1, 2, 3, 4});

        int[] numList = new int[numsList.size()];
        for (int i = 0; i < numsList.size(); i++) {
            numList[i] = numsList.get(i).length;
        }

        int[] leftList = new int[numsList.size()];
        leftList[0] = 1;
        leftList[1] = 3;
        leftList[2] = 1;

        int[] rightList = new int[numsList.size()];
        rightList[0] = 5;
        rightList[1] = 4;
        rightList[2] = 10;

        for (int[] oneList : numsList) {
            int index = numsList.indexOf(oneList);
            System.out.println(rangeSum.rangeSum(oneList, numList[index], leftList[index], rightList[index]));
        }
    }
}
