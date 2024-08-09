package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Magic Squares in Grid */
public class DQ_0840 {

    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        int yLen = grid.length; // 세로 길이
        int xLen = grid[0].length; // 가로 길이
        if (xLen < 3 || yLen < 3) { // 가로나 세로나 둘 중 하나라도 3보다 작으면 magic square가 있을 가능성이 원천 차단 -> return 0
            return result;
        }
        // grid 중복 검사도 필요함(distinct) -> 그리고 1 ~ 9 수여야 함
        Set<Integer> gridSet = new HashSet<>();


        // 중심축이 될 수 있는 건 세로, 가로 모두 끝을 제외한 상태. 가로가 4라면 2부터 3까지 세로가 5라면 2부터 4까지
        // 그리고 그 중심축 기준으로 서로 끝의 쌍을 이루는 것들끼리 더했을 때 각각의 합이 같아야 함
        // 그리고 magic square라서 1 ~ 9로 구성되어있어야 함 -> 합은 45로 고정 -> 중심축이 되는 수를 뺐을 때 4로 나누어떨어져야 하니 중심축은 짝수가 될 수 없음
        for (int y = 1; y < yLen - 1; y++) {
            for (int x = 1; x < xLen - 1; x++) {
                int axis = grid[y][x]; // 여기서 변수를 일일이 지정해주는 대신 y -1 ~ y + 1, x - 1 ~ x + 1부터 반복문을 돌리는 식으로도 가능할 듯
//                System.out.println("axis: " + axis);
                if (axis % 2 == 1) { // 홀수일 때만 magic square 고려
                    int north = grid[y - 1][x];
                    int south = grid[y + 1][x];
                    int ns = north + south;

                    int west = grid[y][x - 1];
                    int east = grid[y][x + 1];
                    int ew = east + west;

                    int southWest = grid[y + 1][x - 1];
                    int northEast = grid[y - 1][x + 1];
                    int neSw = northEast + southWest;

                    int southEast = grid[y + 1][x + 1];
                    int northWest = grid[y - 1][x - 1];
                    int nwSe = southEast + northWest;

                    gridSet.add(axis);
                    gridSet.add(north);
                    gridSet.add(south);
                    gridSet.add(west);
                    gridSet.add(east);
                    gridSet.add(southWest);
                    gridSet.add(northEast);
                    gridSet.add(southEast);
                    gridSet.add(northWest);

//                    System.out.println("set size: " + gridSet.size());

//                    System.out.println("south: " + south + System.lineSeparator() + "north: " + north + System.lineSeparator() + "west: " + west + System.lineSeparator() + "east: " + east + System.lineSeparator() + "northWest: " + northWest + System.lineSeparator() + "northEast: " + northEast + System.lineSeparator() + "southWest: " + southWest + System.lineSeparator() + "southEast: " + southEast);

                    if (axis + ns + ew + neSw + nwSe == 45) {
                        if ((ns == ew) && (ns == neSw) && (ns == nwSe)) {
                            // 가로, 세로끼리도 합이 같아야 함
                            if (((ew + axis) == (northEast + northWest + north)) && ((ew + axis) == (southEast + southWest + south))) {
                                if (((ns + axis) == (northWest + southWest + west)) && ((ns + axis) == (northEast + southEast + east)) && gridSet.size() == 9) {
                                    boolean magic = true;
                                    for (Integer intValue : gridSet) { // 1 미만 9 초과 감지할 시 false 처리
                                        if (intValue < 1 || intValue > 9) {
                                            magic = false;
                                        }
                                    }
                                    if (magic) {
                                        result++;
                                    }
                                }
                            }
                        }
                    }
                    // 초기화 까먹지 말기
                    gridSet.clear();
                }
//                System.out.println("요소: " + grid[y][x]);
            }
        }
        return result;
    }

    /* 내가 구상한 게 아니라 LeetCode에서 추천해준 0ms짜리 풀이 */
    public int numMagicSquaresInside2(int[][] grid) {
        int result = 0;
        int yLen = grid.length;
        int xLen = grid[0].length;
        if (yLen < 3 || xLen < 3) {
            return result; // 변수 대신 그냥 0이라고 쓰는 게 더 직관적일까
        }
        for (int row = 0; row < yLen - 2; row++) {
            for (int col = 0; col < xLen - 2; col++) {
                if (isMagicSquare(grid, row, col)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10];
        // 3 * 3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9) {
                    return false;
                }
                if (seen[num]) {
                    return false;
                }
                // 이렇게 distinct 검사를 하는구나. 배우자!
                seen[num] = true;
            }
        }
        //여기서 대각선 합 검사
        int diagonal1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int diagonal2 = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];

        if (diagonal1 != diagonal2) {
            return false;
        }

        // 행들의 합이 대각선 합이랑 같은지 검사
        int row1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int row2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int row3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];

        if (!(row1 == diagonal1 && row2 == diagonal1 && row3 == diagonal1)) {
            return false;
        }

        // 열들의 합이 대각선 합이랑 같은지 검사
        int col1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int col2 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int col3 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];

        if (!(col1 == diagonal1 && col2 == diagonal1 && col3 == diagonal2)) {
            return false;
        }
        // false의 함정을 모두 돌파하면 true에 도달한다
        return true;
    }

    public static void main(String[] args) {
        DQ_0840 dailyQ = new DQ_0840();

        List<int[][]> gridList = new ArrayList<>();
        gridList.add(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}});
        gridList.add(new int[][]{{8}});
        gridList.add(new int[][]{{4, 7, 8}, {9, 5, 1}, {2, 3, 6}});
        gridList.add(new int[][]{{5, 5, 5}, {5, 5, 5}, {5, 5, 5}});
        gridList.add(new int[][]{{1, 8, 6}, {10, 5, 0}, {4, 2, 9}});
        gridList.add(new int[][]{{3,10,2,3,4}, {4,5,6,8,1}, {8,8,1,6,8},{1,3,5,7,1},{9,4,9,2,9}});

        for (int[][] grid : gridList) {
//            System.out.println(dailyQ.numMagicSquaresInside(grid));
            System.out.println(dailyQ.numMagicSquaresInside2(grid)); // prettier version
        }
    }
}
