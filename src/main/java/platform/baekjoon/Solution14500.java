package platform.baekjoon;

import java.io.*;

/*
14500: 테트로미
 */
class Position {
    int positionRow;
    int positionColumn;

    public Position(int positionRow, int positionColumn) {
        this.positionRow = positionRow;
        this.positionColumn = positionColumn;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public int getPositionColumn() {
        return positionColumn;
    }
}

public class Solution14500 {

    private static int getShapeSum(int[] base, int[] shape, int[][] board) {
        int counter = 0;

        int numRow = shape[0];
        int numCol = shape[1];

        int baseRow = base[0];
        int baseCol = base[1];

        for (int r = 0; r < numRow; r++) {
            for (int c = 0; c < numCol; c++) {
                int rowIndex = baseRow + r;
                int colIndex = baseCol + c;

                if (rowIndex >= board.length || colIndex >= board[0].length) {
                    return -1;
                }

                counter += board[rowIndex][colIndex];
            }
        }

        return counter;
    }

    private static int getShapeSum(int[] base, int[] shape, int[][] board, Position[][] removalPositionArray) {
        int counter = getShapeSum(base, shape, board);
        if (counter == -1) {
            return counter;
        }

        int removalCounter = Integer.MAX_VALUE;
        for (int i = 0; i < removalPositionArray.length; i++) {
            int removalCounterTemp = 0;
            Position[] removalPosition = removalPositionArray[i];

            for (int j = 0; j < removalPosition.length; j++) {
                int rowIndex = base[0] + removalPosition[j].getPositionRow();
                int colIndex = base[1] + removalPosition[j].getPositionColumn();

                removalCounterTemp += board[rowIndex][colIndex];
            }

            removalCounter = Math.min(removalCounter, removalCounterTemp);
        }

        return counter - removalCounter;
    }

    public static int solution(int[][] board) {

        int maxCounter = 0;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {

                int[] base = {r, c};
                int[] shape = new int[2];

                // 4x1 shape
                shape[0] = 4;
                shape[1] = 1;
                int counter = getShapeSum(base, shape, board);
                if (counter != -1) {
                    maxCounter = Math.max(maxCounter, counter);
                }

                // 2x2 shape
                shape[0] = 2;
                shape[1] = 2;
                counter = getShapeSum(base, shape, board);
                if (counter != -1) {
                    maxCounter = Math.max(maxCounter, counter);
                }

                // 1x4 shape
                shape[0] = 1;
                shape[1] = 4;
                counter = getShapeSum(base, shape, board);
                if (counter != -1) {
                    maxCounter = Math.max(maxCounter, counter);
                }


                // 2x3 shape
                shape[0] = 2;
                shape[1] = 3;
                Position[][] removedPositionArrayTwoByThree = {
                        {new Position(0, 0), new Position(0, 1)},
                        {new Position(0, 0), new Position(0, 2)},
                        {new Position(0, 0), new Position(1, 2)},
                        {new Position(0, 1), new Position(0, 2)},
                        {new Position(1, 0), new Position(0, 2)},
                        {new Position(1, 0), new Position(1, 1)},
                        {new Position(1, 0), new Position(1, 2)},
                        {new Position(1, 1), new Position(1, 2)},
                };
                counter = getShapeSum(base, shape, board, removedPositionArrayTwoByThree);
                if (counter != -1) {
                    maxCounter = Math.max(maxCounter, counter);
                }

                // 2x3 shape
                shape[0] = 3;
                shape[1] = 2;
                Position[][] removedPositionArrayThreeByTwo = {
                        {new Position(0, 0), new Position(1, 0)},
                        {new Position(0, 0), new Position(2, 0)},
                        {new Position(0, 0), new Position(2, 1)},
                        {new Position(0, 1), new Position(1, 1)},
                        {new Position(0, 1), new Position(2, 0)},
                        {new Position(0, 1), new Position(2, 1)},
                        {new Position(1, 0), new Position(2, 0)},
                        {new Position(1, 1), new Position(2, 1)}
                };
                counter = getShapeSum(base, shape, board, removedPositionArrayThreeByTwo);
                if (counter != -1) {
                    maxCounter = Math.max(maxCounter, counter);
                }
            }

        }

        return maxCounter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bufferedReader.readLine().split(" ");
        int numRow = Integer.parseInt(size[0]);
        int numCol = Integer.parseInt(size[1]);

        int[][] board = new int[numRow][numCol];
        for (int r = 0; r < numRow; r++) {
            String[] rowLine = bufferedReader.readLine().split(" ");
            for (int c = 0; c < numCol; c++) {
                board[r][c] = Integer.parseInt(rowLine[c]);
            }
        }

        bufferedReader.close();

        int answer = solution(board);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();

    }
}
