package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

class Solution1167Test {

    @Test
    void 트리의_지름_테스트_기본_1() {
        // given
        Map<Integer, Map<Integer, Integer>> tree = new HashMap<>();
        for (int node = 1; node <= 5; node++) {
            tree.put(node, new HashMap<Integer, Integer>());
        }
        tree.get(1).put(3, 2);
        tree.get(2).put(4, 4);
        tree.get(3).put(1, 2);
        tree.get(3).put(4, 3);
        tree.get(4).put(2, 4);
        tree.get(4).put(3, 3);
        tree.get(4).put(5, 6);
        tree.get(5).put(4, 6);

        // when
        int actual = Solution1167.solution(tree);

        // then
        assertEquals(11, actual);
    }
}