package com.zero.one;

import com.zero.one.cell.first.Neure_first_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class OneApplication {

    @Autowired
    private static Neure_first_1 neure_first_1;
    public static void main(String[] args) {
        SpringApplication.run(OneApplication.class, args);
        //获取输入，并传递给第一层的神经元
        while(true){

            Scanner scan = new Scanner(System.in);
            if (scan.hasNext()) {
                String str = scan.next();
                char[] strs = str.toCharArray();
                for (int i = 0; i < strs.length; i++) {
                    String input = strs[i]+"";

                    neure_first_1.dendrite_1(input);

                }

            }

        }

    }

}
