package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution11726Test {

    @Test
    void 타일링_테스트_기본() {

        assertEquals(1, Solution11726.solution(1));
        assertEquals(2, Solution11726.solution(2));
        assertEquals(55, Solution11726.solution(9));

    }
}