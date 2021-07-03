package platform.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/*
10026: 적록색약
 */
class BoardItem {

    private Integer rowIndex;
    private Integer colIndex;
    private Character color;

    public BoardItem(Integer rowIndex, Integer colIndex, Character color) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.color = color;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public Integer getColIndex() {
        return colIndex;
    }

    public Character getColor() {
        return color;
    }

}

public class Solution10026 {

    public static final int[] DELTA_ROW = {-1, 1, 0, 0};
    public static final int[] DELTA_COLUMN = {0, 0, -1, 1};

    public static int countBoardGroupByColor(char[][] board, boolean colorWeakness) {

        int numRow = board.length;
        int numCol = board[0].length;

        boolean[][] visited = new boolean[numRow][numCol];

        int counter = 0;

        for (int r = 0; r < numRow; r++) {
            for (int c = 0; c < numCol; c++) {

                if (visited[r][c]) {
                    continue;
                }

                Queue<BoardItem> queue = new LinkedList<>();
                queue.offer(new BoardItem(r, c, board[r][c]));

                while (!queue.isEmpty()) {
                    BoardItem boardItem = queue.poll();

                    int baseR = boardItem.getRowIndex();
                    int baseC = boardItem.getColIndex();

                    if (visited[baseR][baseC]) {
                        continue;
                    }
                    visited[baseR][baseC] = true;

                    for (int i = 0; i < 4; i++) {
                        int deltaR = DELTA_ROW[i];
                        int deltaC = DELTA_COLUMN[i];

                        int nextR = baseR + deltaR;
                        int nextC = baseC + deltaC;

                        // Out of boundary
                        if (nextR < 0 || nextC < 0 || nextR >= numRow || nextC >= numCol) {
                            continue;
                        }

                        // Already visited
                        if (visited[nextR][nextC]) {
                            continue;
                        }

                        // Not same color (consider colorWeakness)
                        if (board[nextR][nextC] != boardItem.getColor()) {
                            if (colorWeakness) {
                                // No Red or Green
                                if (board[nextR][nextC] == 'B' || boardItem.getColor() == 'B') {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }

                        queue.offer(new BoardItem(nextR, nextC, board[nextR][nextC]));

                    }

                }

                counter++;
            }
        }

        return counter;
    }

    public static String solution(char[][] board) {

        int originalCounter = countBoardGroupByColor(board, false);
        int weaknessCounter = countBoardGroupByColor(board, true);

        return originalCounter + " " + weaknessCounter;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bufferedReader.readLine());

        char[][] board = new char[size][size];
        for (int r = 0; r < size; r++) {
            String line = bufferedReader.readLine();

            for (int c = 0; c < size; c++) {
                board[r][c] = line.charAt(c);
            }
        }

        bufferedReader.close();

        String answer = solution(board);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(answer);

        bufferedWriter.close();

    }

}
