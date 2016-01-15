package com.gedevanishvili.pointwisewelcome.modules;

import com.gedevanishvili.pointwisewelcome.data.RandomGenerator;

/**
 * Created by flashin on 1/16/16.
 */
public class RandomErrorGenerator {

    /**
     * generates an error with 20% probability
     */
    public static void check(){

        int r = RandomGenerator.getRandomInt(1, 100);

        if (r <= 20){
            throw new RuntimeException("20% Error");
        }
    }
}
