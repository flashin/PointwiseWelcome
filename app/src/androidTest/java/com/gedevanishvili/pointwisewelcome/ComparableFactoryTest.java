package com.gedevanishvili.pointwisewelcome;

import android.test.InstrumentationTestCase;

import com.gedevanishvili.pointwisewelcome.data.ComparableFactory;
import com.gedevanishvili.pointwisewelcome.data.MyConfig;
import com.gedevanishvili.pointwisewelcome.data.Tuple;

/**
 * Created by flashin on 1/15/16.
 */
public class ComparableFactoryTest extends InstrumentationTestCase {

    public void testCreation(){

        int length = MyConfig.tupleLength;
        int min = MyConfig.tupleMinWeight;
        int max = MyConfig.tupleMaxWeight;

        Comparable Obj = ComparableFactory.getComparable("RandomTuple");

        assertTrue(Obj instanceof Tuple);

        Tuple Tuple = (Tuple) Obj;

        assertEquals(length, Tuple.getString().length());

        assertTrue(Tuple.getWeight() >= min);
        assertTrue(Tuple.getWeight() <= max);
    }
}
