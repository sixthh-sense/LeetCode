package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.*;

/* Maximum Distance in Arrays */
/* input으론 int[]들을 모아놓은 arrays가 주어지는데 각 int[]들은 순차적으로 정렬되어있음
* 이 서로 다른 각기의 array중에서 값 한 개씩을 뽑을 때 arrays 기준으로 값이 "최대한" 많이 차이나는 걸 반환하기 */
public class DQ_0624 {
    /* 2024.08.16 문제 보고 나서 든 생각
    * arrays 통틀어서 최대값, 최소값 구하는 건 대충 알 것 같다
    * 그러면 이렇게 구한 최대값, 최소값을 빼면 max return이 되겠지만 예외가 있다
    * 최대값, 최소값이 한 array에 들어있을 때
    * -> 이때는 최대값 그대로 두고 나머지 arrays에서 최소값 구하는 거랑
    * -> 최소값 그대로 두고 나머지 arrays에서 최대값 구하는 거랑 따로 계산해야 하나?
    * 아니면 다른 식으로 푸는 방법이 있을까?
    * 뭔가 쉬운 듯하면서도 난해하다... 이해도 못할 수준으로 어렵진 않은데 제대로 된 풀이 방법을 알기 전까지 엄청 짜증나게 할 듯한 문제
    * 2번째로 작은 최소값, 2번째로 큰 최대값까지 구해야 하나?
    * 아니면 각 arrays마다 최소값, 최대값을 일일이 구해야 하나?
    * (1)전체 최대값/최소값부터 먼저 찾은 뒤에
    * (2) 거길 뺀 나머지 arrays에서 최소값/최대값 찾고 그걸 빼면 되나? -> 이걸 식별하는 게 어렵네...
    * 순차정렬이 되어있으니까 array마다 첫번째 값이 최소값이고 마지막 값이 최대값이겠네
    * */

    public int maxDistance(List<List<Integer>> arrays) {

        Integer max = -10000;    // 문제 제한조건: 최소값
        Integer min = 10000;     // 문제 제한조건: 최대값

        for (List<Integer> array : arrays) {
            if (max <= array.get(array.size() - 1)) {
                max = array.get(array.size() - 1);
            }

            if (min >= array.get(0)) {
                min = array.get(0);
            }
        }

        System.out.println("max: " + max);
        System.out.println("min: " + min);

        boolean dupChk = false;

        for (List<Integer> array : arrays) {
            if (array.get(0) == min && array.get(array.size() - 1) == max) {
                dupChk = true;
                arrays.remove(array);
                break;
            }
        }

        System.out.println("dupChk: " + dupChk);

        if (dupChk) {
            Integer max2 = -10^4;
            Integer min2 = 10^4;

            for (List<Integer> array : arrays) {
                if (max2 <= array.get(array.size() - 1)) {
                    max2 = array.get(array.size() - 1);
                }

                if (min2 >= array.get(0)) {
                    min2 = array.get(0);
                }
            }

            System.out.println("max2: " + max2);
            System.out.println("min2: " + min2);

            return Math.max((max - min2), (max2 - min));
        }

        return max - min;

        /* 이렇게 하니까 Runtime Error */
        /* 그리고 나중에야 생각난 건데 최대값이 '여러 array'에 있을 경우에 대한 고려를 덜 했다 */
        /*
        Integer max = 0;
        for (List<Integer> array : arrays) {
            if (max <= array.get(array.size() - 1)) {
                max = array.get(array.size() - 1);
            }
        }

        for (List<Integer> array : arrays) {
            if (array.contains(max)) {
                arrays.remove(array); // .ConcurrentModificationException
            }
        }

        Integer min = 10^4; // 문제 제한조건에 나왔던 최대값
        for (List<Integer> array : arrays) {
            if (min >= array.get(0)) {
                min = array.get(0);
            }
        }
        return max - min;
         */
    }

    public static void main(String[] args) {
        List<List<List<Integer>>> testcases = new ArrayList<>();

        testcases.add(new ArrayList<>(List.of(List.of(1, 2, 3), List.of(4, 5), List.of(1, 2, 3))));
        testcases.add(new ArrayList<>(List.of(List.of(1), List.of(1))));
        testcases.add(new ArrayList<>(List.of(List.of(1), List.of(2)))); // .ConcurrentModificationException
        testcases.add(new ArrayList<>(List.of(List.of(1, 5), List.of(3, 4)))); /* 최대값을 구하고 나머지 array에서 최소값을 구하는 게 반드시 정답이 아님. 최소값 -> 최대값이 정답일 때도 있음 */
        testcases.add(new ArrayList<>(List.of(List.of(-3, -3), List.of(-3, -2)))); // 1이 나와야 하는데 3이 나와버렸네??

        DQ_0624 dailyQ = new DQ_0624();

        for (List<List<Integer>> testcase : testcases) {
            System.out.println("result: " + dailyQ.maxDistance(testcase));
        }
    }
}
