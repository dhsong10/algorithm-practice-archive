package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

class Solution16928Test {

    @Test
    void 뱀과_사다리_게임_테스트_기본1() {
        // given
        Map<Integer, Integer> stairMap = new HashMap<>();
        stairMap.put(32, 62);
        stairMap.put(42, 68);
        stairMap.put(12, 98);

        Map<Integer, Integer> snakeMap = new HashMap<>();
        snakeMap.put(95, 13);
        snakeMap.put(97, 25);
        snakeMap.put(93, 37);
        snakeMap.put(79, 27);
        snakeMap.put(75, 19);
        snakeMap.put(49, 47);
        snakeMap.put(67, 17);

        // when
        int answer = Solution16928.solution(stairMap, snakeMap);

        // then
        assertEquals(3, answer);
    }

    @Test
    void 뱀과_사다리_게임_테스트_기본2() {
        // given
        Map<Integer, Integer> stairMap = new HashMap<>();
        stairMap.put(8, 52);
        stairMap.put(6, 80);
        stairMap.put(26, 42);
        stairMap.put(2, 72);

        Map<Integer, Integer> snakeMap = new HashMap<>();
        snakeMap.put(51, 19);
        snakeMap.put(39, 11);
        snakeMap.put(37, 29);
        snakeMap.put(81, 3);
        snakeMap.put(59, 5);
        snakeMap.put(53, 7);
        snakeMap.put(43, 33);
        snakeMap.put(77, 21);

        // when
        int answer = Solution16928.solution(stairMap, snakeMap);

        // then
        assertEquals(5, answer);
    }
}