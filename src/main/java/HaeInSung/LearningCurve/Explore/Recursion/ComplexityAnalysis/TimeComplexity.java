package HaeInSung.LearningCurve.Explore.Recursion.ComplexityAnalysis;

/* 시간 복잡도 구하는 법 */
public class TimeComplexity {
    /* Time Complexity =
    * O(T)=R∗O(s) (each recursion call)
    * = (the number of Recursion invocations) * (time complexity of calculation)
    * */

    /* Example 1: printReverse
    * printReverse(str) = printReverse(str[1 ... n]) + print(str[0])
    * 여기서 재귀호출은 n번 있을 수 있고
    * 각 재귀때마다 단순히 print the leading character니까 한번 반복할 때 시간 복잡도는 O(1)
    * O(printReverse) = n * O(1)
    * */

    /* Example 2: Execution Tree - Fibonacci Numbers
    * f(n) = f(n - 1) + f(n - 2)
    * n계층의 꽉 찬 binary tree를 가정했을 때 전체 node 개수를 f(n)라 한다면
    * f(n) = 2^n - 1 -> f(n)의 시간복잡도는 O(2^n)
    * */

}
