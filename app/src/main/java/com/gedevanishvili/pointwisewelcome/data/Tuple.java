package com.gedevanishvili.pointwisewelcome.data;

/**
 * Created by flashin on 1/15/16.
 * Class contains arbitrary string and its weight
 */
public class Tuple implements Comparable<Tuple> {

    private String str;
    private int weight;

    /**
     * Constructs object with specific values
     * @param str
     * @param weight
     */
    public Tuple(String str, int weight){

        this.str = str;
        this.weight = weight;
    }

    @Override
    public int compareTo(Tuple another) {

        if (weight < another.weight){
            return -1;
        }

        if (weight > another.weight){
            return 1;
        }

        return 0;
    }

    /**
     *
     * @return String value of the tuple
     */
    public String getString(){

        return str;
    }

    /**
     *
     * @return weight of the tuple
     */
    public int getWeight(){

        return weight;
    }

}
