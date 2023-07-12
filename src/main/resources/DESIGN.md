# Bloom Filter Experiment

we can identify certain design principles and patterns that are present 
in the code:

## Separation of Concerns 
The code separates different concerns into 
 separate classes, such as the BloomFilter, BST, and RandomUtils 
 classes. Each class has a specific responsibility and encapsulates 
 related functionality.

## Single Responsibility Principle (SRP) 
 Each class has a single responsibility and focuses on performing 
 specific tasks. For example, the BloomFilter class is responsible 
 for creating and managing a Bloom filter, while the BST class 
 handles operations related to the binary search tree.

## Encapsulation 
 The classes encapsulate their internal state and 
 provide methods to interact with that state, promoting encapsulation 
 and information hiding.

## Modular Design 
 The code is organized into multiple files, 
 each representing a distinct class with a specific purpose. 
 This modular approach improves code organization, readability, 
 and maintainability.

 While the provided code does not adhere to a specific architectural 
 pattern like model-view-control (MVC), it does take into account the 
 above listed best practices in software development 
