package platform.baekjoon;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Solution11723Test {

    @Test
    void 집합_테스트_기본() {
        // given & when & then
        try {
            Solution11723.setOperation("add 1");
            Solution11723.setOperation("add 2");

            assertEquals(1, Solution11723.setArray[1]);
            assertEquals(1, Solution11723.setArray[2]);
            assertEquals(0, Solution11723.setArray[3]);

            Solution11723.setOperation("remove 2");
            assertEquals(1, Solution11723.setArray[1]);
            assertEquals(0, Solution11723.setArray[2]);

            Solution11723.setOperation("toggle 3");
            assertEquals(1, Solution11723.setArray[1]);
            assertEquals(0, Solution11723.setArray[2]);
            assertEquals(1, Solution11723.setArray[3]);
            assertEquals(0, Solution11723.setArray[4]);

            Solution11723.setOperation("all");
            assertEquals(1, Solution11723.setArray[10]);
            assertEquals(1, Solution11723.setArray[20]);

            Solution11723.setOperation("toggle 10");
            Solution11723.setOperation("remove 20");
            assertEquals(0, Solution11723.setArray[10]);
            assertEquals(0, Solution11723.setArray[20]);

            Solution11723.setOperation("empty");
            assertEquals(0, Solution11723.setArray[1]);

            Solution11723.setOperation("toggle 1");
            assertEquals(1, Solution11723.setArray[1]);

            Solution11723.setOperation("toggle 1");
            assertEquals(0, Solution11723.setArray[1]);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}