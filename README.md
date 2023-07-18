# Bloom Filter Experiment

Use Case: Support membership queries, i.e., whether x ∈ S, where S is too large to fit in main 
memory, e.g. checking availability of a username during registration. 
A Bloom filter can be a good data structure to speed up membership queries. 
The Bloom filter represents S and answers queries with high probability. For the query x ∈ S, if x ∉ S, the Bloom 
filter definitively answers no. However, if the Bloom filter answers yes, it is possible that x ∉ S, and a subsequent 
database lookup is required to confirm membership. This situation (called <em> false positive </em>) 
occurs infrequently assuming a good filter.

In this code, instead of storing S in a database, we will store it in a binary search tree (BST). Lookups in a BST approximate the database latency. The BST is built by randomly choosing a set of elements and inserting them in a random order. As a result, the BST is likely to be more or less balanced.

## Features

- Creates a set of 1,000,000 elements randomly drawn from the range [0, 999999999]
- Stores the elements in a binary search tree (BST)
- Performs 500,000 random searches on the BST and measures the time taken
- Creates a Bloom filter for the set and performs the same random searches, first checking the filter before searching in the BST

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/rthurimella/bloom-filter-experiment.git
   cd bloom-filter-experiment
   mvn clean install
   java -jar target/bloom-filter-experiment-1.0.0.jar

2. To run unit tests:
   ```bash
   mvn test
