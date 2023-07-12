package org.thurimella.util;

import java.util.BitSet;

public class BloomFilter {
    private BitSet filter;
    private int filterSize;

    public BloomFilter(int filterSizeBits) {
        filter = new BitSet(filterSizeBits);
        filterSize = filterSizeBits;
    }

    public void insertElement(int value) {
        int hash1 = value % filterSize;
        int hash2 = (value * 2) % filterSize;

        filter.set(hash1);
        filter.set(hash2);
    }

    public boolean presentElement(int value) {
        int hash1 = value % filterSize;
        int hash2 = (value * 2) % filterSize;

        return filter.get(hash1) && filter.get(hash2);
    }
}

