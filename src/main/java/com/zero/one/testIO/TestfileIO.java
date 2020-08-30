package com.zero.one.testIO;

import com.zero.one.cell.first.Neure_first_1;

import java.util.Scanner;

/*
* create memery
* */
public class TestfileIO {

    public static void main(String[] args) {

        //获取输入，并传递给第一层的神经元
        while(true){

            Scanner scan = new Scanner(System.in);
            if (scan.hasNext()) {
                String str = scan.next();
                char[] strs = str.toCharArray();
                for (int i = 0; i < strs.length; i++) {
                    String input = strs[i]+"";

                        Neure_first_1 neure_first_1 = new Neure_first_1();
                        neure_first_1.dendrite_1(input);

                }

            }

        }

        

    }

}

