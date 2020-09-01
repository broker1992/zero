package com.zero.one.cell.NeuroTrans;

public class Mitter {

    String key;


    public Mitter() {
    }

    public Mitter(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Mitter{" +
                "key='" + key + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
