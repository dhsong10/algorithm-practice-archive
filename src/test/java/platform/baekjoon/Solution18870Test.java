package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution18870Test {

    @Test
    void 좌표_압축_테스트_기본1() {
        // given
        int[] numberArray = {2, 4, -10, 4, -9};

        // when
        int[] actual = Solution18870.solution(numberArray);

        // then
        int[] expected = {2, 3, 0, 3, 1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void 좌표_압축_테스트_기본2() {
        // given
        int[] numberArray = {1000, 999, 1000, 999, 1000, 999};

        // when
        int[] actual = Solution18870.solution(numberArray);

        // then
        int[] expected = {1, 0, 1, 0, 1, 0};
        assertArrayEquals(expected, actual);
    }

}