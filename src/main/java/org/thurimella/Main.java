package org.thurimella;

import org.thurimella.datastructure.BST;
import org.thurimella.model.Node;
import org.thurimella.util.RandomUtils;
import org.thurimella.util.BloomFilter;

import java.util.Random;

public class Main {
    private static final int MAX_KEY = 999999999;
    private static final int NUM_ELEMENTS = 1000000;
    private static final int NUM_SEARCHES = 100000;
    private static final int FILTER_SIZE_BITS = 12000000;

    public static void main(String[] args) {
        // Create BST and Bloom Filter
        BST bst = new BST();
        BloomFilter filter = new BloomFilter(FILTER_SIZE_BITS);

        // Step 1: Create set S and store it in BST T
        createSetAndStoreInBST(bst, filter);

        // Step 2: Perform random searches and print search time
        performRandomSearches(bst, filter);
    }

    private static void createSetAndStoreInBST(BST bst, BloomFilter filter) {
        Random random = new Random();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            int randomInteger = random.nextInt(MAX_KEY + 1);
            bst.insert(randomInteger);
            filter.insertElement(randomInteger);
        }
    }

    private static void performRandomSearches(BST bst, BloomFilter filter) {
        Random random = new Random();
        long startTime, endTime;
        double elapsedTime;

        // Search without using Bloom Filter
        startTime = System.nanoTime();
        for (int i = 0; i < NUM_SEARCHES; i++) {
            int searchValue = random.nextInt(MAX_KEY + 1);
            bst.found(searchValue);
        }
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Search without Bloom Filter took: " + elapsedTime + " milliseconds");

        // Search using Bloom Filter
        startTime = System.nanoTime();
        for (int i = 0; i < NUM_SEARCHES; i++) {
            int searchValue = random.nextInt(MAX_KEY + 1);
            if (filter.presentElement(searchValue)) {
                bst.found(searchValue);
            }
        }
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Search with Bloom Filter took: " + elapsedTime + " milliseconds");
    }
}

