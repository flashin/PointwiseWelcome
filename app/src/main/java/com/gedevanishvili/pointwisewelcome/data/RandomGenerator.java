package com.gedevanishvili.pointwisewelcome.data;

import java.util.Random;

/**
 * Created by flashin on 1/15/16.
 * This class is used to generate random values
 */
public class RandomGenerator {

    /**
     * generates random integer in a range
     * @param min is min value
     * @param max is max value
     * @return randomly generated integer
     */
    public static int getRandomInt(int min, int max){

        Random rand = new Random();

        int value = rand.nextInt(max - min + 1) + min;

        return value;
    }

    public static String getArbitraryString(int length){

        char initial = 'A';
        int alphabetLength = 26;

        Random rand = new Random();

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < length; i++){
            int r = rand.nextInt(alphabetLength);
            b.append((char) (initial + r));
        }

        return b.toString();
    }
}
