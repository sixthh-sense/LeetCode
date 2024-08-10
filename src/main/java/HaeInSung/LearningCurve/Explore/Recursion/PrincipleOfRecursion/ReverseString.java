package HaeInSung.LearningCurve.Explore.Recursion.PrincipleOfRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 문제
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * */

/* Intro 문제와 매우 흡사하지만 기존 char[]을 변형시켜야 한다는 제약조건이 'trick part'라고 하네 */
public class ReverseString {
    public void reverseString(char[] s) {
//        reverseHelper(s, s.length);   // 이런 식으로 parameter 2개로는 해결이 안 되는 상황?!
        reverseHelper(0, s.length - 1, s); // 시작index, 끝index, 원본 char array 3개 인자를 준다
        // 제대로 바뀌었는지 확인용
        System.out.println("result: " + Arrays.toString(s));
    }

    public void reverseHelper(int start, int end, char[] arr) { // char[] arr, int index은 Intro 같은 문제에서나 쓰고
        if (start >= end) {
            return;
        }
        char temp = arr[start]; // O(1)는 얘를 위함? // 덮어쓸 start 정보를 기록해두는 변수
        arr[start] = arr[end]; // 위에서 start 정보를 기록해뒀으니 안심하고 start를 맨 끝자리로 덮어씀
        arr[end] = temp; // 순서를 바꾸는 게 목적이니 저장해뒀던 시작값을 끝값에다 줌

        /* temp를 반드시 arr[start]로 설정할 필요는 없음. 내키면 end 정보를 덮어쓰는 대신 그걸 미리 기록해두기
        char temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
        */

        // 위에서 한탕 끝냈으니 다음 걸로 넘어가기!
        reverseHelper(start + 1, end - 1, arr);
    }

    public static void main(String[] args) {

        ReverseString recursion = new ReverseString();

        List<char[]> charArrList = new ArrayList<>();
        charArrList.add(new char[]{'h', 'e', 'l', 'l', 'o'});
        charArrList.add(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});

        for (char[] charArr : charArrList) {
            recursion.reverseString(charArr);
        }
    }
}
