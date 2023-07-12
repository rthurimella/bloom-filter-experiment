package org.thurimella;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.thurimella.datastructure.BST;
import org.thurimella.model.Node;

public class BSTTest {
    @Test
    public void testInsert() {
        BST bst = new BST();
        Node root = null;

        root = bst.insert(root, 10);
        Assertions.assertNotNull(root);
        Assertions.assertEquals(10, root.data);
        Assertions.assertNull(root.left);
        Assertions.assertNull(root.right);

        root = bst.insert(root, 5);
        Assertions.assertNotNull(root);
        Assertions.assertEquals(10, root.data);
        Assertions.assertNotNull(root.left);
        Assertions.assertEquals(5, root.left.data);
        Assertions.assertNull(root.right);

        root = bst.insert(root, 15);
        Assertions.assertNotNull(root);
        Assertions.assertEquals(10, root.data);
        Assertions.assertNotNull(root.left);
        Assertions.assertEquals(5, root.left.data);
        Assertions.assertNotNull(root.right);
        Assertions.assertEquals(15, root.right.data);
    }

    // ... other test methods
}

