package com.electronicpanopticon.flotsum.truth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TruthTest {

    public Truth subject;

    @BeforeEach public void before() {
        subject = new Truth(true);
    }

    @Test public void truth() {
        assertTrue(subject.isTrue());
        assertFalse(new Truth(false).isTrue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"T", "true", "yeS", "1", "Yaaaaas", "Yaas", "affermative", "Yup"})
    public void of_string(String argument) {
        assertTrue(Truth.of(argument).isTrue());
    }

    @Test public void of_int() {
        assertTrue(Truth.of(1).isTrue());
        assertTrue(Truth.of(3).isTrue());
        assertFalse(Truth.of(0).isTrue());
    }

    @Test public void flip() {
        assertFalse(Truth.of("Yaaaaaaas").flip().isTrue());
        assertTrue(Truth.of("Nope").flip().isTrue());
    }

    @Test public void toString_true_truth() {
        assertEquals("True", Truth.of("yup").toString());
    }

    @Test public void toString_false_true() {
        assertEquals("False", Truth.of("nope").toString());
    }
}
