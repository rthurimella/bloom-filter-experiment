# Bloom Filter Experiment

This project demonstrates the usage of a Bloom filter and binary search tree (BST) in Java. It generates a set of random elements, inserts them into a BST, and performs random searches using both the BST and a Bloom filter.

## Features

- Creates a set of 1,000,000 elements randomly drawn from the range [0, 999999999]
- Stores the elements in a binary search tree (BST)
- Performs 100,000 random searches on the BST and measures the time taken
- Creates a Bloom filter for the set and performs the same random searches, first checking the filter before searching in the BST

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/your-project-name.git

cd your-project-name

mvn clean install

java -jar target/your-project-name.jar

