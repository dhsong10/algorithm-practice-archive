package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution11659Test {

    @Test
    void 구간_합_구하기_4_테스트_기본() {

        // given
        int[] numbers = {5, 4, 3, 2, 1};

        // when
        int[][] testCase = {
                {1, 3},
                {2, 4},
                {5, 5},
                {1, 5},
                {4, 5},
                {1, 1}
        };
        int[] expected = {12, 9, 1, 15, 3, 5};

        // when & then
        assertArrayEquals(expected, Solution11659.solution(testCase, numbers));

    }

    @Test
    void 구간_합_구하기_4_테스트_특수1() {

        // given
        int[] numbers = {5};

        // when
        int[][] testCase = {{1, 1}};
        int[] expected = {5};

        // when & then
        assertArrayEquals(expected, Solution11659.solution(testCase, numbers));

    }

    @Test
    void 구간_합_구하기_4_테스트_특수2() {

        // given
        int[] numbers = {1, 2};

        // when
        int[][] testCase = {{1, 1}, {1, 2}, {2, 2}};
        int[] expected = {1, 3, 2};

        // when & then
        assertArrayEquals(expected, Solution11659.solution(testCase, numbers));

    }
}