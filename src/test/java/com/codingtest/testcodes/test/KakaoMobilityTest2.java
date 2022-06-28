package com.codingtest.testcodes.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class KakaoMobilityTest2 {
    public int solution(int[] A) {
        int answer = 0;
        int size = A.length;
        for(int i = size ; i > 0 ; i--){
            for(int j = 0; j <= size - i ; j++){
                int[] tests = Arrays.copyOfRange(A,j,i);
                if(isSwiching(tests)){
                    return tests.length;
                }
            }
        }
        return answer;
    }
    private boolean isSwiching(int[] p) {
        if(p.length == 1)
            return true;
        if(p.length == 2)
            return p[0] == p[1];
        if(p.length == 3)
            return p[0] == p[2];

        int size = p.length;
        int first = p[0];
        int second = p[1];
        for (int i = 3; i < size; i += 2 ) {
            if (second != p[i]) {
                return false;
            }
        }
        for (int i = 2; i < size; i += 2 ) {
            if (first != p[i]) {
                return false;
            }
        }
        return true;
    }
    private boolean isPalin(int[] p) {
        int size = p.length;
        int half = 0;
        if (size % 2 == 0) {
            half = (size - 1) / 2;
        } else {
            half = size / 2;
        }
        for (int i = 0; i < half; i++) {
            if (p[i] != p[size - i - 1]) {
                return false;
            }
        }
        return true;
    }
    @Test
    void testSolution(){
        int a = this.solution(new int[]{3,2,3,2,3});
        assert(a == 5);
        int b = this.solution(new int[]{7, -5, -5, -5, 7, -1, 7});
        assert(b == 3);
    }

    @Test
    void testSolution2(){
        int b = this.solution(new int[]{7, -5, -5, -5, 7, -1, 7});
        assert(b == 3);
    }
}
