package com.electronicpanopticon.flotsum.truth;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
public class Truth {

    @Getter private final boolean isTrue;

    public static Truth of(String v) {
        switch (v.trim().toUpperCase()) {
            case "T":
            case "TRUE":
            case "POSITIVE":
            case "YES":
            case "YUP":
            case "Y":
            case "AFFERMATIVE":
            case "1":
                return new Truth(true);
            default:
                if (v.trim().toUpperCase().substring(0, 2).equals("YA"))
                    return new Truth(true);
        }
        return new Truth(false);
    }

    public static Truth of(boolean b) {
        return new Truth(b);
    }

    public static Truth of(int i) {
        return new Truth((i > 0));
    }

    @Override
    public String toString() {
        return isTrue ? "True" : "False";
    }

    public Truth flip() {
        return this.isTrue() ? Truth.of(false) : Truth.of(true);
    }
}
