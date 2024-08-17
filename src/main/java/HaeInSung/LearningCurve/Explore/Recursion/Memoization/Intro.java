package HaeInSung.LearningCurve.Explore.Recursion.Memoization;

import java.util.HashMap;

public class Intro {

    // 피보나치 수열 F(n) = F(n - 1) + F(n - 2)을 그대로 구현한 것
    public static int fibonacci(int n) {
        if (n < 2) { // n = 0, n = 1일 때는 기초항
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // 피보나치 수열에 Memoization 기법을 도입한 것
    // 정보저장용 HashMap 을 만들어서 중간 연산 과정 줄이는 기법
    HashMap<Integer, Integer> cache = new HashMap<>();

    private int fib(int N) {
        if (cache.containsKey(N)) { // 이미 연산을 했으면 이미 저장해둔 cache 에서 꺼내씀 -> 불필요한 연산 건너뒴
            return cache.get(N);
        }
        int result;
        if (N < 2) { // 0, 1일 때는 초기항
            result = N;
        } else {
            result = fib(N - 1) + fib(N - 2); // 피보나치 수열 공식
        }
        cache.put(N, result); // cache 에 정보 저장: N 단계 피보나치 수열 값은 result
        return result; // result 반환
    }

    public static void main(String[] args) {
        int testInt = 10;
        Intro intro = new Intro();
        System.out.println("fibonacci: " + intro.fibonacci(testInt));
        System.out.println("fib: " + intro.fib(testInt));
    }
}
