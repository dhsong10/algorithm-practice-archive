package platform.baekjoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class Solution17219Test {

    @Test
    void 뱀과_사다리_게임_테스트_기본1() {
        // given
        Solution17219.passwordMap.put("noj.am", "IU");
        Solution17219.passwordMap.put("acmicpc.net", "UAENA");
        Solution17219.passwordMap.put("startlink.io", "THEKINGOD");
        Solution17219.passwordMap.put("google.com", "ZEZE");
        Solution17219.passwordMap.put("nate.com", "VOICEMAIL");
        Solution17219.passwordMap.put("naver.com", "REDQUEEN");
        Solution17219.passwordMap.put("daum.net", "MODERNTIMES");
        Solution17219.passwordMap.put("utube.com", "BLACKOUT");
        Solution17219.passwordMap.put("zum.com", "LASTFANTASY");
        Solution17219.passwordMap.put("dreamwiz.com", "RAINDROP");
        Solution17219.passwordMap.put("hanyang.ac.kr", "SOMEDAY");
        Solution17219.passwordMap.put("dhlottery.co.kr", "BOO");
        Solution17219.passwordMap.put("duksoo.hs.kr", "HAVANA");
        Solution17219.passwordMap.put("hanyang-u.ms.kr", "OBLIVIATE");
        Solution17219.passwordMap.put("yd.es.kr", "LOVEATTACK");
        Solution17219.passwordMap.put("mcc.hanyang.ac.kr", "ADREAMER");

        List<String> questionList = Arrays.asList("startlink.io", "acmicpc.net", "noj.am", "mcc.hanyang.ac.kr");

        // when
        List<String> answerList = Solution17219.solution(questionList);

        // then
        List<String> expectedList = Arrays.asList("THEKINGOD", "UAENA", "IU", "ADREAMER");
        assertIterableEquals(expectedList, answerList);
    }
}