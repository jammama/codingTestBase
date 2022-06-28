package com.codingtest.testcodes.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KakaoMobilityTest3 {
    public int solution(int[] T, int[] A) {
        int answer = 0;
        Set<Integer> skillSet = new HashSet<>();
        for (int skill : A) {
            int preReq = skill;
            while (preReq != 0) {
                skillSet.add(preReq);
                preReq = T[preReq];
            }
        }

        return skillSet.size()+1;
    }

    @Test
    void testSolution() {
        int a = this.solution(new int[]{0, 0, 1, 1}, new int[]{2});
        assert (a == 3);
    }

    @Test
    void testSolution2() {
        int b = this.solution(new int[]{0, 0, 0, 0, 2, 3, 3}, new int[]{2, 5, 6});
        assert (b == 5);
    }

    @Test
    void testSolution3() {
        int c = this.solution(new int[]{0, 0, 1, 2}, new int[]{1, 2});
        System.out.println(c);
        assert (c == 3);
    }

    @Test
    void testSolution4() {
        int d = this.solution(new int[]{0, 3, 0, 0, 5, 0, 5}, new int[]{4, 2, 6, 1, 0});
        assert (d == 7);
    }
}
