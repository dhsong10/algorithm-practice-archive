package platform.baekjoon;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution11286Test {

    @Test
    void 절댓값_힙_테스트_기본() {
        // given
        List<Integer> commands = Arrays.asList(1 , -1, 0, 0, 0, 1, 1, -1, -1, 2, -2, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> expected = Arrays.asList(-1, 1, 0, -1, -1, 1, 1, -2, 2, 0);

        // when
        List<Integer> actual = Solution11286.solution(commands);

        // then
        assertIterableEquals(expected, actual);

    }
}