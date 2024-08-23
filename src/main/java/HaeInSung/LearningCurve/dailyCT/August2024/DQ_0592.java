package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.*;

/* Fraction Addition and Subtraction */
/* Expression에 분수 연산이 나오는데 그걸 계산한 걸 return해주기. 정수가 나오면 분모값은 1로 표기할 것 */
/* 제한조건: 분모/분자 자리에 1~10 사이의 값만 옴, 연산은 + 아니면 -, 결과값은 32-bit int값 표현범위 내에 있음 */
public class DQ_0592 {

    public String fractionAddition(String expression) {
        String[] parts = expression.split("/|(?=[-+])"); // 먼저 /로 나눈 다음에 전방탐색(?=)
        // -> ?는 바로 앞에서 분리하라는 뜻이고 =[-+]는 전방탐색 범위 지정(- 또는 + 문자가 나타나면 그 앞에서 분리)
//        System.out.println(Arrays.toString(parts)); // 이러면 expression이 -1/2+1/2일 때 -1, 2, +1, 2로 분리됨

        Map<Integer, Integer> fractionMap = new HashMap<>();

        for (int i = 0; i < parts.length - 1; i+=2) { // 문제 특성상 parts.length는 짝수가 될 수밖에 없음
            int value = (fractionMap.get(Integer.parseInt(parts[i + 1])) == null) ? 0 : fractionMap.get(Integer.parseInt(parts[i + 1]));
            fractionMap.put(Integer.parseInt(parts[i + 1]), value + Integer.parseInt(parts[i]));
        }

        System.out.println("result map: " + fractionMap);

        for (Integer key : new HashMap<>(fractionMap).keySet()) {
            if (fractionMap.get(key) == 0) {
                fractionMap.remove(key);
            }
        }

        if (fractionMap.size() == 0) {
            return "0/1";
        } else if (fractionMap.size() == 1) {
            int key = fractionMap.keySet().iterator().next();
            int value = fractionMap.get(key);
            if (value < key) {
                return value + "/" + key;
            } else {
                int gcd = Math.abs(gcd(key, value));
                value = value / gcd;
                key = key / gcd;
                return value + "/" + key;
            }
        }

        int LCM = findLCM(fractionMap.keySet());
        int numerator = 0;
        for (Integer key : fractionMap.keySet()) {
            numerator += fractionMap.get(key) * LCM / key;
        }
        // 최소공배수를 구해서 거기에 맞춰 곱했어도 여전히 최소단위가 아닐 수 있음. testcase "7/3+5/2-3/10"
        // 2, 3, 10 최소공배수인 30에 맞춰 계산을 했지만 더하고 나니 136/30이 되어 나눠질 여력이 생김 -> 이런 건 어떻게 검사하지?

        // 여기에 검사과정 한번 더 추가해야 함
        int GCD = gcd(LCM, numerator);
        System.out.println("GCD: " + GCD);
        if (GCD > 1) {
            LCM /= GCD;
            numerator /= GCD;
        } else if (GCD < 1) {
            GCD = Math.abs(GCD);
            LCM /= GCD;
            numerator /= GCD;
        }
        // 검사과정 끝

        StringBuilder sb = new StringBuilder();
        sb.append(numerator).append("/").append(LCM);
        return sb.toString();
    }
    // Set<Integer> 기준으로 최소공배수 구하기
    public int findLCM(Set<Integer> numbers) {
        int lcm = 1; // 초기값은 1
        for (int num : numbers) {
            lcm = lcm(lcm, num); // 현재까지의 lcm과 다음 숫자의 lcm을 계산
        }
        return lcm;
    }

    // 두 수의 최소공배수를 계산하는 메소드
    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // 두 수의 최대공약수를 계산하는 메소드 (유클리드 호제법 사용)
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        DQ_0592 dq = new DQ_0592();

        List<String> testcases = new ArrayList<>(List.of("-1/2+1/2", "-1/2+1/2+1/3", "1/3-1/2"));
        testcases.add("5/3+1/3");
        testcases.add("7/3+5/2-3/10");
        testcases.add("1/2-4/1-4/3+1/2-5/1");
        testcases.add("5/4");

        for (String testcase : testcases) {
            System.out.println(dq.fractionAddition(testcase));
        }
    }
}
