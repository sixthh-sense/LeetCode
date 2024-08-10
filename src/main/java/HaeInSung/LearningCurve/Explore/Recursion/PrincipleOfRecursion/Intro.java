package HaeInSung.LearningCurve.Explore.Recursion.PrincipleOfRecursion;

public class Intro {
    /* Recursion은 한국말로 재귀라고 부릅니당
    * 그리고 재귀를 이용해서 문제를 풀 때는
    * 1. 무한 재귀에 빠지지 않게끔 terminating scenario를 고려해야 하고
    * 2. recurrence relation > base case로 향하게끔 재귀가 도는 방향을 고려해야 한대용
    * (recurrence relation이 뭔지 좀더 정확히 알아볼 필요가 있음)
    *
    * */

    /* Print the string in reverse order > 그냥 for문을 돌린다고 생각하면 쉬운데
    재귀로 푼다고 생각하니까 갑자기 어려워지는 기분 */

    private static void printReverse(char[] str) {
        reverseHelper(str.length, str); // str만으로는 힘들고 cursor 역할을 하는 애까지 같이 인자로 주어야 재귀가 돌아간다
    }

    private static void reverseHelper(int index, char[] str) {
        if (str == null || index <= 0) {
            return;
        }
        System.out.println(str[index - 1]);
        reverseHelper(index - 1, str);
    }

    public static void main(String[] args) {
        // testCase 없어서 그냥 임의로 지정함
        char[] charArr = new char[]{'a', 'b', 'c', 'd', 'e'}; // char은 섬세한 아이라 ""가 아니라 ''로 정의해줘야 함!
        
        printReverse(charArr);
    }
}
