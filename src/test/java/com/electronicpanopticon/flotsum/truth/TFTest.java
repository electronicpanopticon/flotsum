package com.electronicpanopticon.flotsum.truth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TFTest {

    @Test public void toStringTest() {
        assertEquals("T", TF.of("yes").toString());
        assertEquals("T", TF.of("yAAAAAASS").toString());
        assertEquals("F", TF.of(0).toString());
    }
}
