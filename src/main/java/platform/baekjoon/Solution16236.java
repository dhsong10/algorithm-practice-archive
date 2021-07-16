package platform.baekjoon;

import java.io.*;
import java.util.PriorityQueue;

/*
16236: 아기 상어
*/
public class Solution16236 {

    private static Shark shark = null;
    private static boolean[][] visited = null;
    private final static int[][] DELTA_POSITION = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private static void initializeShark(int[][] board) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 9) {
                    shark = new Shark(new Position(r, c), 2, 0);
                    board[r][c] = 0;
                    break;
                }
            }
        }

    } 

    private static void initializeVisited(int[][] board) {

        if (visited == null) {
            visited = new boolean[board.length][board[0].length];
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                visited[r][c] = false;
            }
        }

    }

    public static int solution(int[][] board) {

        initializeShark(board);

        initializeVisited(board);

        PriorityQueue<Item> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Item(shark.getPosition(), 0));

        int totalDistance = 0;

        while (!priorityQueue.isEmpty()) {
            Item currentItem = priorityQueue.poll();

            Position currentPosition = currentItem.getPosition();
            int currentRowIndex = currentPosition.getRowIndex();
            int currentColIndex = currentPosition.getColIndex();
            int currentDistance = currentItem.getDistance();

            if (visited[currentRowIndex][currentColIndex]) {
                continue;
            }
            visited[currentRowIndex][currentColIndex] = true;

            int fishSize = board[currentRowIndex][currentColIndex];
            if (fishSize > 0 && shark.getSize() > fishSize) {
                board[currentRowIndex][currentColIndex] = 0;

                shark.eatFish();

                totalDistance += currentDistance;

                initializeVisited(board);

                priorityQueue.clear();

                shark.setPosition(new Position(currentRowIndex, currentColIndex));
                currentDistance = 0;
                priorityQueue.offer(new Item(shark.getPosition(), currentDistance));
            }

            for (int i = 0; i < DELTA_POSITION.length; i++) {

                int deltaRowIndex = DELTA_POSITION[i][0];
                int deltaColIndex = DELTA_POSITION[i][1];

                int nextRowIndex = currentRowIndex + deltaRowIndex;
                int nextColIndex = currentColIndex + deltaColIndex;

                // out of boundary
                if (nextRowIndex < 0 || nextRowIndex >= board.length || nextColIndex < 0 || nextColIndex >= board[0].length) {
                    continue;
                }

                // already visited
                if (visited[nextRowIndex][nextColIndex]) {
                    continue;
                }

                // fish size bigger than shark size
                if (board[nextRowIndex][nextColIndex] > shark.getSize()) {
                    continue;
                }

                priorityQueue.offer(new Item(new Position(nextRowIndex, nextColIndex), currentDistance + 1));

            }
            
        }

        visited = null;

        return totalDistance;
        
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int boardSize = Integer.parseInt(bufferedReader.readLine());
        int[][] board = new int[boardSize][boardSize];

        for (int r = 0; r < boardSize; r++) {
            String[] row = bufferedReader.readLine().split(" ");
            for (int c = 0; c < boardSize; c++) {
                board[r][c] = Integer.parseInt(row[c]);
            }
        }
        bufferedReader.close();

        int answer = solution(board);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }

    static class Position implements Comparable<Position> {

        int rowIndex;
        int colIndex;

        public Position(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public int getColIndex() {
            return colIndex;
        }

        @Override
        public int compareTo(Position position) {
            if (this.getRowIndex() != position.getRowIndex()) {
                return this.getRowIndex() - position.getRowIndex();
            }

            if (this.getColIndex() != position.getColIndex()) {
                return this.getColIndex() - position.getColIndex();
            }

            return 0;
        }
    }

    static class Shark {

        Position position;
        int size;
        int counterFish;

        public Shark(Position position, int size, int counterFish) {
            this.position = position;
            this.size = size;
            this.counterFish = counterFish;
        }

        public Position getPosition() {
            return position;
        }

        public void setPosition(Position position) {
            this.position = position;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCounterFish() {
            return counterFish;
        }

        public void setCounterFish(int counterFish) {
            this.counterFish = counterFish;
        }

        public void eatFish() {
            int alreadyEatenFish = this.getCounterFish();
            int currentSize = this.getSize();
            if (alreadyEatenFish + 1 == this.getSize()) {
                this.setSize(currentSize + 1);
                this.setCounterFish(0);
            } else {
                this.setCounterFish(alreadyEatenFish + 1);
            }
        }
    }

    static class Item implements Comparable<Item> {

        Position position;
        int distance;

        public Item(Position position, int distance) {
            this.position = position;
            this.distance = distance;
        }

        public Position getPosition() {
            return position;
        }

        public int getDistance() {
            return distance;
        }


        @Override
        public int compareTo(Item item) {
            if (this.getDistance() != item.getDistance()) {
                return this.getDistance() - item.getDistance();
            }

            return this.getPosition().compareTo(item.getPosition());

        }
    }

}
