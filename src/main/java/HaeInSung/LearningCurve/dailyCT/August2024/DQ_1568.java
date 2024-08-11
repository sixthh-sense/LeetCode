package HaeInSung.LearningCurve.dailyCT.August2024;

import java.util.ArrayList;
import java.util.List;

/* Minimum Number of Days to Disconnect Island */
/* 2024.08.11 ~ 2024.08.12 기준 LeetCode Editorial 답지 봄
> 여기 적는 건 내가 푼 문제가 아니라 Solution 이해 용도로 적은 코드 */
public class DQ_1568 {

    // Directions for adjacent cells: right, left, down, up
    private static final int[][] DIRECTIONS = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
    };

    public int minDays(int[][] grid) {
        int width = grid[0].length; // 가로길이
        int height = grid.length; // 세로길이

        // 초기 섬 개수를 세는 함수
        int initIslandCnt = countIslands(grid);

        // 이미 disconnected 상태거나 육지가 아닐 때
        if (initIslandCnt != 1) {
            return 0;
        }

        // 각 육지 cell 마다 떼어내는 걸 시도해보기
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 0) {
                    continue; // 물이면 스킵해야지
                }

                // 임시로 물로 바꿔두기
                grid[row][col] = 0;
                int newIslandCnt = countIslands(grid);

                // disconnected 여부 알아보기
                if (newIslandCnt != 1) { // 단번에 됐으니까 return 1
                    return 1;
                }

                // 임시로 육지 -> 바다 처리해놨던 부분 다시 육지로 돌려놓기
                grid[row][col] = 1;
            }
        }
        // 위의 for문에서 걸리지 않을 경우 최대 수는 무조건 2?
        return 2;
    }

    private int countIslands(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;

        boolean[][] visited = new boolean[height][width];
        int islandCnt = 0;

        // 모든 셀 대상으로 반복문 돌리기
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                // 새로운 섬을 찾을 경우
                if (!visited[row][col] && grid[row][col] == 1) {
                    exploreIsland(grid, row, col, visited);
                    islandCnt++;
                }
            }
        }
        return islandCnt;
    }

    // 섬의 모든 cell 들을 대상으로 탐색하는 메소드
    private void exploreIsland(int[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        // 인접한 모든 cell을 검사
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // 실재하는 육지 cell일 경우 탐색하기
            if (isValidLandCell(grid, newRow, newCol, visited)) {
                exploreIsland(grid, newRow, newCol, visited);
            }
        }
    }

    private boolean isValidLandCell(int[][] grid, int row, int col, boolean[][] visited) {
        int width = grid[0].length;
        int height = grid.length;

        // boundary 내에서 아직 탐색되지 않은 육지 여부 반환하기
        return (row >= 0 && col >= 0 && row < height && col < width && grid[row][col] == 1 && !visited[row][col]);
    }


    public static void main(String[] args) {

        DQ_1568 dailyQ = new DQ_1568();

        /* 1이 육지, 0이 땅. connected는 섬이 정확히 1개 있는 상태, disconnected는 그게 아닌 상태
        * 이런 식으로 육지/바다 정보가 있을 때, disconnected 상태가 되려면 최소한 며칠이 걸리는지 return하기
        * 하루에 한칸씩 1에서 0로 전환 가능
        *  */
        List<int[][]> gridList = new ArrayList<>();
        gridList.add(new int[][]{{0, 1, 1, 0}, {0, 1,1, 0}, {0, 0, 0, 0}});
        gridList.add(new int[][]{{1, 1}});

        for (int[][] grid : gridList) {
            System.out.println("result: " + dailyQ.minDays(grid));
        }
    }
}
