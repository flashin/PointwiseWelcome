package com.gedevanishvili.pointwisewelcome;

import android.test.InstrumentationTestCase;

import com.gedevanishvili.pointwisewelcome.data.MyConfig;
import com.gedevanishvili.pointwisewelcome.data.Tuple;
import com.gedevanishvili.pointwisewelcome.modules.PQManager;

/**
 * Created by flashin on 1/15/16.
 */
public class PQManagerTest extends InstrumentationTestCase {

    public void testPQOperations(){

        PQManager.getInstance().add();
        PQManager.getInstance().add();
        PQManager.getInstance().add();
        PQManager.getInstance().add();
        PQManager.getInstance().add();

        assertEquals(5, PQManager.getInstance().size());

        Tuple Tuple = (Tuple) PQManager.getInstance().poll();

        String str = Tuple.getString();
        int weight = Tuple.getWeight();
        assertEquals(MyConfig.tupleLength, str.length());
        assertTrue(weight >= MyConfig.tupleMinWeight);
        assertTrue(weight <= MyConfig.tupleMaxWeight);

        PQManager.getInstance().add(Tuple);

        Tuple = (Tuple) PQManager.getInstance().poll();

        assertEquals(weight, Tuple.getWeight());
    }
}
