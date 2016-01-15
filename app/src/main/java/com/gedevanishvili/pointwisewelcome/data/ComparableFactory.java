package com.gedevanishvili.pointwisewelcome.data;

/**
 * Created by flashin on 1/15/16.
 * This is the factory for comparable objects
 */
public class ComparableFactory {

    /**
     * creates Comparable object
     *
     * @param type by which factory decides what object it should return
     * @return returns created object
     */
    public static Comparable getComparable(String type) {

        if (type.equalsIgnoreCase("RandomTuple")) {

            int length = MyConfig.tupleLength;
            int min = MyConfig.tupleMinWeight;
            int max = MyConfig.tupleMaxWeight;

            Tuple Tuple = new Tuple(RandomGenerator.getArbitraryString(length), RandomGenerator.getRandomInt(min, max));
            return Tuple;
        }

        return null;
    }
}
