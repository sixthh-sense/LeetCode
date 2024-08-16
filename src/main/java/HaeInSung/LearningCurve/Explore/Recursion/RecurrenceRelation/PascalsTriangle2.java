package HaeInSung.LearningCurve.Explore.Recursion.RecurrenceRelation;

import java.util.ArrayList;
import java.util.List;

/* 파스칼의 삼각형 공식 1 -> 1, 1, -> 1, 3, 3, 1 식으로 증가하는 '삼각형'
* 몇줄인지 입력을 하면 마지막 줄에 해당하는 row number들이 좌르륵 나오게 하기 */

public class PascalsTriangle2 {

    /* 이렇게 하는 게 가장 직관적이지만 time limit exceed 떠버림 */
    /* 리트코드 문제에 통과하려면 dynamic programming 을 이용해 마지막 줄의 정보를 구하는 방식으로만 가야 하는데 이후 복습해야 할 부분 */
    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();

        // n번째 인덱스에서 추가되는 요소를 반환값에 더하기
        for (int i = 0; i <= rowIndex; i++) {
            result.add(getPascal(i, rowIndex));
        }

        return result;
    }

    public Integer getPascal(int colIndex, int rowIndex) {
        // 가장자리에 있는 애들은 1로 처리
        if (rowIndex == 0 || rowIndex == colIndex || colIndex == 0) {
            return 1;
        }

        // 나머지는 삼각형
        // 1
        // 1    1
        // 1    2   1 -> 여기서 2가 어디서 뭐가 어떻게 더해지는지를 고려해봤을 때
        return getPascal(colIndex - 1, rowIndex - 1) + getPascal(colIndex, rowIndex - 1);
    }

    public static void main(String[] args) {
        List<Integer> rowIndexes = new ArrayList<>(List.of(3, 0, 1));

        PascalsTriangle2 recursion = new PascalsTriangle2();
        for (Integer index : rowIndexes) {
            System.out.println(recursion.getRow(index));
        }
    }
}
