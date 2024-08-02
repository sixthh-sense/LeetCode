package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 최소한의 숫자로 1끼리 연속되게 만드는 횟수를 구하자는 건데(끝과 끝은 연결된다는 규칙 아래에서) 이거 어렵네;; */
/* !!2024.08.02 첫 만남: 감이 안 잡히는 문제!! -> 힌트를 2개까지 보니까 dfs 등 재귀와 관련된 문제일 거라는 생각이 들었지만 여전히 구체적인 방안 생각x
 *  3번은 좀 결정적인 힌트인 듯?
 *  The sliding window technique >> 최종 힌트 :: 일단 답지 바로 보기 전에 이거에 대해 검색을 좀 해보자 */

/* Editorial #1 suffix sums */
/* Editorial #2, #3 Sliding Window >> 얘를 염두에 두고 만든 문제지만, 내가 봐도 지금 이해가 안 돼서(...) 일단 따라 쳐보면서 이해를 시도 */


/* suffix sum 관련해서 2574번 문제도 찾아보라고 알려주네... 친절한 걸? */
public class DQ_2134_suffixSum {

    /* 8/2 작성한 건 내 풀이 아님. 이해가 안 돼서 Editorial 풀이 따라한 것 */

    public static int minSwaps(int[] nums) {
        // Calculate the minimum swaps needed to group all 1s or all 0s together
        // 0과 1밖에 없으니까 0이든 1이든 각자의 관점에서 뭉치게 하면 나머지를 뭉치게 하는 셈이 되니까 그런 거구나
        // 근데 0과 1밖에 없는 상황에서만 이 방법을 사용할 수 있을 듯 ... 3개 이상의 숫자가 있을 때도 응용 가능할까(?)

        int op1 = minSwapHelper(nums, 0); // grouping all 0s together
        int op2 = minSwapHelper(nums, 1); // grouping all 1s together
        return Math.min(op1, op2); // 더 적게 움직이는 쪽을 계산해서 return 값으로 반환
    }

    // 얘가 실세임. val로 지정된 숫자들을 한군데 모으기 위해 필요한 최소값 구하는 함수
    public static int minSwapHelper(int[] data, int val) {
        int length = data.length;
        int[] rightSuffixSum = new int[length + 1]; // length에 1을 더해주는 센스

        // 반대 값으로 이루어진 array의 개수를 구하기 위한 suffix sum array를 구성하라? val ^ 1이라는데 이 ^ 기호가 뭔지 모르겠다
        // ^는 비트 연산자의 XOR 이라는데 뭔 소리여... -> 1이 들어오면 1의 xor은 0, 0이 들어오면 1을 고르겠다 이 소린가
        for (int i = length - 1; i >= 0; i--) {
            // rightSuffixSum[length - 1] = rightSuffix[length] 부터 시작해서 한칸씩 앞으로 감
            // 사실상 맨 마지막 항은 반드시 0이 될 수밖에 없는 구조네
            rightSuffixSum[i] = rightSuffixSum[i + 1]; // 이 형식을 취하기 때문에 앞항은 뒤의 항보다 값이 크거나 같을 수밖에 없음. 앞쪽 항 값이 뒤쪽 항보다 클 때만 변화가 있는 것
            if (data[i] == (val ^ 1)) {
                rightSuffixSum[i]++;
            }
        }
        System.out.println("rightSuffixSum: " + Arrays.toString(rightSuffixSum));

        int totalSwapsNeeded = rightSuffixSum[0]; // 얘는 사실 rightSuffixSum의 최대값임

        int currentSwapCount = 0;
        int minimumSwaps = totalSwapsNeeded - rightSuffixSum[length - totalSwapsNeeded]; // 이게 suffix sum의 공식에 관련된 부분일 듯

        // iterate to find the minimum swaps by sliding the potential block of grouped 'val'
        for (int i = 0; i < totalSwapsNeeded; i++) {
            if (data[i] == (val ^ 1)) currentSwapCount++;
            int remaining = (totalSwapsNeeded - i - 1);
            int requiredSwaps = ((i + 1) - currentSwapCount) + (remaining - rightSuffixSum[length - remaining]);
            minimumSwaps = Math.min(minimumSwaps, requiredSwaps);
        }
        return minimumSwaps;
    }

    public static void main(String[] args) {
        List<int[]> numList = new ArrayList<>();
        numList.add(new int[]{0, 1, 0, 1, 1, 0, 0});
        numList.add(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0});
        numList.add(new int[]{1, 1, 0, 0, 1});

        for (int[] nums : numList) {
            System.out.println("answer: " + minSwaps(nums));
        }
    }
}
