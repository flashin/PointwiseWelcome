package com.gedevanishvili.pointwisewelcome;

import android.test.InstrumentationTestCase;

import com.gedevanishvili.pointwisewelcome.data.RandomGenerator;

/**
 * Created by flashin on 1/15/16.
 */
public class RandomTest extends InstrumentationTestCase {

    public void testRandomString(){

        int N = 30;

        for (int i = 1; i <= N; i++){
            String res = RandomGenerator.getArbitraryString(i);
            assertEquals(i, res.length());
        }
    }

    public void testRandomInt(){

        int N = 20;

        for (int i = 1; i <= N; i++){
            int max = 2 * i;
            int r = RandomGenerator.getRandomInt(i, max);

            assertTrue(r >= i);
            assertTrue(r <= max);
        }
    }
}
