package com.github.curriculeon.binarysearchtree;

import com.github.curriculeon.BinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
public class DeleteMinTest {
    @Test
    public void testDeleteMin() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(1, "one");
        bst.put(2, "two");
        bst.put(3, "three");
        bst.deleteMin();
        Assert.assertEquals(2, bst.size());
        Assert.assertNull(bst.get(1));
        Assert.assertNotNull(bst.get(2));
        Assert.assertNotNull(bst.get(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void testDeleteMinOnEmptyTree() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.deleteMin();
    }

    @Test
    public void testDeleteMinOnOneNodeTree() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(1, "one");
        bst.deleteMin();
        Assert.assertEquals(0, bst.size());
        Assert.assertNull(bst.getRoot());
    }

    @Test
    public void testDeleteMinOnTwoNodesTree() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(2, "two");
        bst.put(1, "one");
        bst.deleteMin();
        Assert.assertEquals(1, bst.size());
        Assert.assertNull(bst.get(1));
        Assert.assertNotNull(bst.get(2));
    }

}
