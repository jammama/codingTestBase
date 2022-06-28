package com.codingtest.testcodes.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.OptionalInt;

public class KakaoMobilityTestDemo {
    public int solution(int[] A) {
        OptionalInt max = Arrays.stream(A).max();
        int maxA = max.getAsInt();
        boolean isExist = false;
        for (int i = 1 ; i <= maxA ; i++){
            for(int a : A){
                if(a == i){
                    isExist = true;
                    break;
                }else {
                    isExist = false;
                }
            }
            if(!isExist) {
                return i;
            }
        }
        return maxA+1;
        // write your code in Java SE 8
    }
    @Test
    void testSolution(){
        int a = this.solution(new int[]{5, 3, 1, 2, 7});
        assert(a == 4);
    }
}
