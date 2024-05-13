package org.coungard.dagdiezel.filter;

public class NonZeroesIncluded {

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return Integer.parseInt(String.valueOf(other)) == 0;
    }
}
