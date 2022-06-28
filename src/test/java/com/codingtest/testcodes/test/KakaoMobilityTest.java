package com.codingtest.testcodes.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class KakaoMobilityTest {
    public String solution(String S, String C) {
        String answer = "";

        List<String> emails = new ArrayList<>();
        String[] fullNames = S.split(", ");
        for(String fullName : fullNames){
            String[] partNames = fullName.replace("-","").split(" ");
            String email = "";
            for(int j = 0 ; j < partNames.length - 1; j++){
                email += partNames[j].substring(0,1).toLowerCase(Locale.ROOT);
            }
            String lastName = partNames[partNames.length - 1];
            email += lastName.substring(0,lastName.length()-1 < 8 ? lastName.length() : 8 ).toLowerCase(Locale.ROOT);
            String original = email;
            int number = 2;
            while (emails.contains(email)){
                email = original + number;
                number++;
            }
            emails.add(email);
            email += "@"+C.toLowerCase(Locale.ROOT)+".com";
            answer += fullName + " <"+ email + ">, ";
        }
        return answer.substring(0, answer.length() - 2);
    }

    @Test
    void testSolution2(){
        String a = this.solution(
                "John Doe",
                "Example"
        );
        assert a.equals("John Doe <jdoe@example.com>");
    }
    @Test
    void testSolution(){
        String a = this.solution(
"John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker",
                "Example"
        );
        System.out.println(a);
        assert a.equals("John Doe <jdoe@example.com>, " +
                "Peter Parker <pparker@example.com>, " +
                "Mary Jane Watson-Parker <mjwatsonpa@example.com>, " +
                "James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>, " +
                "Jane Doe <jdoe3@example.com>, Penny Parker <pparker2@example.com>");
    }

}
