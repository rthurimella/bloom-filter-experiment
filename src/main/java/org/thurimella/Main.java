package org.thurimella;

import org.thurimella.datastructure.BST;
import org.thurimella.util.BloomFilter;

import java.util.Random;

public class Main {
    private static final int MAX_KEY = 9999999;
    private static final int NUM_ELEMENTS = 1000000;
    private static final int NUM_SEARCHES = 500000;
    private static final int FILTER_SIZE_BITS = 12000000;

    public static void main(String[] args) {
        // Create BST and Bloom Filter
        BST bst = new BST();
        // Create another BST to see the set creation time without the filter
        BST bstWithoutFilter = new BST();

        BloomFilter filter = new BloomFilter(FILTER_SIZE_BITS);

        // Step 1: Create a set S and store it in BST T
        createSetAndStoreInBST(bst, bstWithoutFilter, filter);

        // Step 2: Perform random searches and print search time
        performRandomSearches(bst, filter);
    }

    private static void createSetAndStoreInBST(BST bst, BST bstWithoutFilter, BloomFilter filter) {
        Random random = new Random();
        long startTime, endTime;
        double elapsedTime;

        //create the set without Bloom filter
        startTime = System.nanoTime();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            int randomInteger = random.nextInt(MAX_KEY + 1);
            bstWithoutFilter.insert(randomInteger);
        }
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime) / 1_000_000.0;
        System.out.println();
        System.out.println("Set creation *without* Bloom Filter took: " + elapsedTime + " milliseconds");

        //create the set along with the Bloom filter
        startTime = System.nanoTime();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            int randomInteger = random.nextInt(MAX_KEY + 1);
            bst.insert(randomInteger);
            filter.insertElement(randomInteger);
        }
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Set creation *with* Bloom Filter took: " + elapsedTime + " milliseconds");
        System.out.println();
    }

    private static void performRandomSearches(BST bst, BloomFilter filter) {
        Random random = new Random();
        long startTime, endTime;
        double elapsedTime;
        int noOfFalsePositives = 0;

        // Search without using Bloom Filter
        startTime = System.nanoTime();
        for (int i = 0; i < NUM_SEARCHES; i++) {
            int searchValue = random.nextInt(MAX_KEY + 1);
            bst.found(searchValue);
        }
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Search *without* Bloom Filter took: " + elapsedTime + " milliseconds");

        // Search using Bloom Filter
        startTime = System.nanoTime();
        for (int i = 0; i < NUM_SEARCHES; i++) {
            int searchValue = random.nextInt(MAX_KEY + 1);
            if (filter.presentElement(searchValue)) {
                if (!bst.found(searchValue)) noOfFalsePositives++;
            }
        }
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Search *with* Bloom Filter took: " + elapsedTime + " milliseconds");
        System.out.println();

        System.out.println("Number of False Positives: " + noOfFalsePositives + " or " + (noOfFalsePositives * 100/NUM_SEARCHES) + "%");

    }
}

