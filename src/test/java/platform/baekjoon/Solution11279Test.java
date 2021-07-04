package platform.baekjoon;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution11279Test {

    @Test
    void 최대_힙_테스트_기본() {

        // given
        List<Integer> commands = Arrays.asList(0, 1, 2, 0, 0, 3, 2, 1, 0, 0, 0, 0, 0);
        List<Integer> expected = Arrays.asList(0, 2, 1, 3, 2, 1, 0, 0);

        // when
        List<Integer> actual = Solution11279.solution(commands);

        // then
        assertIterableEquals(expected, actual);

    }
}