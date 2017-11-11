package com.electronicpanopticon.flotsum.truth;

public class TF extends Truth {

    public TF(boolean b) {
        super(b);
    }

    public static TF of(boolean b) {
        return new TF(Truth.of(b).isTrue());
    }

    public static TF of(int i) {
        return new TF(Truth.of(i).isTrue());
    }

    public static TF of(String v) {
        return new TF(Truth.of(v).isTrue());
    }

    @Override
    public String toString() {
        return isTrue() ? "T" : "F";
    }
}
