package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.*;

/* Ugly Number */
/* An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.
(1 <= n <= 1690)
*/

public class DQ_0264 {

    /* Min-Heap/Priority Queue approach :: LeetCode approach에 개인적인 해석 덧붙임 */
    public int nthUglyNumber(int n) {
        // n 제한조건 따졌을 때 Long으로 설정해야 함?
        PriorityQueue<Long> minHeap = new PriorityQueue<>(); // 자동으로 순차정렬
        Set<Long> seenNumbers = new HashSet<>(); // Set to avoid duplicates
        int[] primeFactors = { 2, 3, 5 }; // Factors for generating new ugly numbers

        // 일단 1은 기본적으로 추가해줌
        minHeap.offer(1L);
        seenNumbers.add(1L);

        // 기본: 1
        long currentUgly = 1L;
        for (int i = 0; i < n; i++) {
            currentUgly = minHeap.poll(); // Get the smallest number

            // Generate and push the next ugly numbers
            for (int prime : primeFactors) {
                long nextUgly = currentUgly * prime;
                if (seenNumbers.add(nextUgly)) { // Avoid duplicates
                    minHeap.offer(nextUgly);
                }
            }
        }

        return (int) currentUgly; // Return the nth ugly number
    }

    public static void main(String[] args) {
        List<Integer> testcases = new ArrayList<>();
        testcases.add(10);
        testcases.add(1);

        DQ_0264 dailyQ = new DQ_0264();
        for (Integer testcase : testcases) {
            System.out.println(dailyQ.nthUglyNumber(testcase));
        }
    }
}
