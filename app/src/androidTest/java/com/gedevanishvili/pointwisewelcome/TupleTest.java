package com.gedevanishvili.pointwisewelcome;

import android.test.InstrumentationTestCase;

import com.gedevanishvili.pointwisewelcome.data.RandomGenerator;
import com.gedevanishvili.pointwisewelcome.data.Tuple;

/**
 * Created by flashin on 1/15/16.
 */
public class TupleTest extends InstrumentationTestCase {

    public void testValues(){

        int weight = RandomGenerator.getRandomInt(1, 10);
        String str = RandomGenerator.getArbitraryString(4);

        Tuple Tuple = new Tuple(str, weight);

        assertEquals(weight, Tuple.getWeight());
        assertTrue(str.compareTo(Tuple.getString()) == 0);
    }

    public void testCompare(){

        Tuple First = new Tuple(RandomGenerator.getArbitraryString(4), 1);
        Tuple Second = new Tuple(RandomGenerator.getArbitraryString(4), 2);
        Tuple Third = new Tuple(RandomGenerator.getArbitraryString(4), 1);

        assertTrue(First.compareTo(Second) == -1);
        assertTrue(Second.compareTo(First) == 1);
        assertTrue(First.compareTo(Third) == 0);
    }
}
