import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BloomFilterTest {

    @Test
    public void testBloomFilterInsertAndPresent() {
        BloomFilter bloomFilter = new BloomFilter(100);

        // Insert elements into the Bloom filter
        bloomFilter.insertElement(10);
        bloomFilter.insertElement(20);
        bloomFilter.insertElement(30);

        // Check if elements are present
        Assertions.assertTrue(bloomFilter.isPresent(10));
        Assertions.assertTrue(bloomFilter.isPresent(20));
        Assertions.assertTrue(bloomFilter.isPresent(30));

        // Check if non-existent elements are not present
        Assertions.assertFalse(bloomFilter.isPresent(40));
        Assertions.assertFalse(bloomFilter.isPresent(50));
    }

    @Test
    public void testBloomFilterFalsePositives() {
        BloomFilter bloomFilter = new BloomFilter(100);

        // Insert elements into the Bloom filter
        bloomFilter.insertElement(10);
        bloomFilter.insertElement(20);
        bloomFilter.insertElement(30);

        // Check if false positives are minimal
        Assertions.assertFalse(bloomFilter.isPresent(40));
        Assertions.assertFalse(bloomFilter.isPresent(50));
    }
}

