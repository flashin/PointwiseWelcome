package com.gedevanishvili.pointwisewelcome.data;

/**
 * Created by flashin on 1/15/16.
 * Here are the configuration values for the data
 */
public final class MyConfig {

    /**
     * Standard string length of the tuple
     */
    public static final int tupleLength = 4;

    /**
     * min value for tuple weight
     */
    public static final int tupleMinWeight = 1;

    /**
     * max value for tuple weight
     */
    public static final int tupleMaxWeight = 10;

    /**
     * producer job interval
     */
    public static int T1 = 2 * 1000;

    /**
     * consumer job interval
     */
    public static int T2 = 3 * 1000;

}
