package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class Solution1043Test {

    @Test
    void 거짓말_테스트_기본1() {
        // given
        List<Integer> knowTruthPeopleList = Arrays.asList();
        List<List<Integer>> partyList = Arrays.asList(
            Arrays.asList(1, 2), 
            Arrays.asList(3), 
            Arrays.asList(2, 3, 4)); 

        // when
        int actual = Solution1043.solution(4, knowTruthPeopleList, partyList);

        // then
        assertEquals(3, actual);
    }

    @Test
    void 거짓말_테스트_기본2() {
        // given
        List<Integer> knowTruthPeopleList = Arrays.asList(1);
        List<List<Integer>> partyList = Arrays.asList(
            Arrays.asList(1, 2, 3, 4)); 

        // when
        int actual = Solution1043.solution(4, knowTruthPeopleList, partyList);

        // then
        assertEquals(0, actual);
    }

    @Test
    void 거짓말_테스트_기본3() {
        // given
        List<Integer> knowTruthPeopleList = Arrays.asList();
        List<List<Integer>> partyList = Arrays.asList(
            Arrays.asList(1, 2, 3, 4)); 

        // when
        int actual = Solution1043.solution(4, knowTruthPeopleList, partyList);

        // then
        assertEquals(1, actual);
    }

    @Test
    void 거짓말_테스트_기본4() {
        // given
        List<Integer> knowTruthPeopleList = Arrays.asList(1);
        List<List<Integer>> partyList = Arrays.asList(
            Arrays.asList(1), 
            Arrays.asList(2), 
            Arrays.asList(3),
            Arrays.asList(4),
            Arrays.asList(4, 1)); 

        // when
        int actual = Solution1043.solution(4, knowTruthPeopleList, partyList);

        // then
        assertEquals(2, actual);
    }

    @Test
    void 거짓말_테스트_기본5() {
        // given
        List<Integer> knowTruthPeopleList = Arrays.asList(1, 2, 3, 4);
        List<List<Integer>> partyList = Arrays.asList(
            Arrays.asList(1, 5), 
            Arrays.asList(2, 6), 
            Arrays.asList(7),
            Arrays.asList(8),
            Arrays.asList(7, 8),
            Arrays.asList(9),
            Arrays.asList(10),
            Arrays.asList(3, 10),
            Arrays.asList(4)); 

        // when
        int actual = Solution1043.solution(10, knowTruthPeopleList, partyList);

        // then
        assertEquals(4, actual);
    }

    @Test
    void 거짓말_테스트_기본6() {
        // given
        List<Integer> knowTruthPeopleList = Arrays.asList(1, 2, 7);
        List<List<Integer>> partyList = Arrays.asList(
            Arrays.asList(3, 4), 
            Arrays.asList(5), 
            Arrays.asList(5, 6),
            Arrays.asList(6, 8),
            Arrays.asList(8)); 

        // when
        int actual = Solution1043.solution(8, knowTruthPeopleList, partyList);

        // then
        assertEquals(5, actual);
    }

    @Test
    void 거짓말_테스트_기본7() {
        // given
        List<Integer> knowTruthPeopleList = Arrays.asList(3);
        List<List<Integer>> partyList = Arrays.asList(
            Arrays.asList(1), 
            Arrays.asList(2), 
            Arrays.asList(1, 2), 
            Arrays.asList(1, 2, 3)); 

        // when
        int actual = Solution1043.solution(3, knowTruthPeopleList, partyList);

        // then
        assertEquals(0, actual);
    }

}